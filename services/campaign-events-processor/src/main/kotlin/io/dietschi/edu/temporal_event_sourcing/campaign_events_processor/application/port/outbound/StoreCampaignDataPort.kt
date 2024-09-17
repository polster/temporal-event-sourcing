package io.dietschi.edu.temporal_event_sourcing.campaign_events_processor.application.port.outbound

import io.dietschi.edu.temporal_event_sourcing.campaign_events_processor.application.domain.model.Campaign
import io.dietschi.edu.temporal_event_sourcing.campaign_events_processor.application.domain.model.Views

interface StoreCampaignDataPort {

    fun storeCampaign(campaign: Campaign)

    fun storeViews(views: Views)
}