package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.outbound.persistence.views

import jakarta.persistence.Column
import java.util.*

class ViewsAsOf(
    val campaignId: UUID,
    val lineItemId: UUID,
    @Column(name = "sum")
    val completedViews: Long
)