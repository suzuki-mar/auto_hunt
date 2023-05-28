package auto_hant

import TurnResult
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SimulatorTest : FunSpec({
    test("一通りの処理を実行できることfindByLocationByPosition") {
        val simulator = Simulator()
        simulator.prepare()
        simulator.progress()
        simulator.progress()
        (simulator.obtainResult() is List<TurnResult>) shouldBe true
        simulator.obtainResult().count() shouldBe 3


        println(simulator.obtainResult())
    }

})