package io.dietschi.edu.temporal_event_sourcing.campaign_events_processor.config

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class KafkaConfig(
    @Value("\${app.kafka.topics.campaigns.name}")
    private val campaignsTopic: String,
    @Value("\${app.kafka.topics.completed-views.name}")
    private val viewsTopic: String
) {

    @Bean
    fun campaignsTopic(): NewTopic =
        TopicBuilder.name(campaignsTopic)
            .partitions(10)
            .replicas(1)
            .build()

    @Bean
    fun completedViewsTopic(): NewTopic =
        TopicBuilder.name(viewsTopic)
            .partitions(10)
            .replicas(1)
            .build()
}