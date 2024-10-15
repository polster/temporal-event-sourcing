package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.outbound

import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.outbound.persistence.campaign.CampaignEntity
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.outbound.persistence.views.ViewsAsOf
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.model.Campaign
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.model.Views

fun CampaignEntity.toDomain() =
    Campaign(
        id = campaignId,
        name = name,
        startDate = startDate,
        endDate = endDate
    )

fun ViewsAsOf.toDomain() =
    Views(
        campaignId = campaignId,
        lineItemId = lineItemId,
        completedViews = completedViews
    )
