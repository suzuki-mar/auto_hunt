class Area() {
    private val allLocations: MutableList<Pair<List<Location>, Int>> = mutableListOf()
    private val avatar: Avatar = Avatar()
    init {
        for (i in X_RANGE) {
            val locationLines = mutableListOf<Location>()

            for (j in Y_RANGE) {
                val position = Position(i, j)
                locationLines.add(Location(position))
            }
            allLocations.add(Pair(locationLines, i))
        }
    }

    companion object {
        val X_RANGE = 1..10
        val Y_RANGE = 1..10

    }

    fun findLocationByPosition(position: Position): Location? {
        if (position.x > X_RANGE.last) {
            throw IllegalArgumentException("Positionのxが最大値より大きかったです　指定した値${position.x} 最大値${X_RANGE.last}}")
        }

        if (position.y > Y_RANGE.last) {
            throw IllegalArgumentException("Positionのyが最大値より大きかったです　指定した値${position.y} 最大値${Y_RANGE.last}}")
        }

        val lineLocations = allLocations[position.x -1].first
        return lineLocations.find { it.x == position.x && it.y == position.y }
    }

    fun getAvatar(): Avatar {
        return avatar
    }

    fun getAllLocationMarks(): List<List<Mark>> {
        val allLocationMarks = mutableListOf<List<Mark>>()

        for (i in X_RANGE) {
            val locationMarks = mutableListOf<Mark>()

            for (j in Y_RANGE) {
                val position = Position(i, j)
                val location = findLocationByPosition(position)
                locationMarks.add(location!!.mark)
            }
            allLocationMarks.add(locationMarks)
        }

        return allLocationMarks
    }

    fun moveCharacter() {
        avatar.move()
    }

}