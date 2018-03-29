package fr.metapolis.tock.test.bot.connectorConfiguration

import fr.metapolis.tock.test.bot.testBot
import fr.vsct.tock.bot.connector.messenger.addMessengerConnector
import fr.vsct.tock.shared.property

object MessengerConfiguration {

    /**
     * The facebook page id.
     */
    val pageId: String = property("tock_bot_open_data_page_id", "Please specify facebook page id")

    /**
     * The messenger page token.
     */
    val pageToken: String = property("tock_bot_open_data_page_token", "Please specify facebook page token")

    /**
     * The messenger application secret key.
     */
    val applicationSecret: String = property("tock_bot_open_data_application_secret", "Please specify messenger application secret")

    /**
     * The webhook verify token.
     */
    val webhookVerifyToken: String = property("tock_bot_open_data_webhook_verify_token", "Please specify messenger webhook verify token")

    fun registerMessengerConnector() {
        addMessengerConnector(
                pageId,
                pageToken,
                applicationSecret,
                webhookVerifyToken,
                name = testBot.botId)
    }
}