package com.gotneb.lol_bookpedia.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PassiveModel(
    @SerialName("description")
    val name: String = "",
    @SerialName("image")
    val description: String = "",
    @SerialName("name")
    val image: ImageModel? = ImageModel(),
)
