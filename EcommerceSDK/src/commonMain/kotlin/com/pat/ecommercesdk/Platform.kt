package com.pat.ecommercesdk

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform