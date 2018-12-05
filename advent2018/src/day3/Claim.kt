package day3

class Claim(claim: String) {
    var id: Int = 0
    var width: Int = 0
    var height: Int = 0

    var inchesFromTop: Int = 0
    var inchesFromLeft: Int = 0

    var hasOverlap: Boolean = false

    fun getFabricList(): ArrayList<SquareInchFabric> {
        val locations: ArrayList<SquareInchFabric> = ArrayList()

        for (x in 1..width) {
            for (y in 1..height) {
                locations.add(SquareInchFabric(inchesFromLeft + x, inchesFromTop + y, this))
            }
        }
        return locations
    }


    init {
        val claimList = ArrayList(claim.split("[^0-9]".toRegex()))
        claimList.removeIf { it == "" }

        id = claimList[0].toInt()
        inchesFromLeft = claimList[1].toInt()
        inchesFromTop = claimList[2].toInt()

        width = claimList[3].toInt()
        height = claimList[4].toInt()


    }
}
