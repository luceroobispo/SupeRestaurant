package com.luceroobispo.superestaurant.feature_restaurant.ui.restaurant

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.luceroobispo.superestaurant.feature_restaurant.data.repository.RestaurantRepository
import com.luceroobispo.superestaurant.feature_restaurant.domain.Restaurant
import com.luceroobispo.superestaurant.ui.theme.Cream
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
                RestaurantItem(
                    restaurant,
                    insert = {restaurantRepository.insertRestaurant(it)},
                    delete={restaurantRepository.deleteRestaurant(it)})
            }
        }
    }
}

@Composable
fun RestaurantItem(restaurant: Restaurant, insert: (Int)->Unit, delete: (Int)->Unit) {

    // Create a mutable state for the favorite status
    val isFavorite = remember { mutableStateOf(false) }
    isFavorite.value = restaurant.isFavorite //importante para mostrar el estado del favorito actual

    // Create a card to hold the restaurant information
    Card(modifier = Modifier.padding(4.dp)){
        Row(modifier = Modifier.fillMaxWidth()){
            RestaurantImage(restaurant.url)
            Text(modifier = Modifier.padding(4.dp).weight(3f), text = restaurant.name)
            IconButton(
                modifier = Modifier.weight(1f),
                onClick = {
                    isFavorite.value = !isFavorite.value
                    restaurant.isFavorite = isFavorite.value
                    if(isFavorite.value) {
                        insert(restaurant.id)
                    } else {
                        delete(restaurant.id)
                    }
                }) {
                Icon(
                    Icons.Filled.Favorite,
                    tint = if(isFavorite.value) Color.Red else Color.White,
                    contentDescription = "Favorite"
                )
            }
        }
    }
}

@Composable
fun RestaurantImage(url: String) {
    GlideImage(modifier = Modifier.size(92.dp), imageModel = {url})
}
