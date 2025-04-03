package org.example.project

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Address (

  @SerialName("city"       ) var city       : String?           = null,
  @SerialName("district"   ) var district   : String?           = null,
  @SerialName("line"       ) var line       : ArrayList<String> = arrayListOf(),
  @SerialName("period"     ) var period     : Period?           = Period(),
  @SerialName("postalCode" ) var postalCode : String?           = null,
  @SerialName("state"      ) var state      : String?           = null,
  @SerialName("type"       ) var type       : String?           = null,
  @SerialName("use"        ) var use        : String?           = null

)