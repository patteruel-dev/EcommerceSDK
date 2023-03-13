package com.pat.ecommercesdk

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.http.HttpHeader
import com.pat.ecommercesdk.storefront.CheckoutQuery
import com.pat.ecommercesdk.storefront.ProductsQuery

class EcommerceManager {
    private val apolloClient = ApolloClient.Builder()
        .serverUrl("https://patteruel-dev.myshopify.com/api/2023-04/graphql.json")
        .httpHeaders(listOf(
            HttpHeader("X-Shopify-Storefront-Access-Token", "6198734acc5aa0b9701ba36f4c24714a")
        ))
        .build()

    @Throws(Exception::class)
    suspend fun getProducts(): List<ProductsQuery.Node> {
        val query = ProductsQuery(100)

        val result = apolloClient.query(query).execute()
        return result.data?.products?.nodes ?: listOf()
    }

    @Throws(Exception::class)
    suspend fun getCheckout(id: String): CheckoutQuery.OnCheckout? {
        val query = CheckoutQuery(id)
        val result = apolloClient.query(query).execute()
        return result.data?.node?.onCheckout
    }
}