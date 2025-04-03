package org.example.project

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Resourcem (
  @SerialName("_birthDate") var birthDateDetails: BirthDate? = null,
  @SerialName("active") var active: Boolean? = null,
  @SerialName("address") var address: List<Address> = emptyList(),
  @SerialName("birthDate") var birthDate: String? = null,
  @SerialName("contact") var contact: List<Contact> = emptyList(),
  @SerialName("deceasedBoolean") var deceasedBoolean: Boolean? = null,
  @SerialName("gender") var gender: String? = null,
  @SerialName("id") var id: String? = null,
  @SerialName("identifier") var identifier: List<Identifier> = emptyList(),
  @SerialName("managingOrganization") var managingOrganization: ManagingOrganization? = null,
  @SerialName("meta") var meta: Meta? = null,
  @SerialName("name") var name: List<Name> = emptyList(),
  @SerialName("resourceType") var resourceType: String? = null,
  @SerialName("telecom") var telecom: List<Telecom> = emptyList(),
  @SerialName("text") var text: Text? = Text()
)