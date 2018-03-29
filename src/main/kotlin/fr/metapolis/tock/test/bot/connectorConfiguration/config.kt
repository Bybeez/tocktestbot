package fr.metapolis.tock.test.bot.connectorConfiguration

import com.natpryce.konfig.*

object slack : PropertyGroup() {
    val path by stringType
    val workspaceId by stringType
    val webhookId by stringType
    val authToken by stringType
}

val config = ConfigurationProperties.fromResource(".secret")