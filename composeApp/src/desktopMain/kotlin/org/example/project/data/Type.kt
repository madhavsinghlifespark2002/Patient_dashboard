package org.example.project

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Type (

  @SerialName("coding" ) var coding : ArrayList<Coding> = arrayListOf()

)