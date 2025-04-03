package org.example.project

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Contact (

  @SerialName("address"      ) var address      : Address?                = Address(),
  @SerialName("gender"       ) var gender       : String?                 = null,
  @SerialName("name"         ) var name         : Name?                   = Name(),
  @SerialName("period"       ) var period       : Period?                 = Period(),
  @SerialName("relationship" ) var relationship : ArrayList<Relationship> = arrayListOf(),
  @SerialName("telecom"      ) var telecom      : ArrayList<Telecom>      = arrayListOf()

)