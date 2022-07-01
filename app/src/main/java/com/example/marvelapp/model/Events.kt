package com.example.marvelapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Events(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemX>,
    val returned: Int
):Parcelable