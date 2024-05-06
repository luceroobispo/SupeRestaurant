package com.luceroobispo.superestaurant.feature_home.ui.home


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.luceroobispo.superestaurant.feature_auth.ui.login.LogInScreen
import com.luceroobispo.superestaurant.feature_auth.ui.signup.SignUpScreen
import com.luceroobispo.superestaurant.feature_restaurant.ui.restaurant.RestaurantsListScreen

@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Restaurants"){
        composable("LogIn"){
            LogInScreen(
                navigateToSignUp = {
                    navController.navigate("SignUp")
                }
            )
        }
        composable("SignUp"){
            SignUpScreen(
                navigateToRestaurantsList = {
                    navController.navigate("Restaurants")
                }
            )
        }
        composable("Restaurants"){
            RestaurantsListScreen(
                navigateToLogIn = {
                    navController.navigate("LogIn")
                }
            )
        }
    }
}