package com.luceroobispo.superestaurant.feature_restaurant.data.remote

typealias RestaurantResponseList = List<RestaurantResponse>
data class RestaurantResponse(
    val title: String,
    val poster: String
)
