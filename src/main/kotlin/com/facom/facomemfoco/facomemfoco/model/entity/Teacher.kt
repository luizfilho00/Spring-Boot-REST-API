package com.facom.facomemfoco.facomemfoco.model.entity

import javax.persistence.*
import javax.validation.constraints.NotEmpty

@Entity
@Table(name = "teachers")
data class Teacher(
        @NotEmpty
        val name: String = "",
        val login: String = "",
        val password: String = ""
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
}