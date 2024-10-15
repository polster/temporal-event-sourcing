package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.port.inbound

import java.time.LocalDateTime

data class CampaignQuery(
    val fromDate: LocalDateTime,
    val toDate: LocalDateTime,
    val asOfDateCompletedViews: LocalDateTime
)
