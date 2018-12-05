package day2


fun main(args: Array<String>) {
    partOne()
//    partTwo()
}

fun partOne() {
    val inputList = AdventUtil.getInputArray("day2/input", "\n")

    var totalDouble = 0
    var totalTriple = 0

    for (item in inputList) {
        var wordHasDouble = false
        var wordHasTriple = false

        val itemCharacters = item.split("") as ArrayList
        itemCharacters.removeIf { it == "" }

        while (itemCharacters.isNotEmpty()) {
            val compareChar = itemCharacters[0]
            var characterOccurrence = 0

            while (itemCharacters.contains(compareChar)) {
                itemCharacters.remove(compareChar)
                characterOccurrence++
            }

            when (characterOccurrence) {
                2 -> if (!wordHasDouble) {
                    totalDouble++
                    wordHasDouble = true
                }
                3 -> if (!wordHasTriple) {
                    totalTriple++
                    wordHasTriple = true
                }
            }
        }
    }
        println("solution to day 2 part 1 is: " + totalDouble * totalTriple)
    }

    fun partTwo() {
        val inputList = AdventUtil.getInputArray("day2/input", "\n")

        parentLoop@ for (item1 in inputList) {
            for (item2 in inputList) {
                if (item1 != item2 && item1.isOneCharacterOff(item2)) {
                    println("solution to day 2 part 2 is: " + item1.returnCommonLetters(item2))
                    break@parentLoop
                }
            }
        }
    }

    fun String.isOneCharacterOff(string: String): Boolean {
        var diffFound = false

        for (i in 0 until this.length) {
            if (this[i] != string[i]) {
                if (diffFound) {
                    return false
                } else {
                    diffFound = true
                }
            }
        }
        return diffFound
    }

    fun String.returnCommonLetters(string: String): String {
        for (i in 0..10) {
            if (this[i] != string[i]) {
                return this.substring(0, i) + this.substring(i + 1, this.length)
            }
        }
        return this
    }
