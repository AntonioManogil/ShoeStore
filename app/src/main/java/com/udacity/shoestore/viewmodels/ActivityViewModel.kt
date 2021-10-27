package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ActivityViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<MutableList<Shoe>>(mutableListOf())
    val shoeList : LiveData<MutableList<Shoe>> get() = _shoeList

    fun AddItem(item: Shoe){
        _shoeList.value?.add(item)
    }
    fun Clear(){
        _shoeList.value?.clear()
    }
}