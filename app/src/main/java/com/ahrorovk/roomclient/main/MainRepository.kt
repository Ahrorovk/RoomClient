package com.ahrorovk.roomclient.main

interface MainRepository{
    suspend fun insert(data: MainEntity)

    suspend fun insert(data: List<MainEntity>)

    suspend fun update(data: MainEntity)

    suspend fun delete(data: MainEntity)

    suspend fun getByName(name:String): List<MainEntity>?

    suspend fun getAllUsers(): List<MainEntity>?

    suspend fun getById(id:Int): MainEntity?
}
