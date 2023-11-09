package com.example.fatecencomendas.ui.main

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.fatecencomendas.data.entity.PackageEntity
import com.example.fatecencomendas.data.entity.UserEntity
import com.example.fatecencomendas.data.repository.PackageRepository
import com.example.fatecencomendas.data.repository.UserRepository
import com.example.fatecencomendas.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.Date

class MainActivity : FragmentActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setDummyData()
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
                    uid = 1,
                    email = "teste",
                    password = "teste",
                    userType = 1,
                    name = "Ordep"
                )
            )

            loginRepository.addUser(
                UserEntity(
                    uid = 2,
                    email = "teste2",
                    password = "teste2",
                    userType = 1,
                    name = "AHAHAHA"
                )
            )
        }
    }
}