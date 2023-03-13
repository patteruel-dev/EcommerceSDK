package com.pat.ecommercesdk

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking

abstract class BaseTest {
    fun <T> runTest(block: suspend CoroutineScope.() -> T) {
        runBlocking { block() }
    }
}