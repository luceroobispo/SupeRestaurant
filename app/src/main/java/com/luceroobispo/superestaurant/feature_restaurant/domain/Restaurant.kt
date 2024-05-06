package com.luceroobispo.superestaurant.feature_restaurant.domain

import com.luceroobispo.superestaurant.feature_restaurant.data.remote.RestaurantResponse

typealias RestaurantsList = List<Restaurant>
data class Restaurant (
    val id: Int,
    val name: String,
    val url: String,
    var isFavorite: Boolean = false
)