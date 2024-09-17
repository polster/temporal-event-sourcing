package io.dietschi.edu.temporal_event_sourcing.campaign_events_processor.application.port.inbound

import io.dietschi.edu.temporal_event_sourcing.campaign_events_processor.application.domain.model.Views

fun interface AddViewsUseCase {

    fun addViews(views: Views)
}