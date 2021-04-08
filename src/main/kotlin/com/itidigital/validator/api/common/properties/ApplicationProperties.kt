package com.itidigital.validator.api.common.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "app.global-config")
class ApplicationProperties : BaseUrlProperties()

abstract class BaseUrlProperties {
    lateinit var buildNumber: String
}