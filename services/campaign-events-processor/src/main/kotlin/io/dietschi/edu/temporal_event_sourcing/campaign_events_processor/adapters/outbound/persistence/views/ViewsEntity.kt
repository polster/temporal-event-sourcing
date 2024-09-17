package io.dietschi.edu.temporal_event_sourcing.campaign_events_processor.adapters.outbound.persistence.views

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.UUID

@Entity(name = "completed_views")
class ViewsEntity(
    @Column(name = "campaign_id")
    var campaignId: UUID,
    @Column(name = "line_item_id")
    var lineItemId: UUID,
    @Column(name = "completed_views")
    var completedViews: Int,
    @Column(name = "viewing_window_start", columnDefinition = "TIMESTAMP")
    var viewingWindowStart: LocalDateTime,
    @Column(name = "viewing_window_end", columnDefinition = "TIMESTAMP")
    var viewingWindowEnd: LocalDateTime,
    @Id
    @SequenceGenerator(name = "completed_views_seq", sequenceName = "completed_views_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "completed_views_seq")
    var id: Long? = null
)
