package io.dietschi.edu.temporal_event_sourcing.campaign_events_generator.adapters.outbound

import io.dietschi.edu.temporal_event_sourcing.campaign_events_generator.application.domain.model.Campaign
import io.dietschi.edu.temporal_event_sourcing.campaign_events_generator.application.domain.model.Views
import io.dietschi.edu.temporal_event_sourcing.schema.avro.CampaignCreated
import io.dietschi.edu.temporal_event_sourcing.schema.avro.ViewsCompleted

fun Campaign.toEvent(): CampaignCreated =
    CampaignCreated.newBuilder()
        .setCampaignId(this.id.toString())
        .setName(this.name)
        .setStartDate(this.startDate)
        .setEndDate(this.endDate)
        .build()

fun Views.toEvent(): ViewsCompleted =
    ViewsCompleted.newBuilder()
        .setCampaignId(this.campaignId.toString())
        .setLineItemId(this.lineItemId.toString())
        .setCompletedViews(this.completedViews)
        .setViewingWindowStart(this.viewingWindow.startDate)
        .setViewingWindowEnd(this.viewingWindow.endDate)
        .build()
