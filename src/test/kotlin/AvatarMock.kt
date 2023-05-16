
class AvatarMock(private var direction:Direction) : IAvatar {
    private var position = Position(INITIAL_COORDINATES, INITIAL_COORDINATES)
    companion object {
        const val INITIAL_COORDINATES = 2
    }

    override fun move() {
        val newPosition = direction.createNewPosition(currentPosition())

        Area.checkBoundaryExceeded(newPosition)

        position = newPosition
    }

    override fun currentPosition():Position {
        return position
    }
}
