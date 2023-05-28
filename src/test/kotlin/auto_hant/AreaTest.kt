package auto_hant

import auto_hant.bounds.Bounds
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.assertions.throwables.shouldThrow

class AreaTest : FunSpec({
    val area = Area()
    val bounds = Bounds()

    context("findByLocationByPosition") {
        context("範囲指定が正しい場合") {
            test("Locationを取得できていること") {
                area.findLocationByPosition(bounds.createPosition(4, 3)).toString() shouldBe  "X:4 Y:3"
            }
        }

        context("Xの範囲指定が間違っている場合") {
            test("エラーが発生すること") {
                shouldThrow<IllegalArgumentException> {
                    area.findLocationByPosition(bounds.createPosition(area.x_range().last + 1, 3))
                }
            }
        }

        context("Yの範囲指定が間違っている場合") {
            test("エラーが発生すること") {
                shouldThrow<IllegalArgumentException> {
                    area.findLocationByPosition(bounds.createPosition(1, area.y_range().last + 1))
                }
            }
        }
    }

    context("getAllLocationMarks") {
        lateinit var  marks:  List<List<Mark>>

        beforeEach {
            marks = area.getAllLocationMarks()
        }

        test("X分のMark一覧を取得できるていること") {
            marks.count() shouldBe  area.x_range().last
        }
        test("Y分のMark一覧を取得できるていること") {
            marks[0].count() shouldBe area.y_range().last
        }
        test("Avatarが存在すること") {
            val exists = marks.any { lineMarks ->
                lineMarks.any { mark ->
                    mark == Mark.AVATAR
                }
            }

            exists shouldBe true
        }

        test("Avatarが存在すること") {
            val exists = marks.any { lineMarks ->
                lineMarks.any { mark ->
                    mark == Mark.AVATAR
                }
            }

            exists shouldBe true
        }
    }

    context("moveCharacter") {
        test("Characterが移動できていること") {
            val avatar = area.getAvatar()
            val oldPosition = avatar.currentPosition()
            area.moveCharacter()
            avatar.currentPosition() shouldNotBe oldPosition

        }

        test("領域外には移動しないこと") {
            for (i in 0 until 1000) {
                area.moveCharacter()
            }
        }
    }



    context("getAvatar") {
        test("Avatarが取得できて所属しているローケーションも取得できること") {
            val avatar =  area.getAvatar()
            val location = area.findLocationByPosition(avatar.currentPosition())
            location!!.mark shouldBe Mark.AVATAR
        }
    }


})