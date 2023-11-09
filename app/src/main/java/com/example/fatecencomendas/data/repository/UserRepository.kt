package com.example.fatecencomendas.data.repository

import android.content.Context
import com.example.fatecencomendas.data.FatecPackageDatabase
import com.example.fatecencomendas.data.entity.UserEntity
import kotlinx.coroutines.flow.Flow

class UserRepository(context: Context){
    private val userDao = FatecPackageDatabase.getInstance(context).userDao()

    fun addUser(user: UserEntity) = userDao.insert(user = user)

    fun flowUserByEmail(email: String): Flow<UserEntity?> = userDao.findUserByEmail(email)
}