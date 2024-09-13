package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.inbound

import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.inbound.rest.CampaignDto
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.model.Campaign

fun Campaign.toDto(): CampaignDto {
    return CampaignDto(
        id = id.toString(),
        name = name,
        startDate = startDate,
        endDate = endDate
    )
}