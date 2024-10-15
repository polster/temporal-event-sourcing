package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.inbound.graphql

import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.model.Campaign
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.model.CampaignWithViews
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.model.Views

fun Campaign.toDto() =
    CampaignDto(
        id = id.toString(),
        name = name,
        startDate = startDate,
        endDate = endDate
    )

fun CampaignWithViews.toDto() =
    CampaignWithViewsDto(
        id = id.toString(),
        name = name,
        startDate = startDate,
        endDate = endDate,
        views = views.map { it.toDto() }
    )

fun Views.toDto() =
    ViewsDto(
        lineItemId = lineItemId,
        completedViews = completedViews
    )