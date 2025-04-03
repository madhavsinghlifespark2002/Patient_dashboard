package org.example.project

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Telecom (

  @SerialName("use" ) var use : String? = null

)