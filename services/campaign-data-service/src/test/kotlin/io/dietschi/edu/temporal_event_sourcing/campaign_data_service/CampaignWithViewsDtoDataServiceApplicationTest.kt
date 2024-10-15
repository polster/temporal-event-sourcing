package io.dietschi.edu.temporal_event_sourcing.campaign_data_service

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext

@SpringBootTest
class CampaignWithViewsDtoDataServiceApplicationTest(
    val applicationContext: ApplicationContext
) {

    @Test
    fun context_loads_successfully() {
        assertNotNull(applicationContext)
    }
}