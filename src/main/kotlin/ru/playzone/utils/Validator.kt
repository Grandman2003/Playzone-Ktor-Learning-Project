package ru.playzone.utils

fun String.isValidEmail() = Regex("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$").matches(this)