package day1

import AdventUtil
import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    partOne()
    partTwo()
}

fun partOne() {
    val inputScanner = getDay1InputScanner()

    var frequency = 0

    while (inputScanner.hasNext()) {
        frequency += inputScanner.next().toInt()
    }

    println("solution to day 1 part 1 is: $frequency")
}

fun partTwo() {
    var frequency = 0
    val pastFrequencies = ArrayList<Int>()
    val inputScanner = getDay1InputScanner()
    val changeList = ArrayList<Int>()

    while (inputScanner.hasNext()) {
        changeList.add(inputScanner.next().toInt())
    }

    while (!pastFrequencies.contains(frequency)) {
        for (change: Int in changeList) {
            pastFrequencies.add(frequency)

            frequency += change

            if (pastFrequencies.contains(frequency)) {
                print("solution to day 1 part 2 is: $frequency")
                break
            }
        }
    }
}

fun getDay1InputScanner(): Scanner {
    return Scanner(AdventUtil.getFile("day1/input/input")).useDelimiter("\n")
}
