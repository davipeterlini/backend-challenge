package com.itidigital.validator.api.common

class Validator {
    companion object {
        private const val PASSWORD_REGEX = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[!@#|$%^&*()-+]).{9,}$"
        private const val PASSWORD_REGEX_REPEAT_CHAR = "(.)(.*\\1+)"

        fun validateRepeatedCharacters(password: String): Boolean {
            return PASSWORD_REGEX_REPEAT_CHAR.toRegex().containsMatchIn(password.toUpperCase())
        }

        fun validatePasswordWithRegex(password: String): Boolean {
            return PASSWORD_REGEX.toRegex().matches(password)
        }
    }
}