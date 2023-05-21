import kotlinx.coroutines.delay


suspend fun main(args: Array<String>) {
    val area = Area()
    printMarksString(area)

    for (i in 0 until 100) {
        delay(2000)
        area.moveCharacter()
        printMarksString(area)
    }
}

fun printMarksString(area: Area) {
    val allMarks = area.getAllLocationMarks()
    println("avatar position:${area.getAvatar().currentPosition()}")
    println("${allMarks.joinToString("\n")}\n--------------------------\n")
}