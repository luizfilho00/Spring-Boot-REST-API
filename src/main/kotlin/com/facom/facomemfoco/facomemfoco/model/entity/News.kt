package com.facom.facomemfoco.facomemfoco.model.entity

import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Entity
@Table(name = "news")
data class News(
        @field:NotNull(message = "Não é possível criar uma notícia sem título.")
        @field:NotEmpty(message = "Título não pode ser vazio.")
        val title: String?,
        @field:NotNull(message = "Não é possível criar uma notícia sem corpo.")
        @field:NotEmpty(message = "Título não pode ser vazio.")
        val post: String?,
        @Column(nullable = false)
        val authorId: Long?,
        val image: String? = null,
        val link: String? = null,
        @ManyToMany(cascade = [CascadeType.ALL])
        @JoinTable(name = "news_tags",
                joinColumns = [JoinColumn(name = "news_id", referencedColumnName = "id")],
                inverseJoinColumns = [JoinColumn(name = "tag_id", referencedColumnName = "id")])
        var tags: List<Tag> = mutableListOf()
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
}