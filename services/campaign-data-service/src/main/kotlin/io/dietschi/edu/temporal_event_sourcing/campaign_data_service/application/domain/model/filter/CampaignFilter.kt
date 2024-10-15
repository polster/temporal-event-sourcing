package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.model.filter

import java.time.LocalDateTime

data class CampaignFilter(
    val fromDate: LocalDateTime,
    val toDate: LocalDateTime
)
