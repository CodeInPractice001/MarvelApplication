package com.example.marvelapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MarvelModel(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val `data`: MarvelDataModel,
    val etag: String,
    val status: String
):Parcelable
{
    constructor():this("","",-1,"",
        MarvelDataModel()
    ,"","")
}