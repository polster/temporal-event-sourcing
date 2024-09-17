package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.outbound.persistence

import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.outbound.persistence.campaign.PostgresCampaignRepository
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.outbound.persistence.views.PostgresViewsRepository
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.outbound.toDomain
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.model.Campaign
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.model.Views
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.port.outbound.QueryCampaignDataPort
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.common.exception.ResourceNotFoundException
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.UUID

@Component
class CampaignDataPersistenceAdapter(
    private val postgresCampaignRepository: PostgresCampaignRepository,
    private val postgresViewsRepository: PostgresViewsRepository
) : QueryCampaignDataPort {

    override fun queryCampaigns(): List<Campaign> =
        postgresCampaignRepository.findAll().map { it.toDomain() }

    override fun queryCampaign(id: UUID): Campaign =
        postgresCampaignRepository.findByCampaignId(id)?.toDomain()
            ?: throw ResourceNotFoundException(id)

    override fun queryViews(campaignId: UUID, asOfDate: LocalDateTime): List<Views> =
        postgresViewsRepository.findByCampaignIdAndAsOfDate(campaignId, asOfDate)
            .map { it.toDomain() }
}