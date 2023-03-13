package com.pat.ecommercesdk

import kotlin.test.Test
import kotlin.test.assertEquals

class StorefrontTester: BaseTest() {
    @Test
    fun `Test Products`() = runTest {
        // given
        val manager = EcommerceManager()

        // when
        val result = manager.getProducts()

        // then
        println("Result: $result")
        assertEquals(1, result.count())
    }
}