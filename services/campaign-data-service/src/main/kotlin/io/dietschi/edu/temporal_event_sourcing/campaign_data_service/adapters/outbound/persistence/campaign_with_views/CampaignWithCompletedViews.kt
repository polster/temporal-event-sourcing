package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.outbound.persistence.campaign_with_views

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@Entity(name = "campaigns_with_completed_views")
@IdClass(CompositeId::class)
class CampaignWithCompletedViews(

    @Column(name = "campaign_id")
    val campaignId: UUID,
    @Id
    @Column(name = "line_item_id")
    val lineItemId: UUID,
    val name: String,
    @Column(name = "start_date")
    val startDate: LocalDateTime,
    @Column(name = "end_date")
    val endDate: LocalDateTime,
    @Column(name = "completed_views")
    val completedViews: Long,
    @Id
    @Column(name = "viewing_window_start")
    val viewingWindowStart: LocalDateTime,
    @Id
    @Column(name = "viewing_window_end")
    val viewingWindowEnd: LocalDateTime
)