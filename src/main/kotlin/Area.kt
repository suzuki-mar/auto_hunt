class Area {
    private var allLocations: List<Pair<List<Location>, Int>>
    private val avatar: Avatar = Avatar()

    init {
        allLocations = createAllLocations()
    }

    companion object {
        val X_RANGE = 1..10
        val Y_RANGE = 1..10

//        外部からも使用するので、companion objectに定義している
        fun checkBoundaryExceeded(position: Position) {
            if (!canMoveX(position)) {
                throw AreaBoundaryExceededException("Xが領域を超えています:${position.x}")
            }

            if (!canMoveY(position)) {
                throw AreaBoundaryExceededException("Yが領域を超えています:${position.y}")
            }
        }


        fun isWithinBounds(position: Position):Boolean {
            return canMoveX(position) && canMoveY(position)
        }

        private fun canMoveX(position: Position): Boolean {
            return X_RANGE.contains(position.x)
        }

        private fun canMoveY(position: Position): Boolean {
            return Y_RANGE.contains(position.y)
        }

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
        var newPosition = Direction.random().createNewPosition(avatar.currentPosition())
//        これぐらい回せば領域外には行かない
        for(i in 0 until 1000) {
            if (isWithinBounds(newPosition)) {
                break
            }
            newPosition = Direction.random().createNewPosition(avatar.currentPosition())
        }

        avatar.move(newPosition)
        checkBoundaryExceeded(avatar.currentPosition())

        allLocations = createAllLocations()
    }

    private fun createAllLocations():List<Pair<List<Location>, Int>> {
        val tmpAllLocations: MutableList<Pair<List<Location>, Int>> = mutableListOf()

        for (i in X_RANGE) {
            val locationLines = mutableListOf<Location>()

            for (j in Y_RANGE) {
                val position = Position(i, j)
                val location = Location(position)
                if (avatar.currentPosition() == position) {
                    location.update(avatar)
                }

                locationLines.add(location)
            }
            tmpAllLocations.add(Pair(locationLines, i))
        }

        return tmpAllLocations.toList()
    }



}