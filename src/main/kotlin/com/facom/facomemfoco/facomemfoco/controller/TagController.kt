package com.facom.facomemfoco.facomemfoco.controller

import com.facom.facomemfoco.facomemfoco.model.entity.Tag
import com.facom.facomemfoco.facomemfoco.model.repository.TagRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class TagController(val repository: TagRepository) {

    @GetMapping("/tags")
    fun findAll() = repository.findAll()

    @GetMapping("/tags/{id}")
    fun findById(@PathVariable id: Long) = repository.findById(id)

    @PostMapping("/tags")
    fun postTag(@RequestBody @Valid tag: Tag) {
        try{
            repository.save(tag)
        } catch(exception: Exception) {
            throw exception
        }
    }
}

