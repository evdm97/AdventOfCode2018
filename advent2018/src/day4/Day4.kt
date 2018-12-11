package day4

import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


fun main(args: Array<String>) {
//    partOne()
    partTwo()
}

var guardList: ArrayList<Guard> = ArrayList()

var sleepiestguard: Guard = Guard(-1)

var currentGuard: Guard = Guard(-1)
var sleepMinute: Int = -1

private fun partOne() {
    val inputList = AdventUtil.getInputArray("day4/input")
    inputList.sortBy { inputToDate(it) }

    for (item in inputList) {
        when {
            item.contains("Guard") -> {
                println("new shift")
                newGuard(item)
            }
            item.contains("asleep") -> {
                println("falls asleep")
                sleepMinute = minuteAtMoment(item)
            }
            item.contains("wakes up") -> {
                currentGuard.addSleep(sleepMinute, minuteAtMoment(item))
                println("wakes up")
            }
        }
    }
    println("${sleepiestguard.id} is the sleepiest guard at ${sleepiestguard.totalSleep} minutes slept.")
    println("he spends minute ${sleepiestguard.getMinuteMostSlept().minute} asleep the most, he slept  ${sleepiestguard.getMinuteMostSlept().timesSleptAtMinute} times at that minute")
    println("this would make the answer ${sleepiestguard.id * sleepiestguard.getMinuteMostSlept().minute}")
}

private fun partTwo() {
    val inputList = AdventUtil.getInputArray("day4/input")
    inputList.sortBy { inputToDate(it) }

    for (item in inputList) {
        when {
            item.contains("Guard") -> {
                println("new shift")
                newGuard(item)
            }
            item.contains("asleep") -> {
                println("falls asleep")
                sleepMinute = minuteAtMoment(item)
            }
            item.contains("wakes up") -> {
                currentGuard.addSleep(sleepMinute, minuteAtMoment(item))
                println("wakes up")
            }
        }
    }
    guardList.sortByDescending {
        if (it.totalSleep != 0) {
            it.getMinuteMostSlept().timesSleptAtMinute
        } else 0
    }

    val consistentGuard = guardList[0]

    println("Guard ${consistentGuard.id} slept ${consistentGuard.getMinuteMostSlept().timesSleptAtMinute} times at minute ${consistentGuard.getMinuteMostSlept().minute}")
    println("this would make the answer ${consistentGuard.id * consistentGuard.getMinuteMostSlept().minute}")

}

fun newGuard(newGuard: String) {
    if (currentGuard.totalSleep > sleepiestguard.totalSleep) {
        sleepiestguard = currentGuard
    }

    val newId = guardId(newGuard)

    val guardFromList = guardList.getGuard(newId)
    currentGuard = guardFromList ?: Guard(newId).also {
        guardList.add(it)
    }
}

fun guardId(inputString: String): Int {
    return inputString.substring(inputString.indexOf("#") + 1, inputString.indexOf(" begins")).toInt()
}

fun inputToDate(inputString: String): Date {
    val dateString = inputString.substring(inputString.indexOf("[") + 1, inputString.indexOf("]"))
    return SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateString)
}

fun minuteAtMoment(inputString: String): Int {
    return inputString.substring(inputString.indexOf("]") - 2, inputString.indexOf("]")).toInt()
}

fun ArrayList<Guard>.getGuard(id: Int): Guard? {
    return filter { it.id == id }.getOrNull(0)

}