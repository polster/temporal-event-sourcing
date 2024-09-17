package io.dietschi.edu.temporal_event_sourcing.campaign_events_generator.adapters.outbound.messaging

import io.dietschi.edu.temporal_event_sourcing.campaign_events_generator.adapters.outbound.toEvent
import io.dietschi.edu.temporal_event_sourcing.campaign_events_generator.application.domain.model.Views
import io.dietschi.edu.temporal_event_sourcing.campaign_events_generator.application.port.outbound.NotifyViewsCompletedPort
import org.springframework.stereotype.Component

@Component
class NotifyViewsCompletedAdapter(
    private val kafkaViewsProducer: KafkaViewsProducer
): NotifyViewsCompletedPort {

    override fun notifyViewsCompleted(views: Views) =
        kafkaViewsProducer.send(views.toEvent())
}