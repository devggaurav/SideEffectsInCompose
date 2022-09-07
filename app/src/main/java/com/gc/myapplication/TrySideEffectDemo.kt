package com.gc.myapplication

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


//
// Created by Code For Android on 15/08/22.
// Copyright (c) 2022 CFA. All rights reserved.
//

@Composable
fun TrySideEffect() {

    var timer by remember {
        mutableStateOf(0)
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Timer $timer", fontSize = MaterialTheme.typography.h2.fontSize)
    }

    SideEffect {
      //  Thread.sleep(1000)
    //    timer++
    }


}