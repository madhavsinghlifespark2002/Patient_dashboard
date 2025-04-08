package org.example.project

import kotlinx.serialization.Serializable

@Serializable
data class Entry(
    var fullUrl: String? = null,
    var resource: Resourcem? = null,
    var search: Search? = null
)