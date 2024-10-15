package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.outbound.persistence

import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.outbound.persistence.campaign.PostgresCampaignRepository
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.outbound.persistence.campaign_with_views.CampaignWithCompletedViews
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.outbound.persistence.campaign_with_views.PostgresCampaignWithViewsRepository
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.outbound.persistence.views.PostgresViewsRepository
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.outbound.toDomain
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.model.Campaign
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.model.CampaignWithViews
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.model.Views
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.port.outbound.QueryCampaignDataPort
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.common.exception.ResourceNotFoundException
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.*

@Component
class CampaignDataPersistenceAdapter(
    private val postgresCampaignRepository: PostgresCampaignRepository,
    private val postgresViewsRepository: PostgresViewsRepository,
    private val postgresCampaignWithViewsRepository: PostgresCampaignWithViewsRepository
) : QueryCampaignDataPort {

    override fun queryCampaigns(): List<Campaign> =
        postgresCampaignRepository.findAll().map { it.toDomain() }

    override fun queryCampaignWithViews(id: UUID): CampaignWithViews =
        postgresCampaignWithViewsRepository.findByCampaignId(id)
            .let(::groupAndMap)
            .first()

    override fun queryCampaign(id: UUID): Campaign =
        postgresCampaignRepository.findByCampaignId(id)?.toDomain()
            ?: throw ResourceNotFoundException(id)

    override fun queryViews(campaignId: UUID, asOfDate: LocalDateTime): List<Views> =
        postgresViewsRepository.findByCampaignIdAndAsOfDate(campaignId, asOfDate)
            .map { it.toDomain() }

    override fun queryCampaignsWithViews(fromDate: LocalDateTime,
                                         toDate: LocalDateTime,
                                         asOfDateCompletedViews: LocalDateTime): List<CampaignWithViews> {

        return postgresCampaignWithViewsRepository
            .findByStartDateAndEndDateAndAsOfDateCompletedViews(fromDate, toDate, asOfDateCompletedViews)
            .let(::groupAndMap)
    }

    private fun groupAndMap(campaigns: List<CampaignWithCompletedViews>): (List<CampaignWithViews>) =
        campaigns
            .groupBy { it.campaignId }
            .map { (campaignId, campaigns) ->
                CampaignWithViews(campaignId, campaigns.first().name, campaigns.first().startDate, campaigns.first().endDate,
                    campaigns.map { Views(it.campaignId, it.lineItemId, it.completedViews) })
    }
}