CREATE DATABASE IF NOT EXISTS smart_study;
USE smart_study;

CREATE TABLE levels
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255)          NULL,
    CONSTRAINT pk_levels PRIMARY KEY (id)
);

CREATE TABLE classrooms
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    name     VARCHAR(255)          NULL,
    level_id BIGINT                NULL,
    CONSTRAINT pk_classrooms PRIMARY KEY (id)
);

ALTER TABLE classrooms
    ADD CONSTRAINT FK_CLASSROOMS_ON_LEVEL FOREIGN KEY (level_id) REFERENCES levels (id);

CREATE TABLE users
(
    id                    BIGINT AUTO_INCREMENT NOT NULL,
    name                  VARCHAR(255)          NULL,
    email                 VARCHAR(255)          NULL,
    avatar_url            VARCHAR(255)          NULL,
    phone                 VARCHAR(255)          NULL,
    username              VARCHAR(255)          NULL,
    password              VARCHAR(255)          NULL,
    classroom_id          BIGINT                NULL,
    dob                   date                  NULL,
    study_status          TINYINT               NULL,
    created_at            datetime              NULL,
    updated_at            datetime              NULL,
    verification_code     VARCHAR(255)          NULL,
    reset_password_code   VARCHAR(255)          NULL,
    reset_password_expiry VARCHAR(255)          NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE users
    ADD CONSTRAINT uc_users_email UNIQUE (email);

ALTER TABLE users
    ADD CONSTRAINT uc_users_username UNIQUE (username);

ALTER TABLE users
    ADD CONSTRAINT FK_USERS_ON_CLASSROOM FOREIGN KEY (classroom_id) REFERENCES classrooms (id);

CREATE TABLE files
(
    id          VARCHAR(255) NOT NULL,
    file_name   VARCHAR(255) NULL,
    file_folder VARCHAR(255) NULL,
    file_url    VARCHAR(255) NULL,
    file_type   VARCHAR(255) NULL,
    cloud_id    VARCHAR(255) NULL,
    CONSTRAINT pk_fileinfo PRIMARY KEY (id)
);