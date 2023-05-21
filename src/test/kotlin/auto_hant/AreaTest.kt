package auto_hant

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
        test("Characterが移動できていること") {
            val area = Area()
            val avatar = area.getAvatar()
            val oldPosition = avatar.currentPosition()
            area.moveCharacter()
            avatar.currentPosition() shouldNotBe oldPosition

        }

        test("領域外には移動しないこと") {
            val area = Area()
            for (i in 0 until 1000) {
                area.moveCharacter()
            }
        }
    }

    context("isWithinBounds") {
        context("Xのチェック") {
            test("移動できる場合はTrue") {
                val position = Position(Area.X_RANGE.last, 1)
                Area.isWithinBounds(position) shouldBe true
            }

            test("移動できない場合はfalse") {
                val position = Position(Area.X_RANGE.last + 1, 1)
                Area.isWithinBounds(position) shouldBe false
            }
        }

        context("Yのチェック") {
            test("移動できる場合はTrue") {
                val position = Position(1, Area.Y_RANGE.last)
                Area.isWithinBounds(position) shouldBe true
            }

            test("移動できない場合はfalse") {
                val position = Position(1, Area.Y_RANGE.last + 1)
                Area.isWithinBounds(position) shouldBe false
            }
        }


    }

    context("getAvatar") {
        test("Avatarが取得できて所属しているローケーションも取得できること") {
            val area = Area()
            val avatar =  area.getAvatar()
            val location = area.findLocationByPosition(avatar.currentPosition())
            location!!.mark shouldBe Mark.AVATAR
        }
    }


})