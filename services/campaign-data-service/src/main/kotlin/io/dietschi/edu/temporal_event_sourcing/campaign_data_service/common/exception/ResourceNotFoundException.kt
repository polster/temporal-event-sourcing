package io.dietschi.edu.temporal_event_sourcing.campaign_data_service.common.exception

import java.util.UUID

class ResourceNotFoundException(id: UUID?) :
    RuntimeException(String.format("Resource with id %s not found", id))