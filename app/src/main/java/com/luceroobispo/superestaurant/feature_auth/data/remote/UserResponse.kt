package com.luceroobispo.superestaurant.feature_auth.data.remote

data class UserResponse (
    val id: String,
    val username: String,
    val lastName: String,
    val firstName: String,
    val password: String
)