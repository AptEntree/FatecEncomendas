package com.example.fatecencomendas.data

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.fatecencomendas.data.dao.PackageDao
import com.example.fatecencomendas.data.dao.UserDao
import com.example.fatecencomendas.data.entity.PackageEntity
import com.example.fatecencomendas.data.entity.UserEntity
import com.example.fatecencomendas.util.AppConstants

@Database(
    entities = [
        UserEntity::class,
        PackageEntity::class],
    version = 1
)
abstract class FatecPackageDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun packageDao(): PackageDao

    companion object {

        @Volatile
        private var instance: FatecPackageDatabase? = null

        fun getInstance(context: Context): FatecPackageDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context)
            }
        }

        private fun buildDatabase(context: Context): FatecPackageDatabase =
            Room.databaseBuilder(
                context,
                FatecPackageDatabase::class.java,
                AppConstants.DATABASE_NAME
            ).addCallback(object : Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    Log.i(AppConstants.LOG_DATABASE, "PetCareDatabase.buildDatabase() - onCreate()")
                    super.onCreate(db)
                }
            }).build()

    }
}