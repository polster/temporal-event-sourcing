package io.dietschi.edu.temporal_event_sourcing.campaign_events_processor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CampaignEventsProcessor {
}

fun main(args: Array<String>) {
    runApplication<CampaignEventsProcessor>(*args)
}