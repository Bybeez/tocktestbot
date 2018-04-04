package fr.metapolis.tock.test.bot.connectorConfiguration

import fr.metapolis.tock.test.bot.testBot
import fr.vsct.tock.bot.connector.alexa.addAlexaConnector

/**
 * Add an Alexa connector to the testBot, not yet fully implemented
 */
object AlexaConfiguration {

    fun registerAlexaConnector(){
        testBot.addAlexaConnector()
    }
}