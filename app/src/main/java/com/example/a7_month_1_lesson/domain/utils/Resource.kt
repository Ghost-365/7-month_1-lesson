package com.example.a7_month_1_lesson.domain.utils

import android.webkit.ConsoleMessage

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Loading<T> : Resource<T>()
    class Success<T>(data: T?) : Resource<T>()
    class Error<T>(massage: String? = null, data: T? = null) : Resource<T>()
 }