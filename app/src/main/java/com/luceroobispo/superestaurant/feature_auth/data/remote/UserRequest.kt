package com.luceroobispo.superestaurant.feature_auth.data.remote

data class UserRequest (
    val username: String,
    val lastName: String,
    val firstName: String,
    val password: String
)