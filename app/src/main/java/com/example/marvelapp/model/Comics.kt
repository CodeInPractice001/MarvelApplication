package com.example.marvelapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Comics(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
):Parcelable
{
    constructor():this(-1,"collections", emptyList(),-1)
}