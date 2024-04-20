package com.hello.test.service;

import org.springframework.stereotype.Service;

@Service
class UserService(private val userRepository: UserRepository, private val userAdapter: UserAdapter) {
    fun getUser(id: Long): UserDto {
        val userEntity = userRepository.findById(id).orElseThrow { RuntimeException("User not found") }
        return userAdapter.toDto(userEntity)
    }

    fun createUser(userDto: UserDto): UserDto {
        val userEntity = userAdapter.toEntity(userDto)
        val savedUser = userRepository.save(userEntity)
        return userAdapter.toDto(savedUser)
    }
}



