package org.example.project

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Extension (

  @SerialName("url"         ) var url         : String? = null,
  @SerialName("valueString" ) var valueString : String? = null

)