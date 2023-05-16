fun main(args: Array<String>) {
    val area = Area()
    printMarksString(area)

    area.moveCharacter()
    printMarksString(area)
}

fun printMarksString(area: Area) {
    val allMarks = area.getAllLocationMarks()
    println("${allMarks.joinToString("\n")}\n--------------------------\n")
}