package com.luceroobispo.superestaurant.feature_auth.ui.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.luceroobispo.superestaurant.ui.shared.ButtonPersonalized
import com.luceroobispo.superestaurant.ui.shared.CustomSubtitle
import com.luceroobispo.superestaurant.ui.shared.CustomTitle
import com.luceroobispo.superestaurant.ui.shared.InputTextField
import com.luceroobispo.superestaurant.ui.shared.PasswordTextField

@Composable
fun LogInScreen(navigateToSignUp: () -> Unit){

    //Create a mutable state for the username and password
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    //Create a scaffold to hold the input fields
    Scaffold{ paddingValues ->
        Column(modifier= Modifier
            .padding(paddingValues)
            .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            CustomTitle("Restaurants")
            CustomSubtitle("Log in")
            InputTextField(input = username, placeholder = "Username")
            PasswordTextField(password = password, placeholder = "Password")
            ButtonPersonalized(text = "Log in", {})
            Row(modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Text(text = "Does not have an account? ")
                TextButton(onClick = { navigateToSignUp() }) {
                    Text(text = "Create account")
                }
            }
        }
    }
}