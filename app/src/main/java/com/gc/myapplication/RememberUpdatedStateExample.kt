package com.gc.myapplication

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


//
// Created by Code For Android on 02/08/22.
// Copyright (c) 2022 CFA. All rights reserved.
//

@Composable
fun RememberUpdateStateEx() {
    var buttonText by remember {
        mutableStateOf("Unknown")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            onClick = { buttonText = "First button" },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green)
        ) {
            Text(text = "First")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { buttonText = "Second button" },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow)
        ) {
            Text(text = "Second")
        }

        UpdateTimer(buttonText = buttonText)
    }


}


@Composable
fun UpdateTimer(buttonText: String) {

    val timerDuration = 6000L
    println("Composing timer with text: $buttonText")

    val updatedButtonText by rememberUpdatedState(newValue = buttonText)

    LaunchedEffect(key1 = Unit, block = {

        startTimer(timerDuration) {
            println("Timer ended")
            println("Last button text was : $buttonText")
            println("Last button text after using rememberUpdatedState is : $updatedButtonText")

        }


    })


}