import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.assertions.throwables.shouldThrow

class AreaTest : FunSpec({
    context("findByLocationByPosition") {
        context("範囲指定が正しい場合") {
            test("Locationを取得できていること") {
                val area = Area()
                area.findLocationByPosition(Position(4, 3)).toString() shouldBe  "X:4 Y:3"
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

    context("getAllLocationMarks") {
        test("X分のMark一覧を取得できるていること") {
            val area = Area()
            val marks = area.getAllLocationMarks()
            marks.count() shouldBe Area.X_RANGE.count()
        }
        test("Y分のMark一覧を取得できるていること") {
            val area = Area()
            val marks = area.getAllLocationMarks()
            marks[0].count() shouldBe Area.Y_RANGE.count()
        }
    }

    context("moveCharacter") {
        context("領域内の移動ができていること") {
            test("Characterが移動できていること") {
                val area = Area()
                val avatar = area.getAvatar()
                val oldPosition = avatar.currentPosition()
                area.moveCharacter()
                avatar.currentPosition() shouldNotBe oldPosition

            }
        }

        context("領域外の移動をした場合") {
            test("Characterが移動できていること") {
                val area = Area()
                shouldThrow<AreaBoundaryExceededException> {
//                    実際にどれぐらいでエラーになるかわからないため最大値を設定している
                    for (i in 0 until Int.MAX_VALUE) {
                        area.moveCharacter()
                        println(area.getAvatar().currentPosition())
                    }
                }


            }
        }

    }
})