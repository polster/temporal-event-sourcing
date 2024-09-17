package io.dietschi.edu.temporal_event_sourcing.campaign_events_processor.adapters.outbound.persistence.views

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostgresViewsRepository: JpaRepository<ViewsEntity, Long> {
}