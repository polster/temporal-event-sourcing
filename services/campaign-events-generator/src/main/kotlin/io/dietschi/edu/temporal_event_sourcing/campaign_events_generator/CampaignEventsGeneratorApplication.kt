package io.dietschi.edu.temporal_event_sourcing.campaign_events_generator

import io.dietschi.edu.temporal_event_sourcing.campaign_events_generator.application.port.inbound.GenerateCampaignDataUseCase
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class CampaignEventsGeneratorApplication(
    private val generateCampaignDataUseCase: GenerateCampaignDataUseCase
): CommandLineRunner {

    override fun run(vararg args: String?) = generateCampaignDataUseCase.generateCampaignData()
}

fun main(args: Array<String>) {
    SpringApplication.run(CampaignEventsGeneratorApplication::class.java, *args)
}