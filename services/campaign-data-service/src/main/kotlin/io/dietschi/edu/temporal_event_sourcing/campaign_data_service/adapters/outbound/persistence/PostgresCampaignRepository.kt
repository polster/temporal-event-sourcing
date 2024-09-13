package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.outbound.persistence

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface PostgresCampaignRepository: JpaRepository<CampaignEntity, Long> {
    fun findByCampaignId(campaignId: UUID): CampaignEntity?
}