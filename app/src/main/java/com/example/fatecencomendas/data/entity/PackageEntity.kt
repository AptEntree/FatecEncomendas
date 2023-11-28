package com.example.fatecencomendas.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.fatecencomendas.util.AppConstants

@Entity(tableName = AppConstants.POST_TABLE)
data class PackageEntity(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = "arrivedDate") val arrivedDate: String,
    @ColumnInfo(name = "receiverEmail") val receiverEmail: String?,
    @ColumnInfo(name = "addresseeEmail") val addresseeEmail: String?,
    @ColumnInfo(name = "pickupDate") val pickupDate: String,
)