CREATE TABLE campaigns (
    id SERIAL PRIMARY KEY,
    campaign_id UUID NOT NULL UNIQUE,
    name VARCHAR(255) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL
);

CREATE TABLE completed_views (
    id SERIAL PRIMARY KEY,
    campaign_id UUID NOT NULL,
    line_item_id UUID NOT NULL,
    completed_views INT NOT NULL,
    viewing_window_start TIMESTAMP NOT NULL,
    viewing_window_end TIMESTAMP NOT NULL
);

CREATE USER campaign_data_service WITH PASSWORD '23a4b5c6d7e8f9g0';
CREATE USER campaign_events_processor WITH PASSWORD '23a489c6d7e8f9av';
GRANT SELECT ON ALL TABLES IN SCHEMA campaign_data TO campaign_data_service;
GRANT SELECT, INSERT, UPDATE ON ALL TABLES IN SCHEMA campaign_data TO campaign_events_processor;
GRANT USAGE,SELECT ON ALL SEQUENCES IN SCHEMA campaign_data TO campaign_events_processor;
GRANT USAGE ON SCHEMA campaign_data TO campaign_events_processor;
GRANT USAGE ON SCHEMA campaign_data TO campaign_data_service;