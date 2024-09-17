package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.outbound.persistence.views

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.time.LocalDateTime
import java.util.UUID

@Repository
interface PostgresViewsRepository: JpaRepository<ViewsEntity, Long> {

    @Query("SELECT campaignId, SUM(completedViews) AS completedViews FROM completed_views " +
            "WHERE campaignId = :campaignId " +
            "AND viewingWindowEnd <= :asOfDate " +
            "GROUP BY campaignId")
    fun findByCampaignIdAndAsOfDate(campaignId: UUID, asOfDate: LocalDateTime): ViewsEntity?
}