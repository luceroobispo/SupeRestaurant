package com.luceroobispo.superestaurant.feature_restaurant.data.remote

import com.luceroobispo.superestaurant.core_network.RetrofitFactory
class RestaurantServiceFactory private constructor() {
    companion object {
        fun getRestaurantService(): RestaurantService {
            return RetrofitFactory.getRetrofit().create(RestaurantService::class.java)
        }
    }
}