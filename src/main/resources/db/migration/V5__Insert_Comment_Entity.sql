CREATE TABLE comments
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    content       VARCHAR(255)          NULL,
    user_id       BIGINT                NULL,
    news_feed_id  BIGINT                NULL,
    comment_likes BIGINT                NULL,
    created_at    datetime              NULL,
    updated_at    datetime              NULL,
    CONSTRAINT pk_comments PRIMARY KEY (id)
);

ALTER TABLE comments
    ADD CONSTRAINT FK_COMMENTS_ON_NEWSFEED FOREIGN KEY (news_feed_id) REFERENCES newsfeeds (id);

ALTER TABLE comments
    ADD CONSTRAINT FK_COMMENTS_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);