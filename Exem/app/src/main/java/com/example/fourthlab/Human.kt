package com.example.fourthlab

import androidx.annotation.DrawableRes

data class Human(
    val name: String,
    val fio: String,
    val text: String,
    @DrawableRes val imagePath: Int,


)