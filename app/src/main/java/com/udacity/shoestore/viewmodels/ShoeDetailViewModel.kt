package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeDetailViewModel : ViewModel() {
    private val _eventSaveShoe = MutableLiveData<Boolean>()
    val eventSaveShoe : LiveData<Boolean> get() = _eventSaveShoe

    private val _eventCancelShoe = MutableLiveData<Boolean>()
    val eventCancelShoe : LiveData<Boolean> get() = _eventCancelShoe

    fun onSaveShoe(){
        _eventSaveShoe.value = true
    }
    fun onSaveShoeComplete(){
        _eventSaveShoe.value = false
    }

    fun onCancelShoe(){
        _eventCancelShoe.value = true
    }

    fun onCancelShoeComplete(){
        _eventCancelShoe.value = false
    }
}