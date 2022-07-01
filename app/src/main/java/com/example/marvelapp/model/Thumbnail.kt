package com.example.marvelapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Thumbnail(
    val extension: String,
    val path: String
):Parcelable
{
    fun getImage():String
    {
        return path+"."+extension
    }
}