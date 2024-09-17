package io.dietschi.edu.temporal_event_sourcing.campaign_events_processor.application.domain.services

import io.dietschi.edu.temporal_event_sourcing.campaign_events_processor.application.domain.model.Campaign
import io.dietschi.edu.temporal_event_sourcing.campaign_events_processor.application.domain.model.Views
import io.dietschi.edu.temporal_event_sourcing.campaign_events_processor.application.port.inbound.AddCampaignDataUseCase
import io.dietschi.edu.temporal_event_sourcing.campaign_events_processor.application.port.outbound.StoreCampaignDataPort
import org.springframework.stereotype.Service

@Service
class CampaignDataService(
    private val storeCampaignDataPort: StoreCampaignDataPort
): AddCampaignDataUseCase {

    override fun addCampaign(campaign: Campaign) =
        storeCampaignDataPort.storeCampaign(campaign)

    override fun addViews(views: Views) =
        storeCampaignDataPort.storeViews(views)
}