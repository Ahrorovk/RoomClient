package com.ahrorovk.roomclient.main

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class InsertUsersUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {
    fun invoke(data: List<MainEntity>): Flow<String> {
        return flow {
            try {
                "Success"
                mainRepository.insert(data)
            } catch (e: Exception) {
                "Error ${e.message}"
            }
        }
    }
}