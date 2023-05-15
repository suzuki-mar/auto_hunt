// moveはランダムな挙動なのでMockクラスを使用してランダムで生成する部分を固定にする
// モッククラスと実クラスが同じインターフェイスを実装していることを保証するためにインターフェイスを定義している
interface IAvatar {
    fun move()
    fun currentPosition(): Position
}