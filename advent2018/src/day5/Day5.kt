package day5

import java.nio.file.Files
import java.nio.file.Paths

// case is polarity "T" & "B" or "a" & "p" are same polarity
// letter is type "t"& "T" or "B" & "B" are same type

fun main(args: Array<String>) {
//    partOne()
    partTwo()
}

private fun partOne() {
    val inputString = String(Files.readAllBytes(Paths.get("src/day5/input")))

    val inputChars = inputString.split("") as ArrayList
    inputChars.removeIf { it == "" }


    var index = 0
    while (index + 1 < inputChars.size) {

        val char = inputChars[index]
        val neighbor = inputChars[index + 1]
        println("comparing $char with $neighbor")
        //conditions
        if (shouldUnitsBeRemoved(char, neighbor)) {
            val remove1 = inputChars[index]

            //removes char
            inputChars.removeAt(index)

            val remove2 = inputChars[index]
            //removes neighbor (which moved to chars index when char was removed)
            inputChars.removeAt(index)
            if (index != 0) {
                index--
            }
            println("removing $remove1 and $remove2")

        } else {

            println("Nothing removed")
            index++
        }


        println("new size = ${inputChars.size}")

    }

    println(inputChars.size)
}

private fun partTwo(){
    val inputString = String(Files.readAllBytes(Paths.get("src/day5/input")))

    var shortestArraySize = Int.MAX_VALUE
    var shortestArrayLetter = ""


    val inputChars = inputString.split("") as ArrayList
    inputChars.removeIf { it == "" }

    val alternateInputs = ArrayList<ArrayList<String>>()
    val alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray()

    for(letter in alphabet){

        val newList= ArrayList<String>()
        newList.addAll(inputChars)
        newList.removeIf { it.toLowerCase() == letter.toString() }
        alternateInputs.add(newList)
    }

    for(input in alternateInputs){
        var index = 0

        while (index + 1 < input.size) {

            val char = input[index]
            val neighbor = input[index + 1]
            //conditions
            if (shouldUnitsBeRemoved(char, neighbor)) {
                //removes char
                input.removeAt(index)
                //removes neighbor (which moved to chars index when char was removed)
                input.removeAt(index)
                if (index != 0) {
                    index--
                }
            } else {
                index++
            }
            println("${((index.toDouble()/input.size.toDouble() ) *100).toInt()}% done with list ${alternateInputs.indexOf(input)} of ${alternateInputs.size}")

            if(input.size < shortestArraySize){
                shortestArraySize = input.size
                shortestArrayLetter = alphabet[alternateInputs.indexOf(input)].toString()
            }
        }
        println(" ")
        println("the best letter to remove is $shortestArrayLetter, this reduces the size to $shortestArraySize")
    }




}


fun shouldUnitsBeRemoved(unit: String, neighborUnit: String): Boolean {
    return !unit.samePolarityAs(neighborUnit) && unit.sameTypeAs(neighborUnit)
}

fun String.sameTypeAs(string: String): Boolean {
    return string.toLowerCase() == this.toLowerCase()
}

fun String.samePolarityAs(string: String): Boolean {
    val bothLowerCase = this.isLowerCase() && string.isLowerCase()
    val bothUpperCase = this.isUpperCase() && string.isUpperCase()

    return bothLowerCase || bothUpperCase
}

fun String.isUpperCase(): Boolean {
    return this == this.toUpperCase()
}

fun String.isLowerCase(): Boolean {
    return this == this.toLowerCase()
}