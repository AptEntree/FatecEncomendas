package com.example.fatecencomendas.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.fatecencomendas.util.AppConstants

@Entity(tableName = AppConstants.USER_TABLE)
data class UserEntity (
    @PrimaryKey val uid: String,
    @ColumnInfo(name = "email") val email: String,
)
