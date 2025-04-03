package org.example.project

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Identifier (

  @SerialName("assigner" ) var assigner : Assigner? = Assigner(),
  @SerialName("period"   ) var period   : Period?   = Period(),
  @SerialName("system"   ) var system   : String?   = null,
  @SerialName("type"     ) var type     : Type?     = Type(),
  @SerialName("use"      ) var use      : String?   = null,
  @SerialName("value"    ) var value    : String?   = null

)