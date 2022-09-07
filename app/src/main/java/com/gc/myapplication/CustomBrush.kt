package com.gc.myapplication

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color


object CustomBrush {



    val vGradientYellowGreen = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFB6DC69),
            Color(0xFF57DB7A),
            Color(0xFF57DB7A)
        )
    )

    val hOrangeRedGradient = Brush.linearGradient(
        colors = listOf(
            Color(0xFFE95252),
            Color(0xFFDC69AE),

            )
    )


    val horizontalGradient =  Brush.horizontalGradient(
        0.7f to Color.Red,
        0.8f to Color.Green,
        0.2f to Color.Blue,
        startX = 0.0f,
        endX = 50.0f
    )
}