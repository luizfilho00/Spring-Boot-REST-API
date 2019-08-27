package com.facom.facomemfoco.facomemfoco.model.repository

import com.facom.facomemfoco.facomemfoco.model.entity.Teacher
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TeacherRepository : CrudRepository<Teacher, Long>
