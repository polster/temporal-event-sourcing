package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.port.outbound

import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.model.Campaign
import java.util.UUID

interface QueryCampaignsPort {

    fun queryCampaigns(): List<Campaign>
    fun queryCampaign(id: UUID): Campaign
}