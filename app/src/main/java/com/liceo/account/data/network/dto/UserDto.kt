package com.liceo.account.data.network.dto

import kotlinx.serialization.Serializable

@Serializable // TODO 1a
data class UserDto(
    // TODO 1b
    val id: String? = null,
    // TODO 1c
    val fullname: String? = null,
    val email: String? = null,
    val password: String? = null,
    val birthdate: String? = null
)

@Serializable // TODO 1d
data class NewUserDto(
    // TODO 1e
    val fullname: String,
    val email: String,
    val password: String,
    val birthdate: String
)