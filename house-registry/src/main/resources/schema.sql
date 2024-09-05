DROP TABLE IF EXISTS Person CASCADE;
DROP TABLE IF EXISTS House CASCADE;
DROP TYPE IF EXISTS property_type CASCADE;

CREATE TYPE property_type AS ENUM (
    'ENEBOLIG',
    'REKKEHUS',
    'TOMANNSBOLIG',
    'LEILIGHET',
    'HYTTE'
);

CREATE TABLE IF NOT EXISTS House (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    address TEXT NOT NULL UNIQUE,
    type property_type
);

CREATE TABLE IF NOT EXISTS Person (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name TEXT NOT NULL,
    age INT,
    gender TEXT NOT NULL,
    email TEXT NOT NULL UNIQUE,
    house_id BIGINT,
    FOREIGN KEY (house_id) REFERENCES House(id)
);

INSERT INTO House (address, type) VALUES
('Tore Hals Mejdells vei 12, 0751 OSLO', 'LEILIGHET'),
('Røaveien 71, 0751 OSLO', 'ENEBOLIG');

INSERT INTO Person (name, age, gender, email, house_id) VALUES
('John Doe', 34, 'Male', 'john.doe@example.com', 1),
('Jane Smith', 29, 'Female', 'jane.smith@example.com', 1),
('Michael Brown', 45, 'Male', 'michael.brown@example.com', 2),
('Emily Davis', 22, 'Female', 'emily.davis@example.com', 1),
('William Johnson', 38, 'Male', 'william.johnson@example.com', 2),
('Sophia Wilson', 30, 'Female', 'sophia.wilson@example.com', 1),
('James Martinez', 27, 'Male', 'james.martinez@example.com', 1),
('Isabella Garcia', 33, 'Female', 'isabella.garcia@example.com', 2),
('Lucas Lee', 40, 'Male', 'lucas.lee@example.com', 2),
('Mia Anderson', 25, 'Female', 'mia.anderson@example.com', 1);