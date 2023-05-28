package auto_hant

import auto_hant.bounds.Bounds
import auto_hant.bounds.Position

class Area {
    private var allLocations: List<Pair<List<Location>, Int>>
    private val avatar: Avatar = Avatar()
    private val bounds = Bounds()

    init {
        allLocations = createAllLocations()
    }

    fun x_range(): IntRange {
        return bounds.x_range()
    }

    fun y_range(): IntRange {
        return bounds.y_range()
    }

    fun findLocationByPosition(position: Position): Location? {
        if (position.x > x_range().last) {
            throw IllegalArgumentException("Positionのxが最大値より大きかったです　指定した値${position.x} 最大値${x_range().last}}")
        }

        if (position.y > y_range().last) {
            throw IllegalArgumentException("Positionのyが最大値より大きかったです　指定した値${position.y} 最大値${y_range().last}}")
        }

        val lineLocations = allLocations[position.x -1].first
        return lineLocations.find { it.x == position.x && it.y == position.y }
    }

    fun getAvatar(): Avatar {
        return avatar
    }

     fun getAllLocationMarks(): List<List<Mark>> {
        val allLocationMarks = mutableListOf<List<Mark>>()

        for (i in x_range()) {
            val locationMarks = mutableListOf<Mark>()

            for (j in y_range()) {
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
            if (bounds.isWithinBounds(newPosition)) {
                break
            }
            newPosition = Direction.random().createNewPosition(avatar.currentPosition())
        }

        avatar.move(newPosition)
        bounds.checkBoundaryExceeded(avatar.currentPosition())

        allLocations = createAllLocations()
    }

    private fun createAllLocations():List<Pair<List<Location>, Int>> {
        val tmpAllLocations: MutableList<Pair<List<Location>, Int>> = mutableListOf()

        for (i in x_range()) {
            val locationLines = mutableListOf<Location>()

            for (j in y_range()) {
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