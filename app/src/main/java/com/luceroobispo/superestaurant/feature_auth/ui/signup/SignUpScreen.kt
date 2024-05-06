package com.luceroobispo.superestaurant.feature_auth.ui.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.luceroobispo.superestaurant.feature_auth.data.remote.UserRequest
import com.luceroobispo.superestaurant.feature_auth.data.repository.AuthRepository
import com.luceroobispo.superestaurant.ui.shared.ButtonPersonalized
import com.luceroobispo.superestaurant.ui.shared.CustomSubtitle
import com.luceroobispo.superestaurant.ui.shared.CustomTitle
import com.luceroobispo.superestaurant.ui.shared.InputTextField
import com.luceroobispo.superestaurant.ui.shared.PasswordTextField


@Composable
fun SignUpScreen(authRepository: AuthRepository = AuthRepository(), navigateToRestaurantsList: () -> Unit) {

    // Create mutable states for the user's first name, last name, username, password, and confirm password
    val firstName = remember { mutableStateOf("") }
    val lastName = remember { mutableStateOf("")}
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val confirmPassword = remember { mutableStateOf("") }

    // Create a scaffold to hold the input fields
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomTitle("Restaurants")
            CustomSubtitle("Sign up")
            InputTextField(input = firstName, placeholder = "First name")
            InputTextField(input = lastName, placeholder = "Last name")
            InputTextField(input = username, placeholder = "Username")
            PasswordTextField(password = password, placeholder = "Password")
            PasswordTextField(password = confirmPassword, placeholder = "Confirm password")
            ButtonPersonalized(
                text = "Sign up",
                onClick = {
                    val userRequest = UserRequest(
                        username = username.value,
                        lastName = lastName.value,
                        firstName = firstName.value,
                        password = password.value
                    )
                    authRepository.signUp(userRequest, {})
                    navigateToRestaurantsList()
                }
            )
        }
    }
}