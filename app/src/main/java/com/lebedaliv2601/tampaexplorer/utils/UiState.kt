package com.lebedaliv2601.tampaexplorer.utils

sealed class UiState<out T>(val data: T?, val message: String?) {

    class Success<T>(data: T?):
        UiState<T>(data = data, message = null)

    class Error<T>(data: T?, message: String?):
        UiState<T>(data = data, message = message)

    class Loading<T>(data: T?):
        UiState<T>(data = data, message = null)

}

