package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.inbound.graphql

import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.model.filter.CampaignFilter
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.model.filter.ViewsFilter
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.port.inbound.CampaignQuery
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.port.inbound.GetCampaignsUseCase
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import java.time.LocalDateTime

@Controller
class CampaignQueryController(
    private val getCampaignsUseCase: GetCampaignsUseCase
) {

    @QueryMapping
    fun campaignById(@Argument id: String): CampaignDto {
        return CampaignDto(
            id = id,
            name = "Campaign",
            startDate = LocalDateTime.now(),
            endDate = LocalDateTime.now(),
            views = emptyList()
        )
    }

    @QueryMapping
    fun campaigns(@Argument campaignFilter: CampaignFilter,
                  @Argument viewsFilter: ViewsFilter
    ): List<CampaignDto> {
        val query = CampaignQuery(
            fromDate = campaignFilter.fromDate,
            toDate = campaignFilter.toDate,
            asOfDateCompletedViews = viewsFilter.asOfDate
        )
        return getCampaignsUseCase.getCampaignsWithViews(query).map { it.toDto() }
    }
}