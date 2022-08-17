/**
 *  Sealed class is Abstract by self
 *  hold abstract member
 *  constructors are by default protected
 *      we can make it private
 *
 *  Sealed class ensure the type safety, it match the type at compile-time
 *
 * */

sealed class Error {
    constructor() // protected
    private constructor(i: Int)

}

class InternalError: Error() {

}

class JsonError: Error() {

}

fun checkError(t: Error) {
    when(t) {
        is InternalError -> { println("Internal Error") }
        is JsonError -> { println("Json Error") }
        else -> {println("no Error")}
    }
}

fun main() {
    checkError(JsonError())
}