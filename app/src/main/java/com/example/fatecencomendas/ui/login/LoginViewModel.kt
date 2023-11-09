package com.example.fatecencomendas.ui.login

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fatecencomendas.data.repository.UserRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private lateinit var userRepository: UserRepository

    private val _loginInfo: MutableLiveData<Int> = MutableLiveData()
    val loginInfo: LiveData<Int> get() = _loginInfo

    fun initRepositories(context: Context) {
        userRepository = UserRepository(context)
    }

    fun tryLogin(email: String, password: String) {
        viewModelScope.launch {
            userRepository.flowUserByEmail(email).onEach {
                if (it != null) {
                    if (it.password == password) {
                        _loginInfo.postValue(it.uid)
                    } else _loginInfo.postValue(-2)
                } else _loginInfo.postValue(-1)
            }.collect()
        }
    }
}