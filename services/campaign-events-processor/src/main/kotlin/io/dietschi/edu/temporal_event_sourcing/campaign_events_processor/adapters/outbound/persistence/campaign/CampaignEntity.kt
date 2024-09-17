package io.dietschi.edu.temporal_event_sourcing.campaign_events_processor.adapters.outbound.persistence.campaign

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@Entity(name = "campaigns")
class CampaignEntity(
    @Column(name = "campaign_id")
    var campaignId: UUID,
    var name: String,
    @Column(name = "start_date")
    var startDate: LocalDateTime,
    @Column(name = "end_date")
    var endDate: LocalDateTime,
    @Id
    @SequenceGenerator(name = "campaigns_seq", sequenceName = "campaigns_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "campaigns_seq")
    var id: Long? = null
)