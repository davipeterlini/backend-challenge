package com.itidigital.validator.api.service.impl

import com.itidigital.validator.api.dto.PasswordDTO
import com.itidigital.validator.api.service.ValidatePasswordService
import org.springframework.stereotype.Service

@Service
class ValidatePasswordServiceImpl : ValidatePasswordService {

    override fun validatePassword(passwordDTO: PasswordDTO): Boolean {
        return PASSWORD_REGEX.toRegex().matches(passwordDTO.password)
    }

    companion object {
        const val PASSWORD_REGEX = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[!@#|$%^&*()-+]).{9,}$"
    }
}