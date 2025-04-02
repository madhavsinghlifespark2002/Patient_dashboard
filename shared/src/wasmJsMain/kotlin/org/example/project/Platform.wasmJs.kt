package org.example.project

class WasmPlatform: Platform {
    override val name: String = "Web with Kotlin/Wasm"
}

actual fun getPlatform(): Platform = WasmPlatform()
actual fun openWebView(url: String) {
    TODO("Not yet implemented")
}