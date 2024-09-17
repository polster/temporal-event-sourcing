package io.dietschi.edu.temporal_event_sourcing.campaign_events_processor.adapters.inbound.messaging

import io.dietschi.edu.temporal_event_sourcing.campaign_events_processor.adapters.inbound.toModel
import io.dietschi.edu.temporal_event_sourcing.campaign_events_processor.application.port.inbound.AddCampaignDataUseCase
import io.dietschi.edu.temporal_event_sourcing.schema.avro.CampaignCreated
import io.dietschi.edu.temporal_event_sourcing.schema.avro.ViewsCompleted
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class CampaignDataListener(
    private val addCampaignDataUseCase: AddCampaignDataUseCase
) {

    @KafkaListener(topics = ["\${app.kafka.topics.campaigns.name}"])
    fun event(campaignCreated: CampaignCreated) {
        log.debug("Received campaign created event with id: {}", campaignCreated.campaignId)
        addCampaignDataUseCase.addCampaign(campaignCreated.toModel())
    }

    @KafkaListener(topics = ["\${app.kafka.topics.completed-views.name}"])
    fun event(viewsCompleted: ViewsCompleted) {
        log.debug("Received views completed event with campaignId {}, lineItemId {}",
            viewsCompleted.campaignId, viewsCompleted.lineItemId)
        addCampaignDataUseCase.addViews(viewsCompleted.toModel())
    }

    companion object {
        private val log = LoggerFactory.getLogger(CampaignDataListener::class.java)
    }
}