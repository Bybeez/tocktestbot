package fr.metapolis.tock.test.bot.connectorConfiguration

import fr.metapolis.tock.test.bot.testBot
import fr.vsct.tock.bot.connector.ga.addGoogleAssistantConnector

/**
 * Contains the configuration to add a Google Assistant connector to the bot
 */
object GoogleAssistantConfiguration {

    /**
     * Add a Google Assistant connector to the bot
     */
    fun registerGoogleAssistantConnector(){
        testBot.addGoogleAssistantConnector()
    }
}