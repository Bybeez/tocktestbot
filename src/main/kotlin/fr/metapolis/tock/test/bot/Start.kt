package fr.metapolis.tock.test.bot

import fr.metapolis.tock.test.bot.connectorConfiguration.AlexaConfiguration.registerAlexaConnector
import fr.metapolis.tock.test.bot.connectorConfiguration.GoogleAssistantConfiguration.registerGoogleAssistantConnector
import fr.metapolis.tock.test.bot.connectorConfiguration.MessengerConfiguration.registerMessengerConnector
import fr.metapolis.tock.test.bot.connectorConfiguration.SlackConfiguration.registerSlackConnector
import fr.vsct.tock.bot.registerAndInstallBot


fun main(args: Array<String>) {
    Start.start()
}


/**
 * This is the entry point of the bot
 */
object Start {
    fun start() {
        //Set default zone id
        System.setProperty("tock_default_zone", "Europe/Paris")

        //adding connectors
        registerMessengerConnector()
        registerGoogleAssistantConnector()
        registerSlackConnector()
        registerAlexaConnector()

        registerAndInstallBot(testBot)
    }
}