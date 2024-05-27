--liquibase formatted sql

--changeset shakov:1
ALTER TABLE users
    ADD COLUMN created_at TIMESTAMP;

--changeset shakov:2
ALTER TABLE users
    ADD COLUMN modified_at TIMESTAMP;

--changeset shakov:3
ALTER TABLE users
    ADD COLUMN created_by VARCHAR(32);

--changeset shakov:4
ALTER TABLE users
    ADD COLUMN modified_by VARCHAR(32);