package com.nandikacreativestudio.parentshots.utils

sealed class Screen(val route: String) {
    data object Home: Screen("home_screen")
    data object Category: Screen("category_screen")
    data object Pedia: Screen("pedia_screen")
    data object DetailArticle: Screen("detail_article/{id}") {
        fun createRoute(id: String): String = "detail_article/$id"
    }
}