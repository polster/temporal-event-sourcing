package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.services

import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.model.Campaign
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.model.CampaignWithViews
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.model.Views
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.port.inbound.CampaignQuery
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.port.inbound.GetCampaignsUseCase
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.port.inbound.GetViewsUseCase
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.port.inbound.ViewsQuery
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.port.outbound.QueryCampaignDataPort
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CampaignDataQueryService(
    private val queryCampaignDataPort: QueryCampaignDataPort
): GetCampaignsUseCase, GetViewsUseCase {

    override fun getCampaignWithViews(id: UUID): CampaignWithViews =
        queryCampaignDataPort.queryCampaignWithViews(id)

    override fun getCampaign(id: UUID): Campaign =
        queryCampaignDataPort.queryCampaign(id)

    override fun getCampaigns(): List<Campaign> =
        queryCampaignDataPort.queryCampaigns()

    override fun getCampaignsWithViews(campaignQuery: CampaignQuery): List<CampaignWithViews> =
        queryCampaignDataPort.queryCampaignsWithViews(
            campaignQuery.fromDate,
            campaignQuery.toDate,
            campaignQuery.asOfDateCompletedViews
        )

    override fun getViews(viewsQuery: ViewsQuery): List<Views> =
        queryCampaignDataPort.queryViews(viewsQuery.campaignId, viewsQuery.asOfDate)

}