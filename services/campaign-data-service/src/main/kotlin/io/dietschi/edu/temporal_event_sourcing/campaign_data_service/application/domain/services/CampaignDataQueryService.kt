package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.services

import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.model.Campaign
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.model.Views
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.port.inbound.GetCampaignsUseCase
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.port.inbound.GetViewsUseCase
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.port.inbound.Query
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.port.outbound.QueryCampaignDataPort
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CampaignDataQueryService(
    private val queryCampaignDataPort: QueryCampaignDataPort
): GetCampaignsUseCase, GetViewsUseCase {

    override fun getCampaign(id: UUID): Campaign =
        queryCampaignDataPort.queryCampaign(id)

    override fun getCampaigns(): List<Campaign> =
        queryCampaignDataPort.queryCampaigns()

    override fun getViews(query: Query): List<Views> =
        queryCampaignDataPort.queryViews(query.campaignId, query.asOfDate)

}