package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.model

import java.util.*

data class Views(
    val campaignId: UUID,
    val lineItemId: UUID,
    val completedViews: Long
)
