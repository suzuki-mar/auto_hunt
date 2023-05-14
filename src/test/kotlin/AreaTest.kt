import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.assertions.throwables.shouldThrow

class AreaTest : FunSpec({
    context("findByLocationByPosition") {
        context("範囲指定が正しい場合") {
            test("Locationを取得できていること") {
                val area = Area()
                area.findLocationByPosition(Position(4, 3)).toString() shouldBe  "X:4 Y:3"

                println(Area.X_RANGE.last)
            }
        }

        context("Xの範囲指定が間違っている場合") {
            test("エラーが発生すること") {
                shouldThrow<IllegalArgumentException> {
                    val area = Area()
                    area.findLocationByPosition(Position(Area.X_RANGE.last + 1, 3))
                }
            }
        }

        context("Yの範囲指定が間違っている場合") {
            test("エラーが発生すること") {
                shouldThrow<IllegalArgumentException> {
                    val area = Area()
                    area.findLocationByPosition(Position(1, Area.Y_RANGE.last + 1))
                }
            }
        }


    }
})