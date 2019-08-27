package com.facom.facomemfoco.facomemfoco.controller

import com.facom.facomemfoco.facomemfoco.model.entity.News
import com.facom.facomemfoco.facomemfoco.model.repository.NewsRepository
import com.facom.facomemfoco.facomemfoco.model.repository.TagRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class NewsController(
        val repository: NewsRepository,
        val tagRepository: TagRepository
) {

    @GetMapping("/news/{id}")
    fun findById(@PathVariable id: Long) = repository.findById(id)

    @GetMapping("/news/author/{authorId}")
    fun findByAuthor(@PathVariable authorId: Long?): List<News> {
        return authorId?.let(repository::findAllByAuthorId) ?: emptyList()
    }

    @GetMapping("/news{tags_ids}")
    fun findNewsByTagsId(@RequestParam("tags_ids", required = false) ids: List<Long>?): List<News> {
        return ids?.let(repository::findDistinctByTagsIdIn) ?: repository.findAll().toList()
    }

    @PostMapping("/news")
    fun postNews(@RequestBody @Valid news: News): ResponseEntity<News> {
        news.tags = tagRepository.findAllById(news.tags.map { it.id }).toList()
        return ResponseEntity.ok(repository.save(news))
    }
}