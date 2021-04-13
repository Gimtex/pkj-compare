import kotlin.collections.listOf
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext

val <T> List<T>.tail: List<T>
    get() = drop(1)

val <T> List<T>.head: T
    get() = first()


fun main() {
//    println(helloWord())


//    1.
//    println(isOlder(Triple(4, 5, 4), Triple(4, 5, 4)))


//    2.
//    println(numberInMonth(listOf(Triple(4, 5, 4), Triple(4, 5, 4), Triple(4, 3, 4), Triple(4, 4, 4)), 5))
//    println(numberInMonth(listOf(Triple(4, 5, 4), Triple(4, 5, 4), Triple(4, 3, 4), Triple(4, 4, 4)), 3))
//    println(numberInMonth(listOf(Triple(4, 5, 4), Triple(4, 5, 4), Triple(4, 3, 4), Triple(4, 4, 4)), 4))
//    println(numberInMonth(listOf(Triple(4, 5, 4), Triple(4, 5, 4), Triple(4, 3, 4), Triple(4, 4, 4)), 2))


//    3.
//    println(numberInMonths(listOf(Triple(2000, 2, 1), Triple(2000, 2, 1), Triple(2000, 3, 1), Triple(2000, 2, 1)), listOf(1, 2)))
//    println(numberInMonths(listOf(Triple(2000, 2, 1), Triple(2000, 2, 1), Triple(2000, 3, 1), Triple(2000, 2, 1)), listOf(1, 2, 3)))
//    println(numberInMonths(listOf(Triple(2000, 2, 1), Triple(2000, 2, 1), Triple(2000, 3, 1), Triple(2000, 2, 1)), listOf(1, 3)))
//    println(numberInMonths(listOf(Triple(2000, 2, 1), Triple(2000, 2, 1), Triple(2000, 3, 1), Triple(2000, 2, 1)), listOf(1)))
//    println(numberInMonths(listOf(Triple(2000, 2, 1), Triple(2000, 2, 1), Triple(2000, 3, 1), Triple(2000, 2, 1)), listOf()))
//    println(numberInMonths(listOf(), listOf()))
//    println(numberInMonths(listOf(), listOf(1, 2, 3)))


//    4.
//    println(datesInMonth(listOf(Triple(2000, 2, 2), Triple(2000, 2, 3), Triple(2000, 3, 1), Triple(2000, 2, 4)), 2))
//    println(datesInMonth(listOf(Triple(2000, 2, 2), Triple(2000, 2, 3), Triple(2000, 3, 1), Triple(2000, 2, 4)), 3))
//    println(datesInMonth(listOf(Triple(2000, 2, 2), Triple(2000, 2, 3), Triple(2000, 3, 1), Triple(2000, 2, 4)), 4))


//    5.
//    println(datesInMonths(listOf(Triple(2000, 2, 1), Triple(2000, 2, 2), Triple(2000, 3, 1), Triple(2000, 2, 3)), listOf(2, 3)))
//    println(datesInMonths(listOf(Triple(2000, 2, 1), Triple(2000, 2, 2), Triple(2000, 3, 1), Triple(2000, 2, 3)), listOf(2, 4)))
//    println(datesInMonths(listOf(Triple(2000, 2, 1), Triple(2000, 2, 2), Triple(2000, 3, 1), Triple(2000, 2, 3)), listOf(3, 4)))
//    println(datesInMonths(listOf(Triple(2000, 2, 1), Triple(2000, 2, 2), Triple(2000, 3, 1), Triple(2000, 2, 3)), listOf(1, 4)))


//    6.
//    println(getNth(listOf("a", "b", "c", "d"), 0))
//    println(getNth(listOf("a", "b", "c", "d"), 2))
//    println(getNth(listOf("a", "b", "c", "d"), 4))
//    println(getNth(listOf("a", "b", "c", "d"), 5))
//    println(getNth(listOf(), 4))


//    7.
//    println(dateToString(Triple(2000, 2, 1)))


//    8.
//    println(numberBeforeReachingSum( 50, listOf(20, 20, 20)))
//    println(numberBeforeReachingSum( 50, listOf(50, 20, 20)))
//    println(numberBeforeReachingSum( 50, listOf(20, 30, 20)))


//    9.
//    println(whatMonth(12))
//    println(whatMonth(40))
//    println(whatMonth(31))
//    println(whatMonth(32))
//    println(whatMonth(59))
//    println(whatMonth(60))
//    println(whatMonth(90))
//    println(whatMonth(91))
//    println(whatMonth(365))


//    10.
//    println(monthRange(3, 3))
//    println(monthRange(31, 32))
//    println(monthRange(31, 33))
//    println(monthRange(29, 33))


//    11.
    println(oldest(listOf(Triple(2000, 1, 1), Triple(2000, 2, 1), Triple(1998, 1, 2), Triple(2000, 3, 1), Triple(1999, 3, 2))))
    println(oldest(listOf(Triple(2000, 1, 1), Triple(2000, 2, 1), Triple(2001, 1, 2), Triple(2000, 3, 1), Triple(1999, 3, 2))))
    println(oldest(listOf(Triple(2000, 1, 1), Triple(2000, 2, 1), Triple(2000, 1, 2), Triple(2000, 3, 1), Triple(2000, 3, 2))))
}

