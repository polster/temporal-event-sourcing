package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.inbound.rest

data class CompletedView
    (val id: String,
     val lineItemId: Int,
     val completedViews: Int)
