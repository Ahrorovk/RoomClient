package com.ahrorovk.roomclient.main

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class InsertUserUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {
    fun invoke(data: MainEntity): Flow<String> {
        return flow {
            try {
                mainRepository.insert(data)
            } catch (e: Exception) {
                "Error ${e.message}"
            }
        }
    }
}