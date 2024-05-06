package com.luceroobispo.superestaurant.feature_restaurant.data.remote

import com.luceroobispo.superestaurant.MyApplication
import com.luceroobispo.superestaurant.core_database.AppDatabase
import com.luceroobispo.superestaurant.feature_restaurant.data.local.RestaurantDao

class RestaurantDaoFactory private constructor() {
    companion object {
        fun getRestaurantDao(): RestaurantDao {
            return AppDatabase.getInstance(MyApplication.getContext()).getRestaurantDao()
        }
    }
}