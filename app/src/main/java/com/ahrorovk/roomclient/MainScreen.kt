package com.ahrorovk.roomclient

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.delay
import java.util.UUID

@Composable
fun MainScreen(viewModel: MainViewModel = hiltViewModel()) {
    val user = remember { viewModel.user }
    val users = remember { viewModel.getAllUsers }
    LaunchedEffect(true) {
        viewModel.addUsers()
        delay(5000L)
        viewModel.getAllUsers()
    }
    val response = remember { viewModel.response }
    LazyColumn() {
        items(users.value) {
            Button({
                user.value = user.value.copy(name = UUID.randomUUID().toString())
                viewModel.insertUser()
                viewModel.getAllUsers()
            }) {
                Text(it.name)
            }
        }
    }
}