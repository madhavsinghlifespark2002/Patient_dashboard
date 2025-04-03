package org.example.project

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Name (

  @SerialName("family" ) var family : String?           = null,
  @SerialName("given"  ) var given  : ArrayList<String> = arrayListOf(),
  @SerialName("use"    ) var use    : String?           = null

)