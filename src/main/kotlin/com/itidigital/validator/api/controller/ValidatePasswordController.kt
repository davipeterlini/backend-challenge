package com.itidigital.validator.api.controller

import com.itidigital.validator.api.dto.PasswordDTO
import com.itidigital.validator.api.service.ValidatePasswordService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author Davi Peterlini
 */
@RestController
@RequestMapping("/api/validate/password")
class ValidatePasswordController @Autowired constructor(private val validatePasswordService: ValidatePasswordService) {
    @PostMapping
    fun validatePassword(@RequestBody passwordDTO: PasswordDTO): ResponseEntity<Boolean> {
        return ResponseEntity.ok(validatePasswordService.validatePassword(passwordDTO))
    }
}