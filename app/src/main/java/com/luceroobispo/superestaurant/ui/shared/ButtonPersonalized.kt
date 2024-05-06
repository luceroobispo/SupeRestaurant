package com.luceroobispo.superestaurant.ui.shared

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ButtonPersonalized(text: String, onClick: () -> Unit){
    Button(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp),
        onClick = { onClick() }
    ) {
        Text(text = text)
    }
}