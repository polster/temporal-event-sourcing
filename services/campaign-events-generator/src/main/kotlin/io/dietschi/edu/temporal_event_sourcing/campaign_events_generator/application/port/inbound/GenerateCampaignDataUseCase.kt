package io.dietschi.edu.temporal_event_sourcing.campaign_events_generator.application.port.inbound

fun interface GenerateCampaignDataUseCase {

    fun generateCampaignData()
}