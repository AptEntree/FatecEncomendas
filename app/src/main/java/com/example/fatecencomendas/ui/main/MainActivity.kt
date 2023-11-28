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
                    addresseeEmail = "pedro@test.com",
                    arrivedDate = simpleDateFormat.format(Date()),
                    pickupDate = simpleDateFormat.format(Date()),
                    receiverEmail = "pedro@admin.com"
                )
            )

            packageRepository.addPackage(
                PackageEntity(
                    uid = 0,
                    addresseeEmail = "pedro@test.com",
                    arrivedDate = simpleDateFormat.format(Date()),
                    pickupDate = simpleDateFormat.format(Date()),
                    receiverEmail = "pedro@admin.com"
                )
            )

            packageRepository.addPackage(
                PackageEntity(
                    uid = 0,
                    addresseeEmail = "pedro@test.com",
                    arrivedDate = simpleDateFormat.format(Date()),
                    pickupDate = simpleDateFormat.format(Date()),
                    receiverEmail = "pedro@admin.com"
                )
            )

            packageRepository.addPackage(
                PackageEntity(
                    uid = 0,
                    addresseeEmail = "adrielly@test.com",
                    arrivedDate = simpleDateFormat.format(Date()),
                    pickupDate = simpleDateFormat.format(Date()),
                    receiverEmail = "pedro@admin.com"
                )
            )

            loginRepository.addUser(
                UserEntity(
                    uid = "J3rWITrQMnZpvBaRDA0bnnRFirV2",
                    email = "pedro@test.com"
                )
            )

            loginRepository.addUser(
                UserEntity(
                    uid = "TIdg2d6tM9OayKEMkXF1AtkGTUq2",
                    email = "adrielly@test.com"
                )
            )

            loginRepository.addUser(
                UserEntity(
                    uid = "dlgkhL3kDtUDAJrzFAo4YRsZHKF2",
                    email = "pedro@admin.com"
                )
            )
        }
    }
}