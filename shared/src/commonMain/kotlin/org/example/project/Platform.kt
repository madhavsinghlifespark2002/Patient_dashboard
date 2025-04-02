package org.example.project

interface Platform {
    val name: String
}
expect fun openWebView(url: String)
expect fun getPlatform(): Platform