package com.nandikacreativestudio.parentshots.data.model

data class Article(
    val id: String,
    val title: String,
    val photo: String,
    val category: String,
    val source: String,
    val time: String,
    val caption: String = "",
    val description: String = ""
)
