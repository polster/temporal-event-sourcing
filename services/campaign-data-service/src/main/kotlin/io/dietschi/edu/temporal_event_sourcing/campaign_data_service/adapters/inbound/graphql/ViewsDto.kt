package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.inbound.graphql

import java.util.*

data class ViewsDto(
    val lineItemId: UUID,
    val completedViews: Long)