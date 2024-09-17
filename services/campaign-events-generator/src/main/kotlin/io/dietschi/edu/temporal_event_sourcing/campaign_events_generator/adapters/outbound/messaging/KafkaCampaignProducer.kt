package io.dietschi.edu.temporal_event_sourcing.campaign_events_generator.adapters.outbound.messaging

import io.dietschi.edu.temporal_event_sourcing.schema.avro.CampaignCreated
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class KafkaCampaignProducer(
    @Value("\${app.kafka.topics.campaigns.name}")
    private val campaignsTopic: String,
    private val kafkaTemplate: KafkaTemplate<String, CampaignCreated>
) {

    fun send(campaignCreated: CampaignCreated) {
        kafkaTemplate.send(campaignsTopic, campaignCreated)
    }
}