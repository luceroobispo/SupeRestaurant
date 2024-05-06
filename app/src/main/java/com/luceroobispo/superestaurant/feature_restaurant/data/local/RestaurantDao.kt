package com.luceroobispo.superestaurant.feature_restaurant.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RestaurantDao {
    @Query("SELECT * FROM restaurants WHERE id = :id")
    fun fetchById(id: Int): RestaurantEntity?

    @Insert
    fun insert(restaurant: RestaurantEntity)

    @Delete
    fun delete(restaurant: RestaurantEntity)
}