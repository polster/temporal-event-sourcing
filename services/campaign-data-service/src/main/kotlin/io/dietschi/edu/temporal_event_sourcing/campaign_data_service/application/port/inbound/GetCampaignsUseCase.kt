package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.port.inbound

import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.model.Campaign
import java.util.UUID

interface GetCampaignsUseCase {

    fun getCampaign(id: UUID): Campaign

    fun getCampaigns(): List<Campaign>
}