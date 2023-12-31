package com.example.fatecencomendas.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.fatecencomendas.data.entity.UserEntity
import com.example.fatecencomendas.util.AppConstants
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM ${AppConstants.USER_TABLE}")
    fun flowAll(): Flow<List<UserEntity>>

    @Query("SELECT * FROM ${AppConstants.USER_TABLE} WHERE email NOT LIKE '%@admin%'")
    fun flowAllNormalUsers(): Flow<List<UserEntity>>

    @Query("SELECT * FROM ${AppConstants.USER_TABLE} WHERE uid = :uid")
    fun findUserByUid(uid: String): Flow<UserEntity?>

    @Insert
    fun insert(user: UserEntity)
}