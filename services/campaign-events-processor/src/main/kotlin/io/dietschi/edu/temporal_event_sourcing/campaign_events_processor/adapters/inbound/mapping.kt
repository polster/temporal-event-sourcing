package io.dietschi.edu.temporal_event_sourcing.campaign_events_processor.adapters.inbound

import io.dietschi.edu.temporal_event_sourcing.campaign_events_processor.application.domain.model.Campaign
import io.dietschi.edu.temporal_event_sourcing.campaign_events_processor.application.domain.model.Views
import io.dietschi.edu.temporal_event_sourcing.schema.avro.CampaignCreated
import io.dietschi.edu.temporal_event_sourcing.schema.avro.ViewsCompleted
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.*

fun CampaignCreated.toModel(): Campaign =
    Campaign(
        id = UUID.fromString(this.campaignId.toString()),
        name = this.name.toString(),
        startDate = LocalDateTime.of(this.startDate, LocalTime.MIN),
        endDate = LocalDateTime.of(this.endDate, LocalTime.MAX)
    )

fun ViewsCompleted.toModel(): Views =
    Views(
        campaignId = UUID.fromString(this.campaignId.toString()),
        lineItemId = UUID.fromString(this.lineItemId.toString()),
        completedViews = this.completedViews,
        viewingWindow = Views.ViewingWindow(
            startDate = this.viewingWindowStart,
            endDate = this.viewingWindowEnd
        )
    )