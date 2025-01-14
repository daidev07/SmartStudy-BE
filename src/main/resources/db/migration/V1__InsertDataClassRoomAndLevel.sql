INSERT INTO classrooms (id, class_name, class_status) VALUES (1, 'TOEIC-20', 'PROCESSING'), (2, 'TOEIC-22', 'PROCESSING');

INSERT INTO users (id, name, email, phone, username, password, classroom_id, study_status, role)
            VALUES (1, 'Nguyen Tat Phu Cuong', 'cuongntp@gmail.com', '0123456793', 'cuongntp', '$2y$10$TWW/K7uAAJybJiGL2Ik9fexfw21Z862/wqXxPnr32mcYm7EivQ49.', null, null, 'TEACHER'),
                   (2, 'Nguyen Nang Hung Van', 'vannnh@gmail.com', '0123456794', 'vannnh', '$2y$10$TWW/K7uAAJybJiGL2Ik9fexfw21Z862/wqXxPnr32mcYm7EivQ49.', null, null, 'ASSISTANT');
