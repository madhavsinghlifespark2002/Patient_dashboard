package org.example.project.data

import kotlinx.serialization.Serializable
import org.example.project.Entry
import org.example.project.Link

@Serializable
data class FhirBundle(
    val entry: List<Entry>? = null,
    val link: List<Link>? = null,
    val resourceType: String? = null,
    val total: Int? = null,
    val type: String? = null,
)
