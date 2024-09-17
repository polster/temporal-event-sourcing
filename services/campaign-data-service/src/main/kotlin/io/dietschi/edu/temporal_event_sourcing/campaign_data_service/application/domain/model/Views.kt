package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.model

import java.time.LocalDateTime
import java.util.UUID

data class Views(
    val campaignId: UUID,
    val lineItemId: UUID,
    val completedViews: Int,
    val viewingWindow: ViewingWindow
) {
    data class ViewingWindow(
        val startDate: LocalDateTime,
        val endDate: LocalDateTime
    )
}
