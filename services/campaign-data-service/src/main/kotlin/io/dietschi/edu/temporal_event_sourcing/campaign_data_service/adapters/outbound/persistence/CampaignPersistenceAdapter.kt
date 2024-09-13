package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.outbound.persistence

import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.outbound.toDomain
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.model.Campaign
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.port.outbound.QueryCampaignsPort
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.common.exception.ResourceNotFoundException
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class CampaignPersistenceAdapter(
    private val postgresCampaignRepository: PostgresCampaignRepository
) : QueryCampaignsPort {

    override fun queryCampaigns(): List<Campaign> {
        return postgresCampaignRepository.findAll().map { it.toDomain() }
    }

    override fun queryCampaign(id: UUID): Campaign {
        return postgresCampaignRepository.findByCampaignId(id)?.toDomain()
            ?: throw ResourceNotFoundException(id)
    }
}