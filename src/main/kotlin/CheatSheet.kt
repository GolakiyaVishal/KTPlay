import kotlin.properties.Delegates

fun main() {
//    CheatSheet().listTest()
//    CheatSheet().mutableListTest()
//    CheatSheet().simple()
//    CheatSheet().literals()
//    CheatSheet().extensionTest()
//    CheatSheet().lazyTest()
//    CheatSheet().observableTest()
    CheatSheet(age = 20).mapTest()
    CheatSheet(name = "asd")
}

class CheatSheet {

    init {
        println("this is initial bloc")
    }

    constructor(age: Int) {
        println("secondary constructor")
    }

    constructor(name: String) {
        println("turnery constructor")
    }

    fun sequenceAndCollection() {
        /**
         * Sequence are
         *      executed lazily
         *      synchronously execute operation
         * */

        val seq = sequenceOf(12, 22, 1,2,34)
        println("sequence sort :: ${seq.sorted()}")

    }

    fun listTest() {
        val list = listOf(1, 2, 3, 4)
        println("first :: ${list.first()}") // 1
        println("firstBy :: ${list.first { it % 2 == 0 }}") // 2

        println("count :: ${list.count()}") // 4
        println("countBy :: ${list.count { it % 2 == 0 }}") // 2

        println("sorted :: ${list.sorted()}")
        println("sorted descending :: ${list.sortedDescending()}")
        println("sorted by :: ${list.sortedBy { it % 2 }}")
        // TODO sorted with comparator
//        println("sorted with :: ${list.sortedWith(comparator = Comparator<Int>())}")

        println("group by :: ${list.groupBy { it % 2 }}")
        val tl = listOf(1, 1, 2, 2)
        println("distinct on :: ${tl.distinct()}")
        println("distinct by :: ${tl.distinctBy { it % 2 }}")
    }

    fun mutableListTest() {
        val list = mutableListOf(3, 2, 4, 1)
        val sortedResult = list.sorted()
        println("sortedResult :: $sortedResult")
        println("list :: $list")
        val sortResult = list.sort()
        println("sortResult :: $sortResult")
        println("list :: $list")
    }

    fun getDialog() {
        // TODO implement simple dialog
    }

    fun simple() {
        println("simple")
        println("twoParam :: ${twoParam(1, 2)}")

        fun inside() {
            println("inside")
        }
        takeUnit(::inside)
        returnUnit()()
    }

    private fun twoParam(i1: Int, i2: Int) {
        print("$i1 $i2")
    }

    private fun takeUnit(fun1: () -> Unit): Int {
        println("takeUnit")
        fun1()
        return 0
    }

    private fun returnUnit(): () -> Unit {
        fun l1() {
            println("return unit")
        }
        return ::l1
    }

    /**
     * Function Literals
     * */

    val add: (Int, Int) -> Int = { i, j -> i + j }
    val printAndReturn: (Int) -> String = {
        println("integer :: $it")
        it.toString()
    }

    fun literals() {
        println(add(1, 2))
        println(printAndReturn(10))
    }

    /**
     * Extension
     * */

    fun extensionTest() {
        fun Int.isEven() = this % 2 == 0
        println(3.isEven())

        fun List<Int>.average() = 1.0 * sum() / size
        print(listOf(2, 3, 6, 8, 9).average())
    }

    fun lazyTest() {
        val i by lazy { print("lazy"); 8 }
        println(i)
        println(i)
        println(i)
    }

    /**
     * observable
     * vetoable
     * */

    var name: String by Delegates.observable("no name") {
            property, oldValue, newValue -> println("name change to $oldValue = $newValue") }

    var maxVal: Int by Delegates.vetoable(
        initialValue = 2, onChange = {property, oldValue, newValue ->
            println("new value :: $newValue"); oldValue < newValue })

    fun observableTest() {
        println(name)
        name = "Other name"
        print(name)

        println("maxValue :: $maxVal")
        maxVal = 11
        println("maxValue :: $maxVal")
        maxVal = 7
        println("maxValue :: $maxVal")
    }

    /**
     * Map
     * */
    fun mapTest() {
        val m1 = mapOf("a" to 10)
        val a by m1
        println("map value :: $a")
    }

}


/**
 *
 * Elvis Operator (val1 ?: "default")
 *      -> is used to safely unwrap the value from nullable
 *
 *
 *  let
 *      -> let will safely unwrap the nullable
 *      str.let{print(str)}
 *
 *   !! -> use when sure nullable variable has a value
 *
 *
 *  const vs val
 *      val is runtime constant
 *      const is compile-time constant
 *      const only use with val, not with var
 *      const cannot use as local
 *
 *
 * kotlin function known as top-level function
 *      -> Function in kotlin can be defined at the root of kotlin file
 *
 * == -> compare value
 * === -> compare reference
 *
 *
 * visibility operator
 *      -> public (default)
 *      -> private
 *      -> protected
 *      -> internal
 *
 *
 * default classes are final in kotlin
 *      -> open  => add modifier
 *
 *
 * kotlin contractors
 *      -> primary (only one)
 *      -> secondary (multiple, must delegate to the primary constructor )
 *
 *
 * init block
 *      > kotlin initializer block
 *      > execute once the primary constructor executed
 *      > execute before the secondary constructor
 *
 *
 * String interpolation
 *      > $
 *      > print("name = $name")
 *
 *
 *  when (as switch case)
 *     val i = 10
 *     when(i) {
 *          0..4 -> print("0 to 4")
 *          5 -> print("5 * 4")
 *          else -> {
 *              print("not valid")
 *          }
 *     }
 *
 *
 *  destructuring declaration
 *      > extract the element from data class
 *      > val (name, age) = personDataObject
 *
 *
 *  inline vs infix function
 *      >
 *
 *
 * */