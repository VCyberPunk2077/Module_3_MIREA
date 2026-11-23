package ru.mirea.module3kotlin.presentation.feed

import androidx.annotation.DrawableRes

data class Profile(
    val id: Int,
    val title: String,
    val description: String,
    @DrawableRes val imageRes: Int,
)

