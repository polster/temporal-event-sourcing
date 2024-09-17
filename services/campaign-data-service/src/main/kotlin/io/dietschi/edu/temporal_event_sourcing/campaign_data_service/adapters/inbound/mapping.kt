package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.inbound

import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.inbound.rest.CampaignDto
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.inbound.rest.ViewsDto
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.model.Campaign
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.model.Views

fun Campaign.toDto(): CampaignDto {
    return CampaignDto(
        id = id.toString(),
        name = name,
        startDate = startDate,
        endDate = endDate
    )
}

fun Views.toDto(): ViewsDto {
    return ViewsDto(
        campaignId = campaignId,
        lineItemId = lineItemId,
        completedViews = completedViews
    )
}