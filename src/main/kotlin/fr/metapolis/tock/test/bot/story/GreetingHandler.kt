package fr.metapolis.tock.test.bot.story

import fr.vsct.tock.bot.connector.ConnectorMessage
import fr.vsct.tock.bot.connector.alexa.AlexaHandler
import fr.vsct.tock.bot.connector.ga.GAHandler
import fr.vsct.tock.bot.connector.ga.gaMessage
import fr.vsct.tock.bot.connector.messenger.MessengerHandler
import fr.vsct.tock.bot.connector.messenger.buttonsTemplate
import fr.vsct.tock.bot.connector.messenger.postbackButton
import fr.vsct.tock.bot.connector.slack.SlackHandler
import fr.vsct.tock.bot.connector.slack.emoji
import fr.vsct.tock.bot.connector.slack.model.SlackEmoji
import fr.vsct.tock.bot.connector.slack.textMessage
import fr.vsct.tock.bot.definition.ConnectorDef
import fr.vsct.tock.bot.definition.HandlerDef
import fr.vsct.tock.bot.definition.storyDef
import fr.vsct.tock.bot.engine.BotBus

/**
 * Define the story, and contains entity dependent logic
 */
val greeting = storyDef<GreetingDef>(
        "greeting"){
    resetDialogState()
}

/**
 * Implement the Handler Interface and contains the logic to handle entities and respond to the user
 */
@MessengerHandler(MessengerGreetingConnector::class)
@GAHandler(GAGreetingConnector::class)
@SlackHandler(SlackGreetingConnector::class)
class GreetingDef(bus: BotBus) : HandlerDef<GreetingConnector>(bus)
{
    override fun answer() {
        send("Bienvenue sur le test du bot Tock de Metapolis")
        send("C'est un bot de test du framework Tock : https://github.com/voyages-sncf-technologies/tock")
        connector?.sendGreetingMessage()  /** If there is a connector, uses it to send a message using the GreetingConnector sealed class **/
        end()
    }
}

/**
 * Used to wrap Connector specific behaviour
 */
sealed class GreetingConnector(context : GreetingDef) : ConnectorDef<GreetingDef>(context) {
    fun sendGreetingMessage() = withMessage(greetingMessage())

    abstract fun greetingMessage(): ConnectorMessage
}

/**
 * Implements the greeting message with Messenger specific behaviour
 */
class MessengerGreetingConnector(context: GreetingDef) : GreetingConnector(context) {
    override fun greetingMessage() : ConnectorMessage =
        buttonsTemplate(
                "Il peut se connecter sur Messenger",
                postbackButton("Bonjour", greeting))
}

/**
 * Implements the greeting message with GA specific behaviour
 */
class GAGreetingConnector(context: GreetingDef) : GreetingConnector(context) {
    override fun greetingMessage() : ConnectorMessage =
        gaMessage(
                "Il peut se connecter au Google Assistant",
                "Bonjour"
        )
}

/**
 * Implements the greeting message with Slack specific behaviour
 */
class SlackGreetingConnector(context: GreetingDef) : GreetingConnector(context) {
    override fun greetingMessage() : ConnectorMessage =
            textMessage("Il peut se connecter sur Slack! ${emoji(SlackEmoji.SMILE)}")
}