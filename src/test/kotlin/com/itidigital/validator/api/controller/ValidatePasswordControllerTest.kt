package com.itidigital.validator.api.controller

import com.itidigital.validator.api.dto.PasswordDTO
import com.itidigital.validator.api.service.ValidatePasswordService
import com.itidigital.validator.api.util.AbstractIntegrationTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.ResponseEntity
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest
@ActiveProfiles("test")
class ValidatePasswordControllerTest : AbstractIntegrationTest() {

    @Autowired
    private lateinit var validatePasswordController: ValidatePasswordController

    @MockBean
    override lateinit var validatePasswordService: ValidatePasswordService

    @Test
    fun shouldValidatePassword() {
        given(validator(PASSWORD)).willReturn(RETURN_PASSWORD)
        assertEquals(
            ResponseEntity.ok(RETURN_PASSWORD),
            validatePasswordController.validatePassword(password)
        )
    }

    private fun validator(password: String): Boolean =
        validatePasswordService.validatePassword(PasswordDTO(password))

    private companion object {
        const val PASSWORD = "AbTp9!fok"
        const val RETURN_PASSWORD = true

        val password = PasswordDTO(
            password = "AbTp9!fok"
        )
    }
}