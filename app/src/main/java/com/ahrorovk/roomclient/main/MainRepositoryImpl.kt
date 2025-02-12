package com.ahrorovk.roomclient.main

import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    val mainDao: MainDao
) : MainRepository {
    override suspend fun insert(data: MainEntity) = mainDao.insert(data)

    override suspend fun insert(data: List<MainEntity>) = mainDao.insert(data)

    override suspend fun update(data: MainEntity) = mainDao.insert(data)

    override suspend fun delete(data: MainEntity) = mainDao.delete(data)

    override suspend fun getByName(name: String): List<MainEntity>? = mainDao.getByName(name)

    override suspend fun getAllUsers(): List<MainEntity>? = mainDao.getAllUsers()

    override suspend fun getById(id: Int): MainEntity? = mainDao.getById(id)
}