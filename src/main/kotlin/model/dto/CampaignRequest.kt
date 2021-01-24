package model.dto

import model.entity.CampaignEntity
import java.util.*


data class CampaignRequest(

    val name: String,
    val description: String,
    val active: Active // BE checkmark representation of an enum class representing if a user is active or not active.
)

fun CampaignRequest.toEntity(): CampaignEntity {
    return CampaignEntity(
        UUID.randomUUID(),
        this.name,
        this.description,
        this.active
    )
}