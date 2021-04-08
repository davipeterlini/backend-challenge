package com.itidigital.validator.api.util

import com.itidigital.validator.api.ValidatorPasswordApiApplication
import com.itidigital.validator.api.service.ValidatePasswordService
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension

/**
 * Class should be extended by @Controller's classes. This class is responsible to abstract the
 * integration tests configurations.
 */
@ActiveProfiles("test")
@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [ValidatorPasswordApiApplication::class])
abstract class AbstractIntegrationTest {
    @Autowired
    protected lateinit var validatePasswordService: ValidatePasswordService
}