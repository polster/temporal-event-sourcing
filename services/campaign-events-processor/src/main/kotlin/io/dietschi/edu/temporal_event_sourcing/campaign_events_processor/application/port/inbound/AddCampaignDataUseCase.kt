package io.dietschi.edu.temporal_event_sourcing.campaign_events_processor.application.port.inbound

import io.dietschi.edu.temporal_event_sourcing.campaign_events_processor.application.domain.model.Campaign
import io.dietschi.edu.temporal_event_sourcing.campaign_events_processor.application.domain.model.Views

interface AddCampaignDataUseCase {

    fun addCampaign(campaign: Campaign)

    fun addViews(views: Views)
}