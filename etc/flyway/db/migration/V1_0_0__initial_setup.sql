CREATE TABLE campaigns (
    id SERIAL PRIMARY KEY,
    campaign_id VARCHAR(255) NOT NULL UNIQUE,
    name VARCHAR(255) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL
);

CREATE TABLE completed_views (
    id SERIAL PRIMARY KEY,
    campaign_id INT NOT NULL REFERENCES campaigns(id),
    line_item_id INT NOT NULL,
    completed_views INT NOT NULL,
    viewing_period TSRANGE NOT NULL
);

CREATE USER campaign_data_service WITH PASSWORD '23a4b5c6d7e8f9g0';
GRANT SELECT ON ALL TABLES IN SCHEMA campaign_data TO campaign_data_service;