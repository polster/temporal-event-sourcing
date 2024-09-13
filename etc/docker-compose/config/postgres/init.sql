-- Create DB and initial migration user
CREATE USER flyway WITH PASSWORD '23a4b5c6d7e8f9g0';
CREATE DATABASE temporal_event_sourcing;

GRANT ALL PRIVILEGES ON DATABASE temporal_event_sourcing TO flyway;