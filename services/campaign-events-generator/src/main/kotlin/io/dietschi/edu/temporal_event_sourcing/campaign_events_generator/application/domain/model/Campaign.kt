package io.dietschi.edu.temporal_event_sourcing.campaign_events_generator.application.domain.model

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

data class Campaign(
    val id: UUID,
    val name: String,
    val startDate: LocalDate,
    val endDate: LocalDate
)
