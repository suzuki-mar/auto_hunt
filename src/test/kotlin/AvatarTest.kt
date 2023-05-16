import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.assertions.throwables.shouldThrow

class PositionTest : FunSpec({
    context("move") {
        context("正常系") {
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

        context("Areaの領域を超えている場合") {
            context("Xのチェック") {
                test("領域を超えたエラーが発生すること") {

                    val avatar = AvatarMock(Direction.RIGHT)
                    shouldThrow<AreaBoundaryExceededException> {
                        for (i in Area.X_RANGE) {
                            avatar.move()
                        }
                    }
                }
            }

            context("Yのチェック") {
                test("領域を超えたエラーが発生すること") {

                    val avatar = AvatarMock(Direction.UP)
                    shouldThrow<AreaBoundaryExceededException> {
                        for (i in Area.Y_RANGE) {
                            avatar.move()
                        }
                    }
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

    }
})