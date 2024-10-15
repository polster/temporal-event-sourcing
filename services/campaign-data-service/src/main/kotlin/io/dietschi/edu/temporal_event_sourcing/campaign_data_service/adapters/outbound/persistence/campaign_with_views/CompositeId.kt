package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.outbound.persistence.campaign_with_views

import jakarta.persistence.Embeddable
import java.io.Serializable
import java.time.LocalDateTime
import java.util.*

@Embeddable
class CompositeId(
    val lineItemId: UUID,
    val viewingWindowStart: LocalDateTime,
    val viewingWindowEnd: LocalDateTime
): Serializable