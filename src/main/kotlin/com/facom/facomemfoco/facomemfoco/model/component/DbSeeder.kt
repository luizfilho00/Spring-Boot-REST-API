package com.facom.facomemfoco.facomemfoco.model.component

import com.facom.facomemfoco.facomemfoco.model.entity.News
import com.facom.facomemfoco.facomemfoco.model.entity.Tag
import com.facom.facomemfoco.facomemfoco.model.repository.NewsRepository
import com.facom.facomemfoco.facomemfoco.model.repository.TagRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DbSeeder(
        val newsRepository: NewsRepository,
        val tagRepository: TagRepository
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        val tag1 = Tag("GERAL")
        val tag2 = Tag("SI")
        val tag3 = Tag("ES")
        val tag4 = Tag("CC")
        val tag5 = Tag("EC")
        val tag6 = Tag("TADS")
        val tag7 = Tag("REDES")
        tagRepository.saveAll(listOf(tag1, tag2, tag3, tag4, tag5, tag6, tag7))

        print("<--------------- Database initialized! --------->")
    }
}