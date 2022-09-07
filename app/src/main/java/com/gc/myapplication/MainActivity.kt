package com.gc.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gc.myapplication.CustomBrush.horizontalGradient
import com.gc.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    // KeyExample()
                   // rememberCoroutineScopeEx()
                    //RememberUpdateStateEx()

                    //DisposableEffectExample()
                      TrySideEffect()
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, mainViewModel: MainViewModel = viewModel(), time: Long = 0L) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        LaunchedEffect(key1 = true, block = {

            mainViewModel.sharedFlow.collect { events ->
                when (events) {
                    is MainViewModel.ScreenEvents.ShowSnackBar -> {


                    }


                }

            }


        })
    }
}


suspend fun startTimer(time: Long, onTimeEnd: () -> Unit) {

    delay(time)
    onTimeEnd()

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}

@Composable
fun KeyExample() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        var timerDuration by remember {
            mutableStateOf(2000L)
        }

        Button(onClick = { timerDuration -= 1000 }) {

            Text(text = "-1 Second")

        }

        Text(
            text = "Seconds $timerDuration",
            fontSize = MaterialTheme.typography.h1.fontSize,
            color = Color.Red
        )

        Button(onClick = { timerDuration += 1000 }) {
            Text(text = "+1 Second")

        }

        Greeting(name = "android", time = timerDuration)
    }


}