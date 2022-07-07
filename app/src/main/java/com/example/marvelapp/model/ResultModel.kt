package com.example.marvelapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResultModel(
    val comics: Comics,
    val description: String,
    val events: Events,
    val id: Int,
    val modified: String,
    val name: String,
    val resourceURI: String,
    val series: Series,
    val stories: Stories,
    val thumbnail: Thumbnail,
    val urls: List<Url>
) : Parcelable {
    constructor() : this(
        Comics(), "description", Events(), -1, "modeifies", "name", "resourceId",
        Series(), Stories
            (), Thumbnail
            ("extension", "path"), emptyList
            ()
    )

}