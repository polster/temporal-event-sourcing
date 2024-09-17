package io.dietschi.edu.temporal_event_sourcing.campaign_events_generator.application.domain.services

import io.dietschi.edu.temporal_event_sourcing.campaign_events_generator.application.domain.model.Campaign
import io.dietschi.edu.temporal_event_sourcing.campaign_events_generator.application.domain.model.Views
import io.dietschi.edu.temporal_event_sourcing.campaign_events_generator.application.port.inbound.GenerateCampaignDataUseCase
import io.dietschi.edu.temporal_event_sourcing.campaign_events_generator.application.port.outbound.NotifyCampaignCreatedPort
import io.dietschi.edu.temporal_event_sourcing.campaign_events_generator.application.port.outbound.NotifyViewsCompletedPort
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import java.util.*

@Service
class CampaignDataGeneratorService(
    private val notifyCampaignCreatedPort: NotifyCampaignCreatedPort,
    private val notifyViewsCompletedPort: NotifyViewsCompletedPort
): GenerateCampaignDataUseCase {

    override fun generateCampaignData() {

        for (i in 1..10) {
            val startDate = LocalDate.now().plusDays(i*5L)
            val campaign = Campaign(
                id = UUID.randomUUID(),
                name = "Campaign $i",
                startDate = startDate,
                endDate = startDate.plusDays(7)
            )
            notifyCampaignCreatedPort.notifyCampaignCreated(campaign)
            log.debug("Campaign created: {}", campaign)

            val views = generateViews(campaign)
            views.forEach {
                notifyViewsCompletedPort.notifyViewsCompleted(it)
                log.debug("Views completed: {}", it)
            }
        }
    }

    private fun generateViews(campaign: Campaign): List<Views> {
        val views = mutableListOf<Views>()
        val totalDays = ChronoUnit.DAYS.between(campaign.startDate, campaign.endDate)
        for (i in 0..totalDays) {
            val startOfDay = campaign.startDate.plusDays(i).atStartOfDay()
            val endOfDay = startOfDay.plusHours(23).plusMinutes(59).plusSeconds(59)
            val viewingWindow = Views.ViewingWindow(
                startDate = startOfDay,
                endDate = endOfDay
            )
            val view = Views(
                campaignId = campaign.id,
                lineItemId = UUID.randomUUID(),
                completedViews = Random().nextInt(90000),
                viewingWindow = viewingWindow
            )
            views.add(view)
        }
        return views

    }

    companion object {
        private val log = LoggerFactory.getLogger(CampaignDataGeneratorService::class.java)
    }
}