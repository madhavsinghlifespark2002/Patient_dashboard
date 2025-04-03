package org.example.project

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class BirthDate (

  @SerialName("extension" ) var extension : ArrayList<Extension> = arrayListOf()

)