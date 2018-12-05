package day3

class SquareInchFabric(var inchesFromLeft: Int, var inchesFromTop: Int, val originalClaim: Claim) {
    var hasClaimOverlap: Boolean = false

    fun atSameLocation(fabric: SquareInchFabric): Boolean {
        return fabric.inchesFromLeft == inchesFromLeft &&
                fabric.inchesFromTop == inchesFromTop
    }

}