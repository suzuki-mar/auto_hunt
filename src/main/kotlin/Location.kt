class Location(position: Position) {
    val x: Int = position.x
    val y: Int = position.y
    var mark: Mark = Mark.EMPTY

    override fun toString(): String {
        return "X:${x.toString()} Y:${y.toString()}"
    }
}