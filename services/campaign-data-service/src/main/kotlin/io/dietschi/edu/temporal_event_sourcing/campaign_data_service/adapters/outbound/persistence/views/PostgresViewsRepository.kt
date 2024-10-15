package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.outbound.persistence.views

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.time.LocalDateTime
import java.util.UUID

@Repository
interface PostgresViewsRepository: JpaRepository<ViewsEntity, Long> {

    @Query("SELECT new io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.outbound.persistence.views.ViewsAsOf(c.campaignId, c.lineItemId, SUM(c.completedViews)) FROM completed_views AS c " +
            "WHERE c.campaignId = :campaignId " +
            "AND c.viewingWindowEnd <= :asOfDate " +
            "GROUP BY c.campaignId, c.lineItemId")
    fun findByCampaignIdAndAsOfDate(campaignId: UUID, asOfDate: LocalDateTime): List<ViewsAsOf>
}