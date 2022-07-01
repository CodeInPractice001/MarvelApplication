package com.example.marvelapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemXX(
    val name: String,
    val resourceURI: String
):Parcelable