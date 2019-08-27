package com.facom.facomemfoco.facomemfoco.controller

import com.facom.facomemfoco.facomemfoco.model.entity.Teacher
import com.facom.facomemfoco.facomemfoco.model.repository.TeacherRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TeacherController(val repository: TeacherRepository) {

    @PostMapping("/teachers/signup")
    fun signup(@RequestBody teacher: Teacher) = repository.save(teacher)
}