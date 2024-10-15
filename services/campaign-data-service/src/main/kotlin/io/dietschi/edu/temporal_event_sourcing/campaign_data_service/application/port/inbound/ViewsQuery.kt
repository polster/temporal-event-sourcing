package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.port.inbound

import java.time.LocalDateTime
import java.util.UUID

data class ViewsQuery(
    val campaignId: UUID,
    val asOfDate: LocalDateTime
)
