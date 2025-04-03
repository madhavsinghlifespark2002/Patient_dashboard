package org.example.project

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Period (

  @SerialName("start" ) var start : String? = null

)