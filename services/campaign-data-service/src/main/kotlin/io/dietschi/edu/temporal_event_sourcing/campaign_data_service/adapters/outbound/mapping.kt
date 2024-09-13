package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.outbound

import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.outbound.persistence.CampaignEntity
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.model.Campaign

fun CampaignEntity.toDomain(): Campaign {
    return Campaign(
        id = campaignId,
        name = name,
        startDate = startDate,
        endDate = endDate
    )
}