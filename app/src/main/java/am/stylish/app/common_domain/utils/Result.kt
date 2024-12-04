package am.stylish.app.common_domain.utils

sealed class Result() {
    class Success<T>(val data: T) : Result()
    class Error<E>(val message: E) : Result()
}