package com.itidigital.validator.api.controller

import com.itidigital.validator.api.common.properties.ApplicationProperties
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.actuate.health.Health
import org.springframework.boot.actuate.health.HealthIndicator
import org.springframework.boot.actuate.health.Status
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RestController

/**
 * @author Davi Peterlini
 */
@Component
class
HealthIndicatorCustom @Autowired constructor(
    private val applicationProperties: ApplicationProperties
) : HealthIndicator {
    companion object {
        const val BUILD_NUMBER = "buildNumber"
    }

    override fun health(): Health {
        return Health.status(Status.UP)
            .withDetail(BUILD_NUMBER, applicationProperties.buildNumber)
            .build()
    }
}