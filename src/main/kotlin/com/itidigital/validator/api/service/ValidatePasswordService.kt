package com.itidigital.validator.api.service

import com.itidigital.validator.api.dto.PasswordDTO

/**
 * @author Davi Peterlini
 */
interface ValidatePasswordService {
    fun validatePassword(passwordDTO: PasswordDTO): Boolean
}