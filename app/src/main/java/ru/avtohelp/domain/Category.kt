package ru.avtohelp.domain

/**
 * Категория заявки
 */
class Category(name: String) {
    companion object {
        fun validateName(name: String): Boolean {
            return name.isNotEmpty()
        }
    }

    var name: String = checkNotNullArg(name, ::validateName)
        private set(value) {
            checkNotNullArg(name, ::validateName)
            field = value
        }

    var description: String? = null

    init {
        this.name = name
    }
}