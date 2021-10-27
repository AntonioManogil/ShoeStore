package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val _eventGoToWelcome = MutableLiveData<Boolean>()
    val eventGoToWelcome : LiveData<Boolean> get() = _eventGoToWelcome

    private val _email = MutableLiveData<String>()
    val email : LiveData<String> get() = _email

    private val _password = MutableLiveData<String>()
    val password : LiveData<String> get() = _password

    init{
        _eventGoToWelcome.value = false
        _email.value = ""
        _password.value = ""
    }
    fun onGoToWelcome(){
        _eventGoToWelcome.value = true
    }
    fun onGoToWelcomeComplete(){
        _eventGoToWelcome.value = false
    }
    fun setEmail(newText: String){
        _email.value = newText
    }
    fun setPassword(newText: String){
        _password.value = newText
    }
}