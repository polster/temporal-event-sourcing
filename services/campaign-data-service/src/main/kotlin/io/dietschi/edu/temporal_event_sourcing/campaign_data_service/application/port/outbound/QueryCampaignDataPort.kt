package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.port.outbound

import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.model.Campaign
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.model.CampaignWithViews
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.model.Views
import java.time.LocalDateTime
import java.util.*

interface QueryCampaignDataPort {

    fun queryCampaigns(): List<Campaign>

    fun queryCampaign(id: UUID): Campaign

    fun queryViews(campaignId: UUID, asOfDate: LocalDateTime): List<Views>

    fun queryCampaignsWithViews(
        fromDate: LocalDateTime,
        toDate: LocalDateTime,
        asOfDateCompletedViews: LocalDateTime
    ): List<CampaignWithViews>
}