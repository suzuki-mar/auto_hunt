import auto_hant.Area
import auto_hant.Simulator
import kotlinx.coroutines.delay

suspend fun main(args: Array<String>) {
//    Koinを使って依存性の注入をおこないたいけどエラーになるため直接インスタンスを取得している
    val simulator:ISimulator = Simulator()

    simulator.prepare()

    for (i in 0 until 100) {
        simulator.progress()
    }

    for (result in simulator.obtainResult()) {
        println(result)
        delay(1500)
    }
}
