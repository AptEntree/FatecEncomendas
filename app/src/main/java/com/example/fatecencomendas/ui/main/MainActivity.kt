package com.example.fatecencomendas.ui.main

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.fatecencomendas.data.entity.PackageEntity
import com.example.fatecencomendas.data.entity.UserEntity
import com.example.fatecencomendas.data.repository.PackageRepository
import com.example.fatecencomendas.data.repository.UserRepository
import com.example.fatecencomendas.databinding.ActivityMainBinding
import com.example.fatecencomendas.util.AppConstants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date

class MainActivity : FragmentActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setDummyData()
    }

    private fun setDummyData() {
        val packageRepository = PackageRepository(this)
        val loginRepository = UserRepository(this)

        val simpleDateFormat = SimpleDateFormat("MM-dd-yyyy")
        CoroutineScope(Dispatchers.IO).launch {
            packageRepository.addPackage(
                PackageEntity(
                    uid = 0,
                    addresseeId = 1,
                    arrivedDate = simpleDateFormat.format(Date()),
                    pickupDate = simpleDateFormat.format(Date()),
                    receiverName = "Pedro Henrique Vieira"
                )
            )

            packageRepository.addPackage(
                PackageEntity(
                    uid = 0,
                    addresseeId = 1,
                    arrivedDate = simpleDateFormat.format(Date()),
                    pickupDate = simpleDateFormat.format(Date()),
                    receiverName = "Pedro Vieira"
                )
            )

            packageRepository.addPackage(
                PackageEntity(
                    uid = 0,
                    addresseeId = 1,
                    arrivedDate = simpleDateFormat.format(Date()),
                    pickupDate = simpleDateFormat.format(Date()),
                    receiverName = "Não é o Pedro"
                )
            )

            packageRepository.addPackage(
                PackageEntity(
                    uid = 0,
                    addresseeId = 1,
                    arrivedDate = simpleDateFormat.format(Date()),
                    pickupDate = simpleDateFormat.format(Date()),
                    receiverName = "Adriely"
                )
            )

            loginRepository.addUser(
                UserEntity(
                    uid = 0,
                    email = "teste",
                    password = "teste",
                    userType = AppConstants.USERTYPE_COMMON,
                    name = "Ordep"
                )
            )

            loginRepository.addUser(
                UserEntity(
                    uid = 0,
                    email = "teste11",
                    password = "teste11",
                    userType = AppConstants.USERTYPE_COMMON,
                    name = "Pedro 1"
                )
            )

            loginRepository.addUser(
                UserEntity(
                    uid = 0,
                    email = "teste22",
                    password = "teste22",
                    userType = AppConstants.USERTYPE_COMMON,
                    name = "Pedro 2"
                )
            )

            loginRepository.addUser(
                UserEntity(
                    uid = 10,
                    email = "teste2",
                    password = "teste2",
                    userType = AppConstants.USERTYPE_ADMIN,
                    name = "AHAHAHA"
                )
            )
        }
    }
}