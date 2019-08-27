package com.facom.facomemfoco.facomemfoco.model.repository

import com.facom.facomemfoco.facomemfoco.model.entity.News
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface NewsRepository : CrudRepository<News, Long> {

    fun findAllByAuthorId(authorId: Long): List<News>
    fun findDistinctByTagsIdIn(ids: List<Long>): List<News>
}