fun helloWord() : String {
    return "Hello World!"
}

// 1.
fun isOlder(date1 : Triple<Int, Int, Int>, date2 : Triple<Int, Int, Int>) : Boolean {
    return if (date1.first == date2.first && date1.second == date2.second && date1.third == date2.third) {
        false
    } else if (date1.first > date2.first) {
        false
    } else if (date1.first == date2.first) {
        isOlder(Triple(date1.second, date1.third, 0), Triple(date2.second, date2.third, 0))
    } else {
        true
    }
}

// 2.
fun numberInMonth(dates : List<Triple<Int, Int, Int>>, month : Int) : Int {
    return when {
        dates.isEmpty() -> {
            0
        }
        dates.head.second == month -> {
            1 + numberInMonth(dates.tail, month)
        }
        else -> {
            numberInMonth(dates.tail, month)
        }
    }
}

// 3.
fun numberInMonths(dates : List<Triple<Int, Int, Int>>, months : List<Int>) : Int {
    return when {
        months.isEmpty() -> {
            0
        }
        else -> {
            numberInMonth(dates, months.head) + numberInMonths(dates, months.tail)
        }
    }
}


// 4.
fun datesInMonth(dates : List<Triple<Int, Int, Int>>, month : Int) : List<Triple<Int, Int, Int>> {
    return when {
        dates.isEmpty() -> {
            listOf()
        }
        dates.head.second == month -> {
            val tmpList = listOf(dates.head).toMutableList()
            tmpList.addAll(datesInMonth(dates.tail, month))
            tmpList
        }
        else -> {
            datesInMonth(dates.tail, month)
        }
    }
}


// 5.
fun datesInMonths(dates : List<Triple<Int, Int, Int>>, months : List<Int>) : List<Triple<Int, Int, Int>> {
    return when {
        months.isEmpty() -> {
            listOf()
        }
        else -> {
            val tmpList = datesInMonth(dates, months.head).toMutableList()
            tmpList.addAll(datesInMonths(dates, months.tail))
            tmpList
        }
    }
}


// 6.
fun getNth(strings : List<String>, n : Int) : String {
    return when {
        strings.isEmpty() || n == 0 || n > strings.size -> {
            "Error"
        }
        n == 1 -> {
            strings.head
        }
        else -> {
             getNth(strings.tail, n-1)
        }
    }
}

// 6.1
fun getNthSimplified(strings : List<String>, n : Int) : String {
    return when {
        strings.isEmpty() || n == 0 || n > strings.size -> {
            "Error"
        }
        else -> {
            strings[n-1]
        }
    }
}

// 7.
fun dateToString(date : Triple<Int, Int, Int>) : String {
    val monthsNames = listOf("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December")
    return getNth(monthsNames, date.second) + " " + date.third + ", " + date.first
}

// 8
fun numberBeforeReachingSum(sum : Int, numbers : List<Int>) : Int {

    fun extendedNested(sum : Int, numbers : List<Int>, n : Int) : Int {
        val newSum = sum - numbers.head
        return when {
            newSum <= 0 -> {
                n
            } else -> {
                extendedNested(newSum, numbers.tail, n+1)
            }
        }
    }

    return extendedNested(sum, numbers, 0)
}


// 9
fun whatMonth(day : Int) : Int {
    val monthsLength = listOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    return numberBeforeReachingSum(day, monthsLength) + 1
}


// 10
fun monthRange(day1 : Int, day2 : Int) : List<Int> {
    return when {
        day1 > day2 -> {
            listOf()
        } else -> {
            val tmpList = listOf(whatMonth(day1)).toMutableList()
            tmpList.addAll(monthRange(day1 + 1, day2))
            tmpList
        }
    }
}


// 11
fun oldest(dates : List<Triple<Int, Int, Int>>) : Triple<Int, Int, Int>? {
    return when {
        dates.isEmpty() -> {
            null
        } else -> {
            val tmpAnswer = oldest(dates.tail)
            if (tmpAnswer != null && isOlder(tmpAnswer, dates.head)) {
                tmpAnswer
            } else {
                dates.head
            }
        }
    }
}
