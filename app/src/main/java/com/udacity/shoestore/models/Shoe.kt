package com.udacity.shoestore.models

import android.os.Parcel
import android.os.Parcelable

data class Shoe(var name: String, var size: Double, var company: String, var description: String,
                val images: List<String> = mutableListOf()) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readDouble(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.createStringArrayList()!!) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeDouble(size)
        parcel.writeString(company)
        parcel.writeString(description)
        parcel.writeStringList(images)
    }
    override fun describeContents(): Int {
        return 0
    }
    companion object CREATOR : Parcelable.Creator<Shoe> {
        override fun createFromParcel(parcel: Parcel): Shoe {
            return Shoe(parcel)
        }
        override fun newArray(size: Int): Array<Shoe?> {
            return arrayOfNulls(size)
        }
    }
}