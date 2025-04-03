package org.example.project

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Coding (

  @SerialName("code"   ) var code   : String? = null,
  @SerialName("system" ) var system : String? = null

)