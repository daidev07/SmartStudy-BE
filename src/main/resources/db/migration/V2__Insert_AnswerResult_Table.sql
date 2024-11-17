CREATE TABLE answer_results
(
    id                    BIGINT AUTO_INCREMENT NOT NULL,
    student_assignment_id BIGINT                NULL,
    question_id           BIGINT                NULL,
    answer_id             BIGINT                NULL,
    user_id               BIGINT                NULL,
    CONSTRAINT pk_answer_results PRIMARY KEY (id)
);

ALTER TABLE answer_results
    ADD CONSTRAINT FK_ANSWER_RESULTS_ON_ANSWER FOREIGN KEY (answer_id) REFERENCES answers (id);

ALTER TABLE answer_results
    ADD CONSTRAINT FK_ANSWER_RESULTS_ON_QUESTION FOREIGN KEY (question_id) REFERENCES questions (id);

ALTER TABLE answer_results
    ADD CONSTRAINT FK_ANSWER_RESULTS_ON_STUDENTASSIGNMENT FOREIGN KEY (student_assignment_id) REFERENCES student_assignments (id);

ALTER TABLE answer_results
    ADD CONSTRAINT FK_ANSWER_RESULTS_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);