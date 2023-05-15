fun main(args: Array<String>) {
    val area = Area()
    val allMarks = area.getAllLocationMarks()
    val marksString = allMarks.joinToString("\n")
    println(marksString)
}