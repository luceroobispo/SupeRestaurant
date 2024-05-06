package com.luceroobispo.superestaurant.feature_auth.ui.login

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.luceroobispo.superestaurant.ui.shared.ButtonPersonalized
import com.luceroobispo.superestaurant.ui.shared.InputTextField

@Composable
fun LogInScreen(navigateTo: () -> Unit){

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
            InputTextField(input = username, placeholder = "Username")
            InputTextField(input = password, placeholder = "Password")
            ButtonPersonalized(text = "Log in", {})
            ButtonPersonalized(text = "Sign up", onClick = { navigateTo() })
        }
    }
}