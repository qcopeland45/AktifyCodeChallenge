CREATE TABLE IF NOT EXISTS campaign
(
    id             UUID NOT NULL,
    name           TEXT NOT NULL,
    description    TEXT NOT NULL,
    active         TEXT DEFAULT NULL, -- this type is debatable since its being stored as an ENUM in the code-- base

    CONSTRAINT campaign_pk PRIMARY KEY (id),
    CONSTRAINT campaign_name_description_uk UNIQUE (name, description) -- this is debatable. To me it made
    --sense to have a combination of uniqueness for name & description. E.G:
    -- Two campaigns have the same name (which seems like it could be a common thing) but the description is likely not the same
    -- enforcing a combination of those two columns to contain unique values seems reasonable

);

COMMENT ON TABLE campaign IS 'Table for storing user campaign data';
COMMENT ON COLUMN campaign.name IS 'Name of campaign';
COMMENT ON COLUMN campaign.description IS 'The user description of the campaign';
COMMENT ON COLUMN campaign.active IS 'Whether the campaign is active or not';

