package com.luceroobispo.superestaurant.feature_restaurant.domain

import com.luceroobispo.superestaurant.feature_restaurant.data.remote.RestaurantResponse

typealias RestaurantsList = List<Restaurant>
data class Restaurant (
    val name: String,
    val url: String
)