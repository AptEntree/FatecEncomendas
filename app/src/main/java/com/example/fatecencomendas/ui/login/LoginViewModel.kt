package com.example.fatecencomendas.ui.login

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fatecencomendas.data.repository.UserRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private lateinit var userRepository: UserRepository

    private val auth: FirebaseAuth = Firebase.auth

    private val _loginInfo: MutableLiveData<FirebaseUser?> = MutableLiveData()
    val loginInfo: LiveData<FirebaseUser?> get() = _loginInfo

    fun initRepositories(context: Context) {
        userRepository = UserRepository(context)
    }

    fun tryLogin(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("Pedro", "signInWithEmail:success")
                    internalLogin(auth.currentUser)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("Pedro", "signInWithEmail:failure", task.exception)
                    internalLogin(null)
                }
            }
    }

    private fun internalLogin(user: FirebaseUser?) {
        viewModelScope.launch {
            if (user == null) {
                _loginInfo.postValue(null)
            } else {
                userRepository.flowUserByUid(user.uid).onEach {
                    if (it != null) {
                        _loginInfo.postValue(user)
                    } else _loginInfo.postValue(null)
                }.collect()
            }
        }
    }
}