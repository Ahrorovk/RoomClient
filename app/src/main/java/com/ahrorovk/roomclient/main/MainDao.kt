package com.ahrorovk.roomclient.main

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface MainDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: MainEntity)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: List<MainEntity>)

    @Update
    suspend fun update(data: MainEntity)

    @Delete
    suspend fun delete(data: MainEntity)

    @Query("SELECT * FROM main_table WHERE name=:name")
    suspend fun getByName(name:String): List<MainEntity>?

    @Query("SELECT * FROM main_table")
    suspend fun getAllUsers(): List<MainEntity>?

    @Query("SELECT * FROM main_table WHERE id=:id")
    suspend fun getById(id:Int): MainEntity?
}