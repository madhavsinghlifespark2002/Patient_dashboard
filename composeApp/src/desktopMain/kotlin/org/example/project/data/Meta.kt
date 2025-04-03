package org.example.project

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Meta (

  @SerialName("lastUpdated" ) var lastUpdated : String? = null,
  @SerialName("versionId"   ) var versionId   : String? = null

)