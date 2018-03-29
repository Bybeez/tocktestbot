package fr.metapolis.tock.test.bot

import fr.metapolis.tock.test.bot.story.greeting
import fr.vsct.tock.bot.definition.bot

val testBot = bot(
        "test-bot",
        stories =
        listOf(
                greeting
        )
)