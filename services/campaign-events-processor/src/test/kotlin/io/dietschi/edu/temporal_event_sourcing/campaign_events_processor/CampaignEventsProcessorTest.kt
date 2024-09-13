package io.dietschi.edu.temporal_event_sourcing.campaign_events_processor

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import kotlin.test.assertNotNull

@SpringBootTest
class CampaignEventsProcessorTest(
    val applicationContext: ApplicationContext
) {

    @Test
    fun context_loads_successfully() {
        assertNotNull(applicationContext)
    }
}