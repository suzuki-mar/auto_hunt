package auto_hant

class Location(position: Position) {
    val x: Int = position.x
    val y: Int = position.y
    var mark: Mark = Mark.EMPTY

    fun update(avatar: Avatar? = null) {
        if (avatar != null) {
            mark = Mark.AVATAR
            return
        }
    }

    override fun toString(): String {
        return "X:${x.toString()} Y:${y.toString()}"
    }
}