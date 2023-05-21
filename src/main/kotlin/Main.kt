import auto_hant.Area
import kotlinx.coroutines.delay

suspend fun main(args: Array<String>) {
//    Koinを使って依存性の注入をおこないたいけどエラーになるため直接インスタンスを取得している
//    val area: Area = get()
    val area:IArea = Area()
    printMarksString(area)

    for (i in 0 until 100) {
        delay(1500)
        area.moveCharacter()
        printMarksString(area)
    }
}

fun printMarksString(area: IArea) {
    val allMarks = area.getAllLocationMarks()
    println("avatar position:${area.getAvatar().currentPosition()}")
    println("${allMarks.joinToString("\n")}\n--------------------------\n")
}