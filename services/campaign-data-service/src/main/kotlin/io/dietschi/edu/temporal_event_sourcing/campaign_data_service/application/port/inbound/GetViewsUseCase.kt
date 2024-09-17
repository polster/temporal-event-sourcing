package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.port.inbound

import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.model.Views

fun interface GetViewsUseCase {

    fun getViews(query: Query): List<Views>
}