package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.model

import java.time.LocalDateTime
import java.util.UUID

data class Campaign(
    val id: UUID,
    val name: String,
    val startDate: LocalDateTime,
    val endDate: LocalDateTime
)
