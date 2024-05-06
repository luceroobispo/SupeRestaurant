package com.luceroobispo.superestaurant.feature_restaurant.data.repository

import android.util.Log
import com.luceroobispo.superestaurant.feature_restaurant.data.local.RestaurantDao
import com.luceroobispo.superestaurant.feature_restaurant.data.remote.RestaurantDaoFactory
import com.luceroobispo.superestaurant.feature_restaurant.data.remote.RestaurantResponseList
import com.luceroobispo.superestaurant.feature_restaurant.data.remote.RestaurantService
import com.luceroobispo.superestaurant.feature_restaurant.data.remote.RestaurantServiceFactory
import com.luceroobispo.superestaurant.feature_restaurant.domain.Restaurant
import com.luceroobispo.superestaurant.feature_restaurant.domain.RestaurantsList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestaurantRepository (
        private val restaurantService: RestaurantService = RestaurantServiceFactory.getRestaurantService(),
        private val restaurantDao: RestaurantDao = RestaurantDaoFactory.getRestaurantDao()
    ) {
    fun getRestaurants(callback: (RestaurantsList) ->Unit) {
        val getRestaurants = restaurantService.getRestaurants()

        getRestaurants.enqueue(object : Callback<RestaurantResponseList> {
            override fun onResponse(call: Call<RestaurantResponseList>, response: Response<RestaurantResponseList>) {
                if (response.isSuccessful) {
                    val restaurantResponseList = response.body() as RestaurantResponseList
                    var restaurantsList: RestaurantsList = arrayListOf()

                    for (restaurantResponse in restaurantResponseList) {
                        restaurantsList = restaurantsList + Restaurant(restaurantResponse.title, restaurantResponse.poster)
                    }

                    callback(restaurantsList)
                }
            }

            override fun onFailure(call: Call<RestaurantResponseList>, t: Throwable) {
                t.message?.let {
                    Log.d("RestaurantRepository", it)
                }
            }

        })
    }
}