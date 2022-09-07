package com.gc.myapplication

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


//
// Created by Code For Android on 31/07/22.
// Copyright (c) 2022 CFA. All rights reserved.
//

@Composable
fun rememberCoroutineScopeEx() {

    val scope = rememberCoroutineScope()

    var job: Job? by remember {
        mutableStateOf(null)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Button(onClick = {
            println("Timer started")
            job = scope.launch {
                try {
                    startTimer(6000) {
                        println("Timer Ended")
                    }

                } catch (ex: Exception) {
                    println("Timer cancelled")

                }


            }


        }) {
            Text(text = "Start Timer")
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = {
            println("Cancel Timer")
            job?.cancel()
        }) {

            Text(text = "Cancel Timer")
        }


    }


}




