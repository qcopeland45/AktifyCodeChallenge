package model.dto

import java.util.*

data class CampaignResponse(
    val id: UUID,
    val name: String,
    val description: String,
    val active: Active
)


