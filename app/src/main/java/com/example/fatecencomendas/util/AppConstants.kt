package com.example.fatecencomendas.util

class AppConstants {
    companion object {

        //Log
        const val LOG_DATABASE = "FatecEncomendas-Database"

        //Database
        const val DATABASE_NAME = "FatecEncomendas"
        const val USER_TABLE = "user"
        const val POST_TABLE = "package"

        fun isAdmin(email: String) = email.contains("@admin")

    }
}