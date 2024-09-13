package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.inbound.rest

import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.adapters.inbound.toDto
import io.dietschi.edu.temporal_event_sourcing.campaign_data_service.application.port.inbound.GetCampaignsUseCase
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
    private val getCampaignsUseCase: GetCampaignsUseCase
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
        @RequestParam(required = true) startDate: LocalDateTime,
        @RequestParam(required = true) endDate: LocalDateTime): ResponseEntity<List<CompletedView>> {

        throw NotImplementedError("Not implemented")
    }
}