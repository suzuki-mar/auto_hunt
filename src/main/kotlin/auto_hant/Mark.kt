package auto_hant

enum class Mark {
    EMPTY {
        override fun toString(): String {
            return " "
        }
    },

    AVATAR {
        override fun toString(): String {
            return "A"
        }
    }
}