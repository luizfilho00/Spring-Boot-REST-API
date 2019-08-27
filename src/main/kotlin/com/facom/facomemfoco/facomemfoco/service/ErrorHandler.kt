package com.facom.facomemfoco.facomemfoco.service

import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest

/**
 * Controller de Erros
 * Responsável por tratar todos erros de requisições emitidos pelos RestControllers
 * Mapeia erros em um Map<Sring, Any> que é devolvido com status 401
 * Por padrão o App Android sempre recebe um array de erros em casos de exceções lançadas pela API
 */
@RestControllerAdvice
class ErrorHandler(val messageSource: MessageSource) {

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handle(exception: MethodArgumentNotValidException): Map<String, Any> {
        val errors = mutableMapOf<String, Any>()
        val fieldsError = exception.bindingResult.fieldErrors
        errors.put("errors", fieldsError.map {
            messageSource.getMessage(it, LocaleContextHolder.getLocale())
        })
        return errors
    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(value = [Exception::class])
    fun handleGeneric(exception: Exception, webRequest: WebRequest): ResponseEntity<String> {
        return ResponseEntity.badRequest().body("Bad Request!")
    }
}