package org.example.project

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Link (

  @SerialName("relation" ) var relation : String? = null,
  @SerialName("url"      ) var url      : String? = null

)