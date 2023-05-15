import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldNotBe

class AvatarTest : FunSpec({
    context("move") {
        context("RIGHTの場合") {
            test("右に1マス進んでいること") {
                val avatar = AvatarMock(Direction.RIGHT)
                val oldPosition = avatar.currentPosition()
                avatar.move()
                avatar.currentPosition() shouldNotBe oldPosition
            }
        }
    }
})