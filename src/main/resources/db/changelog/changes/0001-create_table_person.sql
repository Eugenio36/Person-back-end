--liquibase formatted sql

--changeset jevgenijs:1

CREATE TABLE person(
    id SERIAL PRIMARY KEY,
    personal_id VARCHAR (255) NOT NULL,
    first_name VARCHAR (255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    gender VARCHAR (255) NOT NULL,
    date_of_birth DATE NOT NULL
)

--changeset jevgenijs:2

INSERT INTO person(
    PERSONAL_ID,
    FIRST_NAME,
    LAST_NAME,
    GENDER,
    DATE_OF_BIRTH
)
VALUES
    ('150497-11324', 'Konrad', 'Reeve', 'MALE', '1997-04-15'),
    ('250197-19607', 'Fabian', 'Williamson', 'MALE', '1997-01-25'),
    ('101167-18735', 'Connah', 'Evans', 'MALE', '1967-11-10'),
    ('210259-13491', 'Jun', 'Page', 'FEMALE', '1959-02-21'),
    ('301157-16891', 'Georgia', 'Nava', 'FEMALE', '1957-11-30'),
    ('071164-11816', 'Ceara', 'Burgess', 'FEMALE', '1964-11-07');