package fr.metapolis.tock.test.bot.story

import fr.metapolis.tock.test.bot.rule.TestBotRule
import fr.metapolis.tock.test.bot.testBot
import fr.vsct.tock.bot.connector.alexa.AlexaMessage
import fr.vsct.tock.bot.connector.alexa.alexaConnectorType
import fr.vsct.tock.bot.connector.ga.gaConnectorType
import fr.vsct.tock.bot.connector.ga.gaMessage
import fr.vsct.tock.bot.connector.messenger.buttonsTemplate
import fr.vsct.tock.bot.connector.messenger.postbackButton
import fr.vsct.tock.bot.connector.slack.emoji
import fr.vsct.tock.bot.connector.slack.model.SlackEmoji
import fr.vsct.tock.bot.connector.slack.slackConnectorType
import fr.vsct.tock.bot.connector.slack.textMessage
import fr.vsct.tock.bot.test.startNewBusMock
import org.junit.Rule
import org.junit.Test

class GreetingTest {

    @Rule
    @JvmField
    val rule = TestBotRule()

    @Test
    fun `greeting story display welcome message`() {
        with(testBot.startNewBusMock()) {
            firstAnswer.assertText("Bienvenue sur le test du bot Tock de Metapolis")
            secondAnswer.assertText("C'est un bot de test du framework Tock : https://github.com/voyages-sncf-technologies/tock")
        }
    }

    @Test
    fun `greeting story display welcome message with Messenger dedicated message WHEN no connector is passed to the context`() {
        with(testBot.startNewBusMock()) {
            firstAnswer.assertText("Bienvenue sur le test du bot Tock de Metapolis")
            secondAnswer.assertText("C'est un bot de test du framework Tock : https://github.com/voyages-sncf-technologies/tock")
            lastAnswer.assertMessage(
                    buttonsTemplate(
                            "Il peut se connecter sur Messenger",
                            postbackButton("Bonjour", greeting))
            )
        }
    }

    @Test
    fun `greeting story display welcome message with GA dedicated message WHEN context contains a GA connector`()
    {
        with(testBot.startNewBusMock(connectorType = gaConnectorType)) {
            firstAnswer.assertText("Bienvenue sur le test du bot Tock de Metapolis")
            secondAnswer.assertText("C'est un bot de test du framework Tock : https://github.com/voyages-sncf-technologies/tock")
            lastAnswer.assertMessage(
                    gaMessage(
                            "Il peut se connecter au Google Assistant",
                            "Bonjour"
                    )
            )
        }
    }

    @Test
    fun `greeting story display welcome message with Slack dedicated message WHEN context contains a Slack connector`()
    {
        with(testBot.startNewBusMock(connectorType = slackConnectorType)) {
            firstAnswer.assertText("Bienvenue sur le test du bot Tock de Metapolis")
            secondAnswer.assertText("C'est un bot de test du framework Tock : https://github.com/voyages-sncf-technologies/tock")
            lastAnswer.assertMessage(
                    textMessage("Il peut se connecter sur Slack! ${emoji(SlackEmoji.SMILE)}")
            )
        }
    }

    @Test
    fun `greeting story display welcome message with Alexa dedicated message WHEN context contains an Alexa connector`()
    {
        with(testBot.startNewBusMock(connectorType = alexaConnectorType)) {
            firstAnswer.assertText("Bienvenue sur le test du bot Tock de Metapolis")
            secondAnswer.assertText("C'est un bot de test du framework Tock : https://github.com/voyages-sncf-technologies/tock")
            lastAnswer.assertMessage(
                    AlexaMessage(
                            false,
                            null,
                            "Et a Alexa"
                    )
            )
        }
    }
}
