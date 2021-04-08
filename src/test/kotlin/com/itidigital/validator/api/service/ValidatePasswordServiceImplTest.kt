package com.itidigital.validator.api.service

import com.itidigital.validator.api.dto.PasswordDTO
import com.itidigital.validator.api.util.AbstractIntegrationTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ValidatePasswordServiceImplTest : AbstractIntegrationTest() {

    @Test
    fun validateCorrectPassword() {
        assertEquals(true, validator("AbTp9!fok"))
    }

    @Test
    fun validateWrongPassword() {
        assertEquals(false, validator(""))
        assertEquals(false, validator("aa"))
        assertEquals(false, validator("ab"))
        assertEquals(false, validator("AAAbbbCc"))
        //assertEquals(false, validator("AbTp9!foo"))
        //assertEquals(false, validator("AbTp9!foA"))
        assertEquals(false, validator("AbTp9 fok"))
    }

    private fun validator (password: String): Boolean {
        return validatePasswordService.validatePassword(PasswordDTO(password))
    }
}