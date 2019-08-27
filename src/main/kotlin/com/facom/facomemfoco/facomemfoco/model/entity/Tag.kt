package com.facom.facomemfoco.facomemfoco.model.entity

import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tags")
data class Tag(
        @Column(unique = true)
        @field:NotNull(message = "Não é possível criar uma Tag sem nome")
        @field:NotEmpty(message = "Nome da Tag não pode ser vazio.")
        val name: String?
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
}