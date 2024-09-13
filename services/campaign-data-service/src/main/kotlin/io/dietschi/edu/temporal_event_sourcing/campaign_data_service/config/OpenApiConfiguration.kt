package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.config

import io.swagger.v3.oas.models.OpenAPI
import org.springframework.boot.info.BuildProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfiguration {

    @Bean
    fun openApi(buildProperties: BuildProperties): OpenAPI =
        OpenAPI()
            .info(
                io.swagger.v3.oas.models.info.Info()
                    .title(buildProperties.name)
                    .description(buildProperties["description"])
                    .version(buildProperties.version)
            )
}