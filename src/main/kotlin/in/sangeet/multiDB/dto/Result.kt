package `in`.sangeet.multiDB.dto

sealed class Result<out T : Any> {

    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Failure(val errorMessage: String) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Failure    -> "Error[exception=$errorMessage]"
        }
    }
}