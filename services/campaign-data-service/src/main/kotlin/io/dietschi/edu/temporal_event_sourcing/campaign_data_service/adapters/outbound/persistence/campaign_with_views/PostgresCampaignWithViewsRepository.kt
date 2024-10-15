package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.outbound.persistence.campaign_with_views

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface PostgresCampaignWithViewsRepository : JpaRepository<CampaignWithCompletedViews, CompositeId> {

    @Query("SELECT c FROM campaigns_with_completed_views AS c " +
            "WHERE c.viewingWindowEnd <= :asOfDateCompletedViews " +
            "AND c.startDate >= :startDate " +
            "AND c.endDate <= :endDate " +
            "ORDER BY c.campaignId, c.startDate, c.viewingWindowStart asc")
    fun findByStartDateAndEndDateAndAsOfDateCompletedViews(
        startDate: LocalDateTime,
        endDate: LocalDateTime,
        asOfDateCompletedViews: LocalDateTime
    ): List<CampaignWithCompletedViews>
}