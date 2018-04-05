package fr.metapolis.tock.test.bot.connectorConfiguration

import fr.metapolis.tock.test.bot.testBot
import fr.vsct.tock.bot.connector.slack.addSlackConnector
import fr.vsct.tock.shared.property

/**
 * Contains the configuration to add a Slack connector to the bot
 */
object SlackConfiguration {
    /**
     * The Slack Workspace Id
     */
    private val workspaceId : String = property("workspaceId", config[slack.workspaceId])

    /**
     * The Slack Webhook Id
     */
    private val webhookId : String = property("webhookId", config[slack.webhookId])

    /**
     * The Slack authentification token
     */
    private val authToken : String = property("authToken", config[slack.authToken])

    /**
     * Add a Slack connector to the bot
     */
    fun registerSlackConnector() {
        testBot.addSlackConnector(
                workspaceId,
                webhookId,
                authToken)
    }
}