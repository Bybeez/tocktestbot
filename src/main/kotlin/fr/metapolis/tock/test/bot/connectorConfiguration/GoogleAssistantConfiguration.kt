package fr.metapolis.tock.test.bot.connectorConfiguration

import fr.metapolis.tock.test.bot.testBot
import fr.vsct.tock.bot.connector.ga.addGoogleAssistantConnector

object GoogleAssistantConfiguration {

    fun registerGoogleAssistantConnector(){
        addGoogleAssistantConnector(testBot.botId)
    }
}