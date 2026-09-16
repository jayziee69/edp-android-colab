package com.example.myapplication.data.network.dto

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonPrimitive

@Serializable
data class MessageDto(
    val id: String? = null,
    val sender: String? = null,
    val text: String? = null,
    @Serializable(with = FlexibleLongSerializer::class)
    val createdAt: Long? = null
)

@Serializable
data class NewMessageDto(
    val sender: String,
    val text: String,
    val createdAt: Long
)

object FlexibleLongSerializer : KSerializer<Long?> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("FlexibleLong", PrimitiveKind.LONG)

    override fun deserialize(decoder: Decoder): Long? {
        val element = (decoder as JsonDecoder).decodeJsonElement()
        if (element is JsonPrimitive) {
            return try {
                element.content.toLong()
            } catch (e: Exception) {
                null
            }
        }
        return null
    }

    override fun serialize(encoder: Encoder, value: Long?) {
        if (value != null) encoder.encodeLong(value) else encoder.encodeNull()
    }
}
