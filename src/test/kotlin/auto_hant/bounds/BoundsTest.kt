package auto_hant.bounds


import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class BoundsTest : FunSpec({
    val bounds = Bounds()
    
    context("isWithinBounds") {
        context("Xのチェック") {
            test("移動できる場合はTrue") {
                val position = bounds.createPosition(bounds.x_range().last, 1)
                bounds.isWithinBounds(position) shouldBe true
            }

            test("移動できない場合はfalse") {
                val position = bounds.createPosition(bounds.x_range().last + 1, 1)
                bounds.isWithinBounds(position) shouldBe false
            }
        }

        context("Yのチェック") {
            test("移動できる場合はTrue") {
                val position = bounds.createPosition(1, bounds.y_range().last)
                bounds.isWithinBounds(position) shouldBe true
            }

            test("移動できない場合はfalse") {
                val position = bounds.createPosition(1, bounds.y_range().last + 1)
                bounds.isWithinBounds(position) shouldBe false
            }
        }

    }

})