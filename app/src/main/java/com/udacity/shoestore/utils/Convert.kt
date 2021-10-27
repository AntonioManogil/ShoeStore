package com.udacity.shoestore.utils

import androidx.databinding.InverseMethod

object Convert {
    @InverseMethod("stringToDouble")
    @JvmStatic fun doubleToString(value: Double) : String{
        return value.toString()
    }
    @JvmStatic fun stringToDouble(value: String) : Double{
        var dValue = 0.0;
        try{
            dValue = value.toDouble()
        }catch(e1: Exception){}
        return dValue
    }
}