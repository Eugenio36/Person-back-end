--liquibase formatted sql

--changeset jevgenijs:3

CREATE TABLE audit_log(
        id INT PRIMARY KEY,
        action VARCHAR (255) NOT NULL,
        log_time TIMESTAMP NOT NULL
)