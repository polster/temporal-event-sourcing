package io.dietschi.edu.temporal_event_sourcing.campaign_events_generator.adapters.outbound.messaging

import io.dietschi.edu.temporal_event_sourcing.campaign_events_generator.adapters.outbound.toEvent
import io.dietschi.edu.temporal_event_sourcing.campaign_events_generator.application.domain.model.Campaign
import io.dietschi.edu.temporal_event_sourcing.campaign_events_generator.application.port.outbound.NotifyCampaignCreatedPort
import org.springframework.stereotype.Component

@Component
class NotifyCampaignCreatedAdapter(
    private val kafkaCampaignProducer: KafkaCampaignProducer
): NotifyCampaignCreatedPort {

    override fun notifyCampaignCreated(campaign: Campaign) =
        kafkaCampaignProducer.send(campaign.toEvent())
}