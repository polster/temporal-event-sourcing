package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.inbound.rest

import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.model.Campaign
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.model.Views

fun Campaign.toDto() =
    CampaignDto(
        id = id.toString(),
        name = name,
        startDate = startDate,
        endDate = endDate
    )

fun Views.toDto() =
    ViewsDto(
        campaignId = campaignId,
        lineItemId = lineItemId,
        completedViews = completedViews
    )