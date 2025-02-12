package com.ahrorovk.roomclient

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahrorovk.roomclient.main.GetAllUsersUseCase
import com.ahrorovk.roomclient.main.InsertUserUseCase
import com.ahrorovk.roomclient.main.InsertUsersUseCase
import com.ahrorovk.roomclient.main.MainEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val insertUserUseCase: InsertUserUseCase,
    private val insertUsersUseCase: InsertUsersUseCase,
    private val getAllUsersUseCase: GetAllUsersUseCase
) : ViewModel() {
    val user: MutableState<MainEntity> = mutableStateOf(MainEntity(name = ""))
    val users: MutableList<MainEntity> = mutableListOf()
    val response = mutableStateOf("")
    val getAllUsers = mutableStateOf<List<MainEntity>>(emptyList())
    fun insertUser(): String {
        insertUserUseCase.invoke(user.value).onEach { result ->
            response.value = result
        }.launchIn(viewModelScope)

        return response.value
    }

    fun addUsers() {
        for (i in 0..10) {
            users.add(MainEntity(UUID.randomUUID().toString(), i))
        }
        insertUsersUseCase.invoke(users).onEach { result ->
            response.value = result
        }.launchIn(viewModelScope)
    }

    fun getAllUsers() {
        viewModelScope.launch {
            getAllUsers.value = getAllUsersUseCase.invoke() ?: emptyList()
        }
    }
}