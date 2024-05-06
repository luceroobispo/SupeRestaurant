package com.luceroobispo.superestaurant.ui.shared

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun CustomSubtitle(title: String) {
    Text(
        text = title,
        color = Color.Black,
        fontSize = 20.sp,
    )
}