package com.ahrorovk.roomclient.main

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = MainEntity.TABLE_NAME)
data class MainEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID) val id: Int? = null,
    @ColumnInfo(name = COLUMN_NAME) val name:String,
) {
    companion object {
        const val TABLE_NAME = "main_table"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
    }
}
