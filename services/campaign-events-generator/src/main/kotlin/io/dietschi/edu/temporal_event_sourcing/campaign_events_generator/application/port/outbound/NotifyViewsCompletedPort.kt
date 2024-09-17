package io.dietschi.edu.temporal_event_sourcing.campaign_events_generator.application.port.outbound

import io.dietschi.edu.temporal_event_sourcing.campaign_events_generator.application.domain.model.Views

fun interface NotifyViewsCompletedPort {

        fun notifyViewsCompleted(views: Views)
}