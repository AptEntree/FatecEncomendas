package com.example.fatecencomendas.ui.add

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fatecencomendas.data.entity.PackageEntity
import com.example.fatecencomendas.data.entity.UserEntity
import com.example.fatecencomendas.data.repository.PackageRepository
import com.example.fatecencomendas.data.repository.UserRepository
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date

class AddPackageViewModel : ViewModel() {
    private lateinit var packageRepository: PackageRepository
    private lateinit var userRepository: UserRepository

    private val _userList: MutableLiveData<List<UserEntity>> = MutableLiveData()
    val userList: LiveData<List<UserEntity>> get() = _userList

    private val _wasAdded: MutableLiveData<Boolean> = MutableLiveData()
    val wasAdded: LiveData<Boolean> get() = _wasAdded

    fun initRepositories(context: Context) {
        packageRepository = PackageRepository(context)
        userRepository = UserRepository(context)
    }

    fun getUserList() {
        viewModelScope.launch {
            userRepository.flowAllNormalUsers().onEach {
                _userList.postValue(it)
            }.collect()
        }
    }

    fun addNewPackage(addresseeEmail: String) {
        val simpleDateFormat = SimpleDateFormat("MM-dd-yyyy")
        viewModelScope.launch {
                CoroutineScope(Dispatchers.IO).launch {
                    packageRepository.addPackage(
                        PackageEntity(
                            uid = 0,
                            addresseeEmail = addresseeEmail,
                            arrivedDate = simpleDateFormat.format(Date()),
                            pickupDate = "-",
                            receiverEmail = Firebase.auth.currentUser?.email
                        )
                    )
                    _wasAdded.postValue(true)
                }
        }
    }
}