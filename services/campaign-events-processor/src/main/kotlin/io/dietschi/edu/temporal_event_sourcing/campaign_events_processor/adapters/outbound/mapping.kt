package io.dietschi.edu.temporal_event_sourcing.campaign_events_processor.adapters.outbound

import io.dietschi.edu.temporal_event_sourcing.campaign_events_processor.adapters.outbound.persistence.campaign.CampaignEntity
import io.dietschi.edu.temporal_event_sourcing.campaign_events_processor.adapters.outbound.persistence.views.ViewsEntity
import io.dietschi.edu.temporal_event_sourcing.campaign_events_processor.application.domain.model.Campaign
import io.dietschi.edu.temporal_event_sourcing.campaign_events_processor.application.domain.model.Views

fun Campaign.toEntity(): CampaignEntity =
    CampaignEntity(
        campaignId = this.id,
        name = this.name,
        startDate = this.startDate,
        endDate = this.endDate
    )

fun Views.toEntity(): ViewsEntity =
    ViewsEntity(
        campaignId = this.campaignId,
        lineItemId = this.lineItemId,
        completedViews = this.completedViews,
        viewingWindowStart = this.viewingWindow.startDate,
        viewingWindowEnd = this.viewingWindow.endDate
    )