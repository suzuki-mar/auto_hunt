package auto_hant

import ISimulator
import TurnResult

class Simulator(private val area: Area = Area()):ISimulator {
    private var allMessages = listOf<Pair<Int, String>>()
    private var count = 0

    override fun progress() {
        count++
        area.moveCharacter()
        allMessages = allMessages + createCurrentSituationMessages()
    }


    override fun prepare() {
        allMessages = allMessages + createCurrentSituationMessages()
    }

    override fun obtainResult(): List<TurnResult> {
        val counts = allMessages.map { it.first }.toSet()
        val turnResults = mutableListOf<TurnResult>()

        for (count in counts) {
            val turnMessage = allMessages.filter { it.first == count }.map{ it.second }


            val result = TurnResult(count, turnMessage)
            turnResults.add(result)
        }

        return turnResults
    }

    private
    fun createCurrentSituationMessages(): List<Pair<Int, String>> {
        val messages = mutableListOf<Pair<Int, String>>()
        messages.add(
            Pair(count, "avatar position:${area.getAvatar().currentPosition()}")
        )

        val allMarks = area.getAllLocationMarks()
        messages.add(
            Pair(count, "${allMarks.joinToString("\n")}\n--------------------------\n")
        )

        return messages.toList()
    }

}