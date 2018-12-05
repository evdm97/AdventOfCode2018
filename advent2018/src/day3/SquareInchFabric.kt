package day3

class SquareInchFabric(val inchesFromLeft: Int, val inchesFromTop: Int) {
    var hasClaimOverlap: Boolean = true

    fun atSameLocation(fabric: SquareInchFabric): Boolean {
        return fabric.inchesFromLeft == inchesFromLeft &&
                fabric.inchesFromTop == inchesFromTop
    }
}