package auto_hant.bounds

interface IBounds {
    fun x_range(): IntRange
    fun y_range(): IntRange

    fun checkBoundaryExceeded(position: Position)

    fun isWithinBounds(position: Position):Boolean

    fun createPosition(x: Int, y: Int):Position

    fun createRandomPosition():Position
}