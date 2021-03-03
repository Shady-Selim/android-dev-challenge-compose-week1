package com.example.androiddevchallenge.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Cat(
    val name: String,
    val age: Int,
    val type: String,
    val gender: String,
    val image: Int,
    val details: String
) : Parcelable