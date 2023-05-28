data class TurnResult(val turn: Int, val messages: List<String>) {
    override fun toString(): String {
        return "turn:$turn\n${messages.joinToString("\n")}\n"
    }
}
