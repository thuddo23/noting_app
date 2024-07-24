package com.example.demo.main.controller

import com.example.demo.domain.model.Page
import com.example.demo.domain.model.UpdatedPage
import com.example.demo.domain.repository.PageRepository
import com.example.demo.main.exception.InvalidUpdateResourceException
import com.example.demo.main.exception.ResourceNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.util.*

@RestController
@RequestMapping("/page")
class PageController {

    @Autowired
    private lateinit var pageRepository: PageRepository

    @GetMapping(path = ["{userId}"])
    fun getPageWithUserId(@PathVariable userId: Long): List<Page> {
        return pageRepository.findByUserId(userId = userId)
    }

    @GetMapping
    fun getAllPages(): List<Page> = pageRepository.findAll()


    @PostMapping
    fun createPage(@RequestBody page: Page): ResponseEntity<Page> {
        val currentTime = Date()
        val savedPage = pageRepository.save(
            page.copy(
                updatedAt = currentTime,
                createdAt = currentTime,
            )
        )

        val location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedPage.id)
            .toUri()
        return ResponseEntity.created(location).build()
    }

    @PutMapping
    fun updatePage(@RequestBody page: UpdatedPage): ResponseEntity<Page> {
        val oldPage = pageRepository.findById(page.id)
        if (oldPage.isEmpty) {
            throw ResourceNotFoundException(
                resourceName = "page",
                fieldValue = page.id,
                fieldName = "id",
            )
        }
        if (oldPage.get().userId != page.userId) {
            throw InvalidUpdateResourceException(
                resourceName = "page",
                fieldValue = page.id,
                fieldName = "id",
            )
        }
        val updatedPage = pageRepository.save(
            oldPage.get().copy(
                pageName = page.pageName,
                updatedAt = Date()
            )
        )

        val location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(updatedPage.id)
            .toUri()
        return ResponseEntity.created(location).build()
    }
}