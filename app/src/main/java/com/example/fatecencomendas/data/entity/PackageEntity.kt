package com.example.fatecencomendas.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.fatecencomendas.util.AppConstants
import java.time.LocalDateTime

@Entity(tableName = AppConstants.POST_TABLE)
data class PackageEntity(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = "arrivedDate") val arrivedDate: String,
    @ColumnInfo(name = "receiverName") val receiverName: String,
    @ColumnInfo(name = "addresseeId") val addresseeId: Int,
    @ColumnInfo(name = "pickupDate") val pickupDate: String,
)