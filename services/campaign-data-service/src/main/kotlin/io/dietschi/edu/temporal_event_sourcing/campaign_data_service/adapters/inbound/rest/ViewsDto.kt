package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.inbound.rest

import java.util.UUID

data class ViewsDto(
    val campaignId: UUID,
    val lineItemId: UUID,
    val completedViews: Long
)