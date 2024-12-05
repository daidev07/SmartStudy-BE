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
    study_status          VARCHAR(255)          NULL,
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

CREATE TABLE roles
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255)          NULL,
    CONSTRAINT pk_roles PRIMARY KEY (id)
);
CREATE TABLE user_roles
(
    id      BIGINT AUTO_INCREMENT NOT NULL,
    user_id BIGINT                NULL,
    role_id BIGINT                NULL,
    CONSTRAINT pk_user_roles PRIMARY KEY (id)
);

ALTER TABLE user_roles
    ADD CONSTRAINT FK_USER_ROLES_ON_ROLE FOREIGN KEY (role_id) REFERENCES roles (id);

ALTER TABLE user_roles
    ADD CONSTRAINT FK_USER_ROLES_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

CREATE TABLE exams
(
    id                 BIGINT AUTO_INCREMENT NOT NULL,
    name               VARCHAR(255)          NULL,
    created_at         date                  NULL,
    listen_file_url_id VARCHAR(255)          NULL,
    pdf_file_url_id    VARCHAR(255)          NULL,
    exam_type          VARCHAR(255)          NULL,
    CONSTRAINT pk_exams PRIMARY KEY (id)
);

ALTER TABLE exams
    ADD CONSTRAINT FK_EXAMS_ON_LISTENFILEURL FOREIGN KEY (listen_file_url_id) REFERENCES files (id);

ALTER TABLE exams
    ADD CONSTRAINT FK_EXAMS_ON_PDFFILEURL FOREIGN KEY (pdf_file_url_id) REFERENCES files (id);

CREATE TABLE questions
(
    id      BIGINT AUTO_INCREMENT NOT NULL,
    exam_id BIGINT                NULL,
    content VARCHAR(255)          NULL,
    CONSTRAINT pk_questions PRIMARY KEY (id)
);

ALTER TABLE questions
    ADD CONSTRAINT FK_QUESTIONS_ON_EXAM FOREIGN KEY (exam_id) REFERENCES exams (id);

CREATE TABLE answers
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    question_id BIGINT                NULL,
    content     VARCHAR(255)          NULL,
    is_correct  BIT(1)                NULL,
    CONSTRAINT pk_answers PRIMARY KEY (id)
);

ALTER TABLE answers
    ADD CONSTRAINT FK_ANSWERS_ON_QUESTION FOREIGN KEY (question_id) REFERENCES questions (id);

CREATE TABLE classroom_assignments
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    name          VARCHAR(255)          NULL,
    exam_id       BIGINT                NULL,
    classroom_id  BIGINT                NULL,
    `description` VARCHAR(255)          NULL,
    assigned_at    datetime              NULL,
    due_date      datetime              NULL,
    CONSTRAINT pk_classroom_assignments PRIMARY KEY (id)
);

ALTER TABLE classroom_assignments
    ADD CONSTRAINT FK_CLASSROOM_ASSIGNMENTS_ON_CLASSROOM FOREIGN KEY (classroom_id) REFERENCES classrooms (id);

ALTER TABLE classroom_assignments
    ADD CONSTRAINT FK_CLASSROOM_ASSIGNMENTS_ON_EXAM FOREIGN KEY (exam_id) REFERENCES exams (id);

CREATE TABLE student_assignments
(
    id                BIGINT AUTO_INCREMENT NOT NULL,
    name              VARCHAR(255)          NULL,
    exam_id           BIGINT                NULL,
    user_id           BIGINT                NULL,
    `description`     VARCHAR(255)          NULL,
    assigned_at        datetime              NULL,
    due_date          datetime              NULL,
    submitted_at      datetime              NULL,
    point             BIGINT                NULL,
    assignment_status VARCHAR(255)          NULL,
    CONSTRAINT pk_student_assignments PRIMARY KEY (id)
);

ALTER TABLE student_assignments
    ADD CONSTRAINT FK_STUDENT_ASSIGNMENTS_ON_EXAM FOREIGN KEY (exam_id) REFERENCES exams (id);

ALTER TABLE student_assignments
    ADD CONSTRAINT FK_STUDENT_ASSIGNMENTS_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

