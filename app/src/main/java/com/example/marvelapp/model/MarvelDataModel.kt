package com.example.marvelapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MarvelDataModel(
    val count: Int,
    val limit: Int,
    val offset: Int,
    var results: List<ResultModel>,
    val total: Int
):Parcelable{
    constructor():this(-1,-1,-1,emptyList(),-1)
}