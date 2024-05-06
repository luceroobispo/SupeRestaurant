package com.luceroobispo.superestaurant.feature_home.ui.home


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.luceroobispo.superestaurant.feature_auth.ui.login.LogInScreen
import com.luceroobispo.superestaurant.feature_auth.ui.signup.SignUpScreen

@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "LogIn"){
        composable("LogIn"){
            LogInScreen(
                navigateTo = {
                    navController.navigate("SignUp")
                }
            )
        }
        composable("SignUp"){
            SignUpScreen()
        }
    }
}