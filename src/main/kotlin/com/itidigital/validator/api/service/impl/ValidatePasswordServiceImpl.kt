package com.itidigital.validator.api.service.impl

import com.itidigital.validator.api.common.Validator
import com.itidigital.validator.api.dto.PasswordDTO
import com.itidigital.validator.api.service.ValidatePasswordService
import org.springframework.stereotype.Service

@Service
class ValidatePasswordServiceImpl : ValidatePasswordService {

    override fun validatePassword(passwordDTO: PasswordDTO): Boolean {
        val password = passwordDTO.password
        return when {
            password.isBlank() -> false
            !Validator.validatePasswordWithRegex(password) -> false
            Validator.validateRepeatedCharacters(password) -> false
            else -> true
        }
    }
}