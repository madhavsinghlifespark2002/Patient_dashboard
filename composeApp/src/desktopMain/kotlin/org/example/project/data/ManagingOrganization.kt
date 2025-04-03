package org.example.project

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class ManagingOrganization (

  @SerialName("reference" ) var reference : String? = null

)