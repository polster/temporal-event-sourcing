package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.outbound.persistence.campaign

import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.outbound.persistence.campaign_with_views.CampaignWithCompletedViews
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.time.LocalDateTime
import java.util.UUID

@Repository
interface PostgresCampaignRepository: JpaRepository<CampaignEntity, Long> {
    fun findByCampaignId(campaignId: UUID): CampaignEntity?
}