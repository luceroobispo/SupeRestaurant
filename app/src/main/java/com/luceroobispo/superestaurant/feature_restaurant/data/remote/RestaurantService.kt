package com.luceroobispo.superestaurant.feature_restaurant.data.remote

import retrofit2.Call
import retrofit2.http.GET

// https://plain-marbled-muskox.glitch.me/restaurants

interface RestaurantService {
    @GET("restaurants")
    fun getRestaurants(): Call<RestaurantResponseList>
}