package com.example.fatecencomendas.data.repository

import android.content.Context
import com.example.fatecencomendas.data.FatecPackageDatabase
import com.example.fatecencomendas.data.entity.PackageEntity
import kotlinx.coroutines.flow.Flow

class PackageRepository(context: Context){
    private val packageDao = FatecPackageDatabase.getInstance(context).packageDao()

    fun flowPackageByUserEmail(email: String?): Flow<List<PackageEntity>> = packageDao.flowPackageByUserEmail(email)

    fun addPackage(packageEntity: PackageEntity) = packageDao.insert(packageEntity)

}