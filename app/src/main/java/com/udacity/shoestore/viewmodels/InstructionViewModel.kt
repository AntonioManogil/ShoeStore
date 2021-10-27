package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InstructionViewModel : ViewModel(){
    private val _eventGoToShoeList = MutableLiveData<Boolean>()
    val eventGoToShoeList : LiveData<Boolean> get() =  _eventGoToShoeList

    fun onGoToShoeList(){
        _eventGoToShoeList.value = true
    }
    fun onGoToShoeListComplete(){
        _eventGoToShoeList.value = false
    }
}