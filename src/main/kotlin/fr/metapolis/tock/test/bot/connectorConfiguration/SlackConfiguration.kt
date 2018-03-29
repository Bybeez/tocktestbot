package fr.metapolis.tock.test.bot.connectorConfiguration

import fr.metapolis.tock.test.bot.testBot
import fr.vsct.tock.bot.connector.slack.addSlackConnector
import fr.vsct.tock.shared.property

object SlackConfiguration {

    /**
     * The path to the bot http endppoint
     */
    val path: String = property("/path-to-my-slack-bot-http-endpoint", "/Please specify slack bot http endpoint")

    /**
     * The bot name
     */
    val name : String = property("slack-bot-name", "Metapolis-bot")

    /**
     * The Slack Workspace Id
     */
    val workspaceId : String = property("workspaceId", "Please specify a workspace Id")

    /**
     * The Slack Webhook Id
     */
    val webhookId : String = property("webhookId", "Please specify a slack webhook id")

    /**
     * The Slack authentification token
     */
    val authToken : String = property("authToken", "Please specify an authentification tocken")

    fun registerSlackConnector(){
        addSlackConnector(
                testBot.botId,
                path,
                name,
                workspaceId,
                webhookId,
                authToken)
    }
}