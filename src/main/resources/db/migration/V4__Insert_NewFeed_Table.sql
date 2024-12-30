CREATE TABLE newsfeeds
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    content      MEDIUMTEXT          NULL,
    image_file    VARCHAR(255)          NULL,
    posted_at    datetime              NULL,
    user_id      BIGINT                NULL,
    classroom_id BIGINT                NULL,
    likes        BIGINT                NULL,
    CONSTRAINT pk_newsfeeds PRIMARY KEY (id)
);

ALTER TABLE newsfeeds
    ADD CONSTRAINT FK_NEWSFEEDS_ON_CLASSROOM FOREIGN KEY (classroom_id) REFERENCES classrooms (id);

ALTER TABLE newsfeeds
    ADD CONSTRAINT FK_NEWSFEEDS_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);