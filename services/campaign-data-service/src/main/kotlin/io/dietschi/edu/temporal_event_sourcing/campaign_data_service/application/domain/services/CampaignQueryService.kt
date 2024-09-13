package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.services

import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.model.Campaign
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.port.inbound.GetCampaignsUseCase
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.port.outbound.QueryCampaignsPort
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CampaignQueryService(
    private val queryCampaignsPort: QueryCampaignsPort
): GetCampaignsUseCase {

    override fun getCampaign(id: UUID): Campaign {
        return queryCampaignsPort.queryCampaign(id)
    }

    override fun getCampaigns(): List<Campaign> {
        return queryCampaignsPort.queryCampaigns()
    }

}