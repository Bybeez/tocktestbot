package fr.metapolis.tock.test.bot.rule

import fr.metapolis.tock.test.bot.testBot
import fr.vsct.tock.bot.test.TestContext
import fr.vsct.tock.bot.test.junit.TockJUnit4Rule

class TestBotRule : TockJUnit4Rule<TestContext>(testBot)