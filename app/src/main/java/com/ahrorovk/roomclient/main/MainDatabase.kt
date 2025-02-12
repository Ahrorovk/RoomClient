package com.ahrorovk.roomclient.main

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [MainEntity::class],
    version = 1,
    exportSchema = false
)
abstract class MainDatabase : RoomDatabase() {
    abstract fun mainDao(): MainDao

    companion object{
        var INSTANCE: MainDatabase? = null
        fun getInstance(context: Context):MainDatabase{
            synchronized(this){
                if(INSTANCE == null){
                    INSTANCE= Room.databaseBuilder(
                        context,
                        MainDatabase::class.java,
                        "main_database"
                    ).build()
                }
                return INSTANCE!!
            }
        }
    }
}