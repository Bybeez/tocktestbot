package fr.metapolis.tock.test.bot.connectorConfiguration

import fr.metapolis.tock.test.bot.testBot
import fr.vsct.tock.bot.connector.alexa.addAlexaConnector

/**
 * Contains the configuration to connect an Alexa connector to the bot
 */
object AlexaConfiguration {

    /**
     * Add an Alexa connector to the bot
     */
    fun registerAlexaConnector(){
        testBot.addAlexaConnector()
    }
}