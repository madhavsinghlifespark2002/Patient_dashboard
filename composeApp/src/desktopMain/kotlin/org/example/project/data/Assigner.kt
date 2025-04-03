package org.example.project

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Assigner (

  @SerialName("display" ) var display : String? = null

)