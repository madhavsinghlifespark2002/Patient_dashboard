package org.example.project

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Text (

  @SerialName("div"    ) var div    : String? = null,
  @SerialName("status" ) var status : String? = null

)