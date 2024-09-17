package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.inbound.rest

import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.inbound.toDto
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.port.inbound.GetCampaignsUseCase
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.port.inbound.GetViewsUseCase
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.port.inbound.Query
import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import java.util.UUID

@RestController
@RequestMapping("/ext/v1/campaigns")
class CampaignDataController(
    private val getCampaignsUseCase: GetCampaignsUseCase,
    private val getViewsUseCase: GetViewsUseCase
) {

    @GetMapping("/")
    fun queryCampaigns(): ResponseEntity<List<CampaignDto>> {

        return ResponseEntity.ok(getCampaignsUseCase.getCampaigns().map { it.toDto() })
    }

    @GetMapping("/{id}")
    fun queryCampaign(@PathVariable id: UUID): ResponseEntity<CampaignDto> {

        return ResponseEntity.ok(getCampaignsUseCase.getCampaign(id).toDto())
    }

    @GetMapping("/{id}/completed-views")
    fun queryCompletedViews(
        @PathVariable id: UUID,
        @Schema(example = "2024-09-28T01:30:00.000") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @RequestParam(required = true) asOfDate: LocalDateTime): ResponseEntity<List<ViewsDto>> {

        val query = Query(campaignId = id, asOfDate = asOfDate)
        return ResponseEntity.ok(getViewsUseCase.getViews(query).map { it.toDto() })
    }
}