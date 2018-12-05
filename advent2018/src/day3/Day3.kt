package day3

fun main(args: Array<String>) {
    partOne()
}

fun partOne(){
    val inputList = AdventUtil.getInputArray("day3/input", "\n")
    var overlappingInches = 0

    val fabricInUse = ArrayList<SquareInchFabric>()

    for(item in inputList){
        val claim = Claim(item)

        println("starting with claim #" + claim.id)

        for (fabric in claim.getFabricList()){
            var newFabricPiece = true

            for(usedFabric in fabricInUse){
                if(fabric.atSameLocation(usedFabric)) {
                    newFabricPiece = false
                    usedFabric.hasClaimOverlap = true
                    break
                }
            }

            if(newFabricPiece) {
                fabricInUse.add(fabric)
            }
        }
    }

    for (fabric in fabricInUse){
        if(fabric.hasClaimOverlap){
            overlappingInches++
        }
    }
    println(overlappingInches)
}
