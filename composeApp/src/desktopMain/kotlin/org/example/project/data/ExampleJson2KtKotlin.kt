package org.example.project

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class ExampleJson2KtKotlin (

  @SerialName("entry"        ) var entry        : ArrayList<Entry> = arrayListOf(),
  @SerialName("link"         ) var link         : ArrayList<Link>  = arrayListOf(),
  @SerialName("resourceType" ) var resourceType : String?          = null,
  @SerialName("total"        ) var total        : Int?             = null,
  @SerialName("type"         ) var type         : String?          = null

)