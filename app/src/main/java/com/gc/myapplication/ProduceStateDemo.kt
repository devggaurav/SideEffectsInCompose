package com.gc.myapplication

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import kotlinx.coroutines.delay


//
// Created by Code For Android on 24/08/22.
// Copyright (c) 2022 CFA. All rights reserved.
//

@Composable
fun produceStateExample(timer: Int): State<Int> {

    return produceState(initialValue = 0) {

        while (value < timer) {
            delay(2000)
            value++
        }

    }


}