package com.pat.ecommercesdk

import com.apollographql.apollo3.ApolloClient
import com.pat.ecommercesdk.storefront.ProductsQuery
import com.pat.ecommercesdk.storefront.type.Product

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}