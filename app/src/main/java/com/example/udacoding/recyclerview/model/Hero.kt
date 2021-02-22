package com.example.udacoding.recyclerview.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Hero(
    var name: String? = null,
    var detail: String? = null,
    var photo: Int? = 0
): Parcelable