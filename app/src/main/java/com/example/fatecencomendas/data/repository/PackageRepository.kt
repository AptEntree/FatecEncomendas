package com.example.fatecencomendas.data.repository

import android.content.Context
import com.example.fatecencomendas.data.FatecPackageDatabase
import com.example.fatecencomendas.data.entity.PackageEntity
import kotlinx.coroutines.flow.Flow

class PackageRepository(context: Context){
    private val packageDao = FatecPackageDatabase.getInstance(context).packageDao()

    fun flowAll(): Flow<List<PackageEntity>> = packageDao.flowAll()

    fun flowPackageByUser(id: Int): Flow<List<PackageEntity>> = packageDao.flowPackageByUser(id)

    fun addPackage(packageEntity: PackageEntity) = packageDao.insert(packageEntity)

}