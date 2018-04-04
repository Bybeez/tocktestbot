package fr.metapolis.tock.test.bot.connectorConfiguration

import fr.metapolis.tock.test.bot.testBot
import fr.vsct.tock.bot.connector.slack.addSlackConnector
import fr.vsct.tock.shared.property

object SlackConfiguration {
    /**
     * The Slack Workspace Id
     */
    val workspaceId : String = property("workspaceId", config[slack.workspaceId])

    /**
     * The Slack Webhook Id
     */
    val webhookId : String = property("webhookId", config[slack.webhookId])

    /**
     * The Slack authentification token
     */
    val authToken : String = property("authToken", config[slack.authToken])

    fun registerSlackConnector() {
        testBot.addSlackConnector(
                workspaceId,
                webhookId,
                authToken)
    }
}