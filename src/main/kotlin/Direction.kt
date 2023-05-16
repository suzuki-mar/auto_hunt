enum class Direction(val value: Int) {
    RIGHT(1) {
        override fun createNewPosition(oldPosition: Position): Position {
            return Position(oldPosition.x + 1, oldPosition.y)
        }
    },
    LEFT(2) {
        override fun createNewPosition(oldPosition: Position): Position {
            return Position(oldPosition.x - 1, oldPosition.y)
        }
    },
    UP(3) {
        override fun createNewPosition(oldPosition: Position): Position {
            return Position(oldPosition.x, oldPosition.y + 1)
        }
    },
    DOWN(4) {
        override fun createNewPosition(oldPosition: Position): Position {
            return Position(oldPosition.x, oldPosition.y - 1)
        }
    };

    abstract fun createNewPosition(oldPosition: Position): Position

    companion object {
        private val values = values()
        fun random(): Direction = values.random()
    }
}