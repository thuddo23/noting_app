package com.example.demo.main.controller

import com.example.demo.domain.dto.UserDTO
import com.example.demo.domain.model.Page
import com.example.demo.domain.model.User
import com.example.demo.domain.repository.PageRepository
import com.example.demo.domain.repository.UserRepository
import com.example.demo.main.exception.ResourceNotFoundException
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.ExampleObject
import io.swagger.v3.oas.annotations.responses.ApiResponse
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("/user")
class UserController {
    @Autowired
    private lateinit var userRepository: UserRepository
    @Autowired
    private lateinit var pageRepository: PageRepository

    @Operation(
        description = "Get all Users",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "Successfully get users!", // Changed to "users"
                content = [
                    Content(
                        mediaType = "application/json",
                        examples = [
                            ExampleObject(
                                value = """
                            {
                                "code" : 200, 
                                "Status": "OK", 
                                "Message" : "Successfully retrieved users!" 
                            }
                            """,
                            ),
                        ],
                    ),
                ],
            ),
        ],
    )
    @GetMapping
    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    @PostMapping
    fun createUser(@Valid @RequestBody user: UserDTO): ResponseEntity<User> {
        val convertedFromDTO = user.convertToEntity()
        val savedUser = userRepository.save(convertedFromDTO)

        val location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedUser.id)
            .toUri()
        return ResponseEntity.created(location).build()
    }

    @GetMapping(path = ["{userId}"])
    fun getUser(@PathVariable userId: Long): User {
        val userWithId = userRepository.findById(userId)
        if (userWithId.isEmpty) {
            throw ResourceNotFoundException(
                resourceName = "user",
                fieldName = "id",
                fieldValue = userId
            )
        }
        return userWithId.get()
    }

    @GetMapping("{id}/posts")
    fun getPageForUser(@PathVariable id: Long): List<Page> {
        /*return pageRepository.findByUserId(userId = userId)*/
        val user = userRepository.findById(id)
        if (user.isEmpty) {
            throw ResourceNotFoundException(
                resourceName = "user",
                fieldName = "id",
                fieldValue = id,
            )
        }
        return pageRepository.findAll()
    }

    @PostMapping("{id}/posts")
    fun createPageForUser(@PathVariable id: Long, @RequestBody page: Page): ResponseEntity<Page> {
        /*return pageRepository.findByUserId(userId = userId)*/
        val user = userRepository.findById(id)
        if (user.isEmpty) {
            throw ResourceNotFoundException(
                resourceName = "user",
                fieldName = "id",
                fieldValue = id,
            )
        }
        val savedPage = pageRepository.save(page)

        val location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedPage.id)
            .toUri()
        return ResponseEntity.created(location).build()
    }
}