package io.dietschi.edu.temporal_event_sourcing.campaign_data_service

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CampaignDataServiceApplication {
}

fun main(args: Array<String>) {
    runApplication<CampaignDataServiceApplication>(*args)
}