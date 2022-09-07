package com.gc.myapplication

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner


//
// Created by Code For Android on 10/08/22.
// Copyright (c) 2022 CFA. All rights reserved.
//

@Composable
fun DisposableEffectExample(lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current) {

    DisposableEffect(key1 = lifecycleOwner) {


        val observer = LifecycleEventObserver { _, event ->

            if (event == Lifecycle.Event.ON_RESUME) {
                println("On Resumed")
            } else if (event == Lifecycle.Event.ON_STOP) {
                println("On Stop")
            }


        }

        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }


    }


}