package com.gc.myapplication

import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.mapNotNull


//
// Created by Code For Android on 30/08/22.
// Copyright (c) 2022 CFA. All rights reserved.
//

@Composable
fun SnapShotFlowEx(){

    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = scaffoldState){
        snapshotFlow { scaffoldState.snackbarHostState
        }.mapNotNull { it.currentSnackbarData?.message }.distinctUntilChanged().collect { msg ->
            println("This is the message")
        }




    }



}