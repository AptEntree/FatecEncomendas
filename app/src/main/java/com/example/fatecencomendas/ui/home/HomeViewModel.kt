package com.example.fatecencomendas.ui.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fatecencomendas.data.entity.PackageEntity
import com.example.fatecencomendas.data.repository.PackageRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private lateinit var packageRepository: PackageRepository

    private val _packageList: MutableLiveData<List<PackageEntity>> = MutableLiveData()
    val packageList: LiveData<List<PackageEntity>> get() = _packageList

    fun initRepositories(context: Context) {
        packageRepository = PackageRepository(context)
    }

    fun getPackageFromUserID(id: Int) {
        viewModelScope.launch {
            packageRepository.flowPackageByUser(id).onEach {
                _packageList.postValue(it)
            }.collect()
        }
    }
}