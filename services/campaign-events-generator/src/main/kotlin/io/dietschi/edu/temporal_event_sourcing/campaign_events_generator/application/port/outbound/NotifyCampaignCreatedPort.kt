package io.dietschi.edu.temporal_event_sourcing.campaign_events_generator.application.port.outbound

import io.dietschi.edu.temporal_event_sourcing.campaign_events_generator.application.domain.model.Campaign

fun interface NotifyCampaignCreatedPort {

    fun notifyCampaignCreated(campaign: Campaign)
}