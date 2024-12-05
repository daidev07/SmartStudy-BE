CREATE TABLE newfeeds
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    content      MEDIUMTEXT          NULL,
    image_url    VARCHAR(255)          NULL,
    posted_at    datetime              NULL,
    user_id      BIGINT                NULL,
    classroom_id BIGINT                NULL,
    likes        BIGINT                NULL,
    CONSTRAINT pk_newfeeds PRIMARY KEY (id)
);

ALTER TABLE newfeeds
    ADD CONSTRAINT FK_NEWFEEDS_ON_CLASSROOM FOREIGN KEY (classroom_id) REFERENCES classrooms (id);

ALTER TABLE newfeeds
    ADD CONSTRAINT FK_NEWFEEDS_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);