package com.gotneb.lol_bookpedia.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PassiveModel(
    @SerialName("name")
    val name: String? = "",
    @SerialName("image")
    val image: ImageModel? = ImageModel(),
    @SerialName("description")
    val description: String? = "",
)
