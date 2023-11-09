package com.example.fatecencomendas.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.fatecencomendas.util.AppConstants

@Entity(tableName = AppConstants.USER_TABLE)
data class UserEntity (
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "password") val password: String,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "userType") val userType: Int
)
