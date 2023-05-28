package auto_hant.bounds

import auto_hant.AreaBoundaryExceededException

class Bounds: IBounds {
    override fun x_range(): IntRange {
        return 1..10
    }

    override fun y_range(): IntRange {
        return 1..10
    }

    override fun checkBoundaryExceeded(position: Position) {
        if (!canMoveX(position)) {
            throw AreaBoundaryExceededException("Xが領域を超えています:${position.x}")
        }

        if (!canMoveY(position)) {
            throw AreaBoundaryExceededException("Yが領域を超えています:${position.y}")
        }
    }

    override fun isWithinBounds(position: Position):Boolean {
        return canMoveX(position) && canMoveY(position)
    }

    override fun createPosition(x: Int, y: Int):Position {
        return Position(x, y)
    }

    override fun createRandomPosition():Position {
        return Position(x_range().random(), y_range().random())
    }


    private fun canMoveX(position: Position): Boolean {
        return x_range().contains(position.x)
    }

    private fun canMoveY(position: Position): Boolean {
        return y_range().contains(position.y)
    }
}