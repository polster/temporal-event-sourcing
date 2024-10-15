package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.inbound.graphql

import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.model.filter.CampaignFilter
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.domain.model.filter.ViewsFilter
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.port.inbound.CampaignQuery
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.port.inbound.GetCampaignsUseCase
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import java.time.LocalDateTime
import java.util.UUID

@Controller
class CampaignQueryController(
    private val getCampaignsUseCase: GetCampaignsUseCase
) {

    @QueryMapping
    fun campaignById(@Argument id: UUID): CampaignWithViewsDto =
        getCampaignsUseCase.getCampaignWithViews(id).toDto()

    @QueryMapping
    fun campaignsAndViews(@Argument campaignFilter: CampaignFilter,
                  @Argument viewsFilter: ViewsFilter
    ): List<CampaignWithViewsDto> {
        val query = CampaignQuery(
            fromDate = campaignFilter.fromDate,
            toDate = campaignFilter.toDate,
            asOfDateCompletedViews = viewsFilter.asOfDate
        )
        return getCampaignsUseCase.getCampaignsWithViews(query).map { it.toDto() }
    }

    @QueryMapping
    fun campaigns(): List<CampaignDto> =
        getCampaignsUseCase.getCampaigns().map { it.toDto() }
}