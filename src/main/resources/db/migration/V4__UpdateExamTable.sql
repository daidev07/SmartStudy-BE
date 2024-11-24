ALTER TABLE exams
    ADD COLUMN listen_file_url_id VARCHAR(255) NULL,
    ADD COLUMN pdf_file_url_id VARCHAR(255) NULL;

ALTER TABLE exams
    ADD CONSTRAINT FK_EXAMS_ON_LISTENFILEURL
        FOREIGN KEY (listen_file_url_id) REFERENCES files (id);

ALTER TABLE exams
    ADD CONSTRAINT FK_EXAMS_ON_PDFFILEURL
        FOREIGN KEY (pdf_file_url_id) REFERENCES files (id);
