package com.luceroobispo.superestaurant.feature_restaurant.ui.restaurant

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.luceroobispo.superestaurant.feature_restaurant.data.repository.RestaurantRepository
import com.luceroobispo.superestaurant.feature_restaurant.domain.Restaurant
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun RestaurantsListScreen(restaurantRepository: RestaurantRepository = RestaurantRepository()) {
    // Create a mutable state for the list of restaurants
    val restaurants = remember { mutableStateOf(emptyList<Restaurant>())}

    restaurantRepository.getRestaurants { restaurantsList ->
        restaurants.value = restaurantsList
    }

    // Create a scaffold to hold the list of restaurants
    Scaffold { paddingValues ->
        LazyColumn (modifier = Modifier.padding(paddingValues)) {
            items(restaurants.value) { restaurant ->
                RestaurantItem(restaurant)
            }
        }
    }
}

@Composable
fun RestaurantItem(restaurant: Restaurant) {
    Card(modifier = Modifier.padding(4.dp)){
        Row(modifier = Modifier.fillMaxWidth()){
            RestaurantImage(restaurant.url)
            Text(modifier = Modifier.padding(4.dp), text = restaurant.name)
        }
    }
}

@Composable
fun RestaurantImage(url: String) {
    GlideImage(modifier = Modifier.size(92.dp), imageModel = {url})
}
