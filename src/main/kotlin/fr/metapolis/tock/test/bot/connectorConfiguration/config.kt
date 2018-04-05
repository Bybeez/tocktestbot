package fr.metapolis.tock.test.bot.connectorConfiguration

import com.natpryce.konfig.*

object slack : PropertyGroup() {
    val workspaceId by stringType
    val webhookId by stringType
    val authToken by stringType
}

object messenger : PropertyGroup() {
    val pageId by stringType
    val pageToken by stringType
    val applicationSecret by stringType
    val webhookVerifyToken by stringType
}

val config = ConfigurationProperties.fromResource(".secret")