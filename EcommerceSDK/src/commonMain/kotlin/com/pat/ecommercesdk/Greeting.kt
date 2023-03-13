package com.pat.ecommercesdk

import com.apollographql.apollo3.ApolloClient
import com.pat.ecommercesdk.storefront.ProductsQuery

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }

    suspend fun getProducts() {
        val query = ProductsQuery(100)

        val apolloClient = ApolloClient.Builder()
            .serverUrl("https://patteruel-dev.myshopify.com/api/2023-04/graphql.json")
            .build()
        val result = apolloClient.query(query).execute()
        val title = result.data?.products?.nodes?.first()?.title
        println(title)
    }
}