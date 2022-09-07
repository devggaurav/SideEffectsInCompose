package com.gc.myapplication

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*


//
// Created by Code For Android on 24/08/22.
// Copyright (c) 2022 CFA. All rights reserved.
//

@Composable
fun DerivedStateOfExample() {

    var timer by remember {
        mutableStateOf(0)
    }

    val myTimer by derivedStateOf {
        "I am timer" + timer
    }


    Button(onClick = { timer++ }) {
        Text(text = myTimer)

    }


}