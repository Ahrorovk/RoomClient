package com.ahrorovk.roomclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ahrorovk.roomclient.main.MainDao
import com.ahrorovk.roomclient.main.MainDatabase
import com.ahrorovk.roomclient.main.MainEntity
import com.ahrorovk.roomclient.ui.theme.RoomClientTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RoomClientTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RoomClientTheme {
        Greeting("Android")
    }
}