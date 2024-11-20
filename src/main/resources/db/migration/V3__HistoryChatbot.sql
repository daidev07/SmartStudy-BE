CREATE TABLE history_chatbots
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    user_id    BIGINT                NULL,
    title      VARCHAR(255)          NULL,
    created_at datetime              NULL,
    CONSTRAINT pk_history_chatbots PRIMARY KEY (id)
);

ALTER TABLE history_chatbots
    ADD CONSTRAINT FK_HISTORY_CHATBOTS_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

CREATE TABLE message_details
(
    id                 BIGINT AUTO_INCREMENT NOT NULL,
    history_chatbot_id BIGINT                NULL,
    message_user       MEDIUMTEXT            NULL,
    message_bot        MEDIUMTEXT            NULL,
    responded_at       datetime              NULL,
    CONSTRAINT pk_message_details PRIMARY KEY (id)
);

ALTER TABLE message_details
    ADD CONSTRAINT FK_MESSAGE_DETAILS_ON_HISTORYCHATBOT FOREIGN KEY (history_chatbot_id) REFERENCES history_chatbots (id);