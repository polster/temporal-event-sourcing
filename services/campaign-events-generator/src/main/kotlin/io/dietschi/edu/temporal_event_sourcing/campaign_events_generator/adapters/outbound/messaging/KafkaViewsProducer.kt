package io.dietschi.edu.temporal_event_sourcing.campaign_events_generator.adapters.outbound.messaging

import io.dietschi.edu.temporal_event_sourcing.schema.avro.ViewsCompleted
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class KafkaViewsProducer(
    @Value("\${app.kafka.topics.completed-views.name}")
    private val viewsTopic: String,
    private val kafkaTemplate: KafkaTemplate<String, ViewsCompleted>
) {

    fun send(viewsCompleted: ViewsCompleted) {
        kafkaTemplate.send(viewsTopic, viewsCompleted)
    }
}