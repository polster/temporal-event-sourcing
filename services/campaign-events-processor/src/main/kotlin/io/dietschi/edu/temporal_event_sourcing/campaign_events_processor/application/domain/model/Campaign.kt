package io.dietschi.edu.temporal_event_sourcing.campaign_events_processor.application.domain.model

import java.time.LocalDateTime
import java.util.UUID

data class Campaign(
    val id: UUID,
    val name: String,
    val startDate: LocalDateTime,
    val endDate: LocalDateTime
)
