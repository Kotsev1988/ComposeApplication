package com.example.composeapplication.presentation.util

import androidx.annotation.StringRes
import com.example.composeapplication.R

sealed class Screens(val route: String, @StringRes resId: Int) {

    object MainScreen: Screens("main_screen", R.string.main_screen)

    object BlogScreen: Screens("blog_screen", R.string.blog_screen)

    object SearchScreen: Screens("search_screen", R.string.search_screen)

    object ShoppingScreen: Screens("shopping_screen", R.string.shopping_screen)

    object MessageScreen: Screens("message_screen", R.string.message_screen)

    object MoreScreen: Screens("more_screen", R.string.message_screen)

    object DetailScreen: Screens("DetailScreen/{id}", R.string.message_screen)
}