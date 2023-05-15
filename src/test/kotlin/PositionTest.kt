import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class PositionTest : FunSpec({
    context("move") {
        context("RIGHTの場合") {
            test("→に1マス進んでいること") {
                val avatar = AvatarMock(Direction.RIGHT)
                avatar.move()
                val compare = Position(AvatarMock.INITIAL_COORDINATES + 1, AvatarMock.INITIAL_COORDINATES)
                avatar.currentPosition() shouldBe compare
            }
        }

        context("LEFTの場合") {
            test("←に1マス進んでいること") {
                val avatar = AvatarMock(Direction.LEFT)
                avatar.move()
                val compare = Position(AvatarMock.INITIAL_COORDINATES - 1, AvatarMock.INITIAL_COORDINATES)
                avatar.currentPosition() shouldBe compare
            }
        }

        context("UPの場合") {
            test("↑に1マス進んでいること") {
                val avatar = AvatarMock(Direction.UP)
                avatar.move()
                val compare = Position(AvatarMock.INITIAL_COORDINATES, AvatarMock.INITIAL_COORDINATES + 1)
                avatar.currentPosition() shouldBe compare
            }
        }

        context("DOWNの場合") {
            test("↓に1マス進んでいること") {
                val avatar = AvatarMock(Direction.DOWN)
                avatar.move()
                val compare = Position(AvatarMock.INITIAL_COORDINATES, AvatarMock.INITIAL_COORDINATES - 1)
                avatar.currentPosition() shouldBe compare
            }
        }
    }
})