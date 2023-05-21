package auto_hant

data class Position(val x: Int, val y: Int) {
    companion object {
        fun createRandomPosition(): Position {
            val x = Area.X_RANGE.random()
            val y = Area.Y_RANGE.random()

            return Position(x, y)
        }
    }
}
