package com.luceroobispo.superestaurant.ui.shared

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.luceroobispo.superestaurant.ui.theme.OrangeDark

@Composable
fun CustomTitle(title: String) {
    Text(
        text = title,
        style = TextStyle(
            color = OrangeDark,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
        )
    )
}