package auto_hant

import auto_hant.bounds.Bounds
import auto_hant.bounds.IBounds
import auto_hant.bounds.Position

class Avatar {

    private var position: Position

    init {
        val bounds:IBounds = Bounds()
        position = bounds.createRandomPosition()
    }

    fun move(newPosition: Position) {
        position = newPosition
    }

    fun currentPosition(): Position {
        return position
    }

}