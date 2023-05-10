-- Rename houseNumber column to house_number
ALTER TABLE medics
RENAME COLUMN houseNumber TO house_number;

-- Rename extraInfo column to extra_info
ALTER TABLE medics
RENAME COLUMN extraInfo TO extra_info;
