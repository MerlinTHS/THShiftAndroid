package de.ths.thshift.config

import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.verify.verify

/**
 * This class tests all modules that koin uses for dependency injection.
 */
class KoinModuleTest : KoinTest {
    @Test
    fun checkAllModules() {
        AppModule.verify()
    }
}