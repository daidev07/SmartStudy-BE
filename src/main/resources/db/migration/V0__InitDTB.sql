CREATE DATABASE IF NOT EXISTS smart_study;
USE smart_study;

CREATE TABLE classrooms
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    class_name     VARCHAR(255)          NULL,
    class_status   VARCHAR(255)          NULL,
    CONSTRAINT pk_classrooms PRIMARY KEY (id)
);

CREATE TABLE users
(
    id                    BIGINT AUTO_INCREMENT NOT NULL,
    name                  VARCHAR(255)          NULL,
    email                 VARCHAR(255)          NULL,
    avatar_file            VARCHAR(255)          NULL,
    phone                 VARCHAR(255)          NULL,
    username              VARCHAR(255)          NULL,
    password              VARCHAR(255)          NULL,
    classroom_id          BIGINT                NULL,
    dob                   date                  NULL,
    study_status          VARCHAR(255)          NULL,
    role                  VARCHAR(255)          NULL,
    created_at            datetime              NULL,
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

CREATE TABLE exams
(
    id                 BIGINT AUTO_INCREMENT NOT NULL,
    name               VARCHAR(255)          NULL,
    created_at         datetime              NULL,
    listen_file_id VARCHAR(255)          NULL,
    pdf_file_id    VARCHAR(255)          NULL,
    exam_type          VARCHAR(255)          NULL,
    CONSTRAINT pk_exams PRIMARY KEY (id)
);

ALTER TABLE exams
    ADD CONSTRAINT FK_EXAMS_ON_LISTENFILEURL FOREIGN KEY (listen_file_id) REFERENCES files (id);

ALTER TABLE exams
    ADD CONSTRAINT FK_EXAMS_ON_PDFFILEURL FOREIGN KEY (pdf_file_id) REFERENCES files (id);

CREATE TABLE expand_contents
(
    id      BIGINT AUTO_INCREMENT NOT NULL,
    content LONGTEXT          NULL,
    CONSTRAINT pk_expand_contents PRIMARY KEY (id)
);

CREATE TABLE questions
(
    id      BIGINT AUTO_INCREMENT NOT NULL,
    question_number   INT NULL,
    exam_id BIGINT                NULL,
    content VARCHAR(255)          NULL,
    expand_content_id BIGINT      NULL,
    CONSTRAINT pk_questions PRIMARY KEY (id)
);

ALTER TABLE questions
    ADD CONSTRAINT FK_QUESTIONS_ON_EXAM FOREIGN KEY (exam_id) REFERENCES exams (id);
ALTER TABLE questions
    ADD CONSTRAINT FK_QUESTIONS_ON_EXPANDCONTENT FOREIGN KEY (expand_content_id) REFERENCES expand_contents (id);

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

