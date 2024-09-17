package io.dietschi.edu.temporal_event_sourcing.campaign_events_processor.adapters.outbound.persistence

import io.dietschi.edu.temporal_event_sourcing.campaign_events_processor.adapters.outbound.persistence.campaign.PostgresCampaignRepository
import io.dietschi.edu.temporal_event_sourcing.campaign_events_processor.adapters.outbound.persistence.views.PostgresViewsRepository
import io.dietschi.edu.temporal_event_sourcing.campaign_events_processor.adapters.outbound.toEntity
import io.dietschi.edu.temporal_event_sourcing.campaign_events_processor.application.domain.model.Campaign
import io.dietschi.edu.temporal_event_sourcing.campaign_events_processor.application.domain.model.Views
import io.dietschi.edu.temporal_event_sourcing.campaign_events_processor.application.port.outbound.StoreCampaignDataPort
import org.springframework.stereotype.Component

@Component
class StoreCampaignDataAdapter(
    private val postgresCampaignRepository: PostgresCampaignRepository,
    private val postgresViewsRepository: PostgresViewsRepository
) : StoreCampaignDataPort {

    override fun storeCampaign(campaign: Campaign) {
        postgresCampaignRepository.save(campaign.toEntity())
    }

    override fun storeViews(views: Views) {
        postgresViewsRepository.save(views.toEntity())
    }
}