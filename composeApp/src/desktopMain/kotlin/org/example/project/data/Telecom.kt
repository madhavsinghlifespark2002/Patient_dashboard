package org.example.project

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName
@Serializable
data class Telecom(
  @SerialName("system") val system: String? = null,
  @SerialName("value") val value: String? = null,
  @SerialName("use") val use: String? = null,
  @SerialName("rank") val rank: Int? = null
)