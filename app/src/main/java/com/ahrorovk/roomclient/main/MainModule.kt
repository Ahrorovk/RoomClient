package com.ahrorovk.roomclient.main

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

private const val DB_NAME = "room_client_db"

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Provides
    @Singleton
    @Named(value = DB_NAME)
    fun provideDatabaseName(): String {
        return DB_NAME//BuildConfig.DB_NAME
    }

    @Provides
    @Singleton
    fun provideDatabase(
        @Named(value = DB_NAME) dbname: String,
        @ApplicationContext context: Context
    ): MainDatabase {
        return Room.databaseBuilder(context, MainDatabase::class.java, dbname)
            .createFromAsset("$dbname.db")
            .enableMultiInstanceInvalidation()
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideMainDao(appDatabase: MainDatabase): MainDao {
        return appDatabase.mainDao()
    }

    @Provides
    @Singleton
    fun provideMainRepository(mainDao: MainDao): MainRepository = MainRepositoryImpl(mainDao)
}