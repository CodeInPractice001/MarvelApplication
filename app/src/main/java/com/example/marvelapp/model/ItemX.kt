package com.example.marvelapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemX(
    val name: String,
    val resourceURI: String
):Parcelable