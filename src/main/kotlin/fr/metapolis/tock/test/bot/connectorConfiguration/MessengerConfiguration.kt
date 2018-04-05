package fr.metapolis.tock.test.bot.connectorConfiguration

import fr.metapolis.tock.test.bot.testBot
import fr.vsct.tock.bot.connector.messenger.addMessengerConnector
import fr.vsct.tock.shared.property

/**
 * Contains the configuration to add a Messenger connector to the bot
 */
object MessengerConfiguration {

    /**
     * The facebook page id.
     */
    private val pageId: String = property("tock_bot_open_data_page_id", config[messenger.pageId])

    /**
     * The messenger page token.
     */
    private val pageToken: String = property("tock_bot_open_data_page_token", config[messenger.pageToken])

    /**
     * The messenger application secret key.
     */
    private val applicationSecret: String = property("tock_bot_open_data_application_secret", config[messenger.applicationSecret])

    /**
     * The webhook verify token.
     */
    private val webhookVerifyToken: String = property("tock_bot_open_data_webhook_verify_token", config[messenger.webhookVerifyToken])

    /**
     * Add a Messenger connector to the bot
     */
    fun registerMessengerConnector() {
        testBot.addMessengerConnector(
                pageId,
                pageToken,
                applicationSecret,
                webhookVerifyToken)
    }
}