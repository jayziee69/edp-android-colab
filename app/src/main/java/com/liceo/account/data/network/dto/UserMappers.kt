package com.liceo.account.data.network.dto

import com.liceo.account.domain.model.User

fun UserDto.toDomain(): User = User(
    id = id ?: "", // TODO 3a
    fullName = fullname?.trim() ?: "(no name)", // TODO 3b
    email = email?.trim() ?: "", // TODO 3c
    birthdate = birthdate ?: "(not set)" // TODO 3d
)