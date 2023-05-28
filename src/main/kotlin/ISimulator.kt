interface ISimulator {
    fun progress()
    fun prepare()
    fun obtainResult(): List<TurnResult>
}