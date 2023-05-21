import auto_hant.Mark
import auto_hant.Avatar

interface IArea {
    fun getAllLocationMarks(): List<List<Mark>>
    fun moveCharacter()
    fun getAvatar(): Avatar
}
