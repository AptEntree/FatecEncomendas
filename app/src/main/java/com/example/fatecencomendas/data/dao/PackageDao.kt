package com.example.fatecencomendas.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.fatecencomendas.data.entity.PackageEntity
import com.example.fatecencomendas.util.AppConstants
import kotlinx.coroutines.flow.Flow

@Dao
interface PackageDao {
    @Query("SELECT * FROM ${AppConstants.POST_TABLE}")
    fun flowAll(): Flow<List<PackageEntity>>

    @Insert
    fun insert(post: PackageEntity)

    @Query("SELECT * FROM ${AppConstants.POST_TABLE} WHERE addresseeEmail = :email")
    fun flowPackageByUserEmail(email: String?): Flow<List<PackageEntity>>
}