package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.outbound.persistence.campaign

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.time.LocalDateTime
import java.util.UUID

@Entity(name = "campaigns")
class CampaignEntity(
    @Column(name = "campaign_id")
    var campaignId: UUID,
    var name: String,
    @Column(name = "start_date")
    var startDate: LocalDateTime,
    @Column(name = "end_date")
    var endDate: LocalDateTime,
    @Id @GeneratedValue
    var id: Long? = null
)