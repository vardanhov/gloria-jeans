package ru.gloria.aaanet.sduicompose.util

sealed class Resource<T>(val data: T? = null, val message: String? = null, val exception: Exception? = null){
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, exception: Exception, data: T? = null) : Resource<T>(data, message, exception)
}
