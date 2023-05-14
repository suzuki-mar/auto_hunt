import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class SampleTest : StringSpec({
    "length should return size of string" {
        "hello".length shouldBe 4
    }
})