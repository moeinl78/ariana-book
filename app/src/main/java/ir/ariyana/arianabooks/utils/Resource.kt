package ir.ariyana.arianabooks.utils

sealed class Resource<T> constructor(val data: T ?= null, val message: String ?= null) {

    class Success<T>(data : T?): Resource<T>(data)
    class Error<T>(message: String?): Resource<T>(null, message)
    class Loading<T>: Resource<T>()
}