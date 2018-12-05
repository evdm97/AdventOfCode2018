package day1

import AdventUtil

fun main(args: Array<String>) {
    partOne()
    partTwo()
}

fun partOne() {
    val inputScanner = AdventUtil.getInputScanner("day1/input", "\n")

    var frequency = 0

    while (inputScanner.hasNext()) {
        frequency += inputScanner.next().toInt()
    }

    println("solution to day 1 part 1 is: $frequency")
}

fun partTwo() {
    var frequency = 0
    val pastFrequencies = ArrayList<Int>()
    val frequencyChanges = AdventUtil.getInputArray("day1/input", "\n")

    while (!pastFrequencies.contains(frequency)) {
        for (change: String in frequencyChanges) {
            pastFrequencies.add(frequency)

            frequency += change.toInt()

            if (pastFrequencies.contains(frequency)) {
                break
            }
        }
    }
    print("solution to day 1 part 2 is: $frequency")
}
