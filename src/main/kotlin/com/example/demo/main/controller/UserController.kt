package com.example.demo.main.controller

import com.example.demo.domain.model.User
import com.example.demo.domain.repository.UserRepository
import com.example.demo.main.exception.ResourceNotFoundException
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

    @GetMapping
    fun getAllUsers() = userRepository.findAll()

    @PostMapping()
    fun createUser(@Valid @RequestBody user: User): ResponseEntity<User> {
        val savedUser = userRepository.save(user)

        val location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(user.id)
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
}
