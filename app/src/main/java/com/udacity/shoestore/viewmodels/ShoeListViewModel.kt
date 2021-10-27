package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeListViewModel: ViewModel() {
    private val _eventGoToShoeDetail = MutableLiveData<Boolean>()
    val eventGoToShoeDetail : LiveData<Boolean> get() = _eventGoToShoeDetail

    fun onGoToShoeDetail(){
        _eventGoToShoeDetail.value = true
    }

    fun onGoToShoeDetailComplete(){
        _eventGoToShoeDetail.value = false
    }
}