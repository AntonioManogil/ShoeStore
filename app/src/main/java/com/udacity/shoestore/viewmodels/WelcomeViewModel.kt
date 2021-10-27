package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel : ViewModel() {
    private val _eventGoToInstruction = MutableLiveData<Boolean>()
    val eventGoToInstruction : LiveData<Boolean> get() = _eventGoToInstruction

    fun onGoToInstruction(){
        _eventGoToInstruction.value = true
    }

    fun onGoToInstructionComplete(){
        _eventGoToInstruction.value = false
    }
}