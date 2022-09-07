package com.gc.myapplication

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlin.random.Random


class MainViewModel : ViewModel() {


    private val _sharedFlow = MutableSharedFlow<ScreenEvents>()
    val sharedFlow = _sharedFlow.asSharedFlow()


    init {
        viewModelScope.launch {
            _sharedFlow.emit(ScreenEvents.ShowSnackBar("I am snackBar"))
        }


    }

    sealed class ScreenEvents {
        data class ShowSnackBar(val message: String) : ScreenEvents()
        data class Navigate(val route: String) : ScreenEvents()

    }


}