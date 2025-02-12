package com.ahrorovk.roomclient.main

import javax.inject.Inject

class GetAllUsersUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {
    suspend fun invoke(): List<MainEntity>? {
        return mainRepository.getAllUsers()
    }
}