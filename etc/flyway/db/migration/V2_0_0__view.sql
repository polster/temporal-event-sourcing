CREATE VIEW campaigns_with_completed_views AS
    SELECT c.name, c.campaign_id, c.start_date, c.end_date, cv.line_item_id, cv.viewing_window_start, cv.viewing_window_end, cv.completed_views
    FROM campaign_data.completed_views cv JOIN campaign_data.campaigns c ON cv.campaign_id = c.campaign_id
    ORDER BY c.campaign_id, c.start_date, cv.viewing_window_start ASC;