class Avatar {

    private var position: Position = Position.createRandomPosition()

    fun move(newPosition: Position) {
        position = newPosition
    }

    fun currentPosition(): Position {
        return position
    }

}