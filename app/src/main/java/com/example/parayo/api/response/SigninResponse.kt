package com.example.parayo.api.response

data class SigninResponse (
    val token: String, val refreshToken: String,
    val username: String,
    val userId: Long
        )