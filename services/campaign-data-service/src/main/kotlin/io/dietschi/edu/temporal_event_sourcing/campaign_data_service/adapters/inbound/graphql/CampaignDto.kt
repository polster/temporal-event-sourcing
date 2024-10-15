package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.inbound.graphql

import java.time.LocalDateTime

data class CampaignDto(
    val id: String,
    val name: String,
    val startDate: LocalDateTime,
    val endDate: LocalDateTime,
    val views: List<ViewsDto>)

