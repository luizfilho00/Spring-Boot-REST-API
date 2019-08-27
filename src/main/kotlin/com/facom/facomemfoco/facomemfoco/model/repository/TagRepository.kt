package com.facom.facomemfoco.facomemfoco.model.repository

import com.facom.facomemfoco.facomemfoco.model.entity.Tag
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TagRepository : CrudRepository<Tag, Long>
