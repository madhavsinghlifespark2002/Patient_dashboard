package org.example.project

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Search (

  @SerialName("mode" ) var mode : String? = null

)