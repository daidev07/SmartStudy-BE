INSERT INTO classrooms (id, class_name, class_status) VALUES (1, 'DN666', 'PROCESSING'), (2, 'DN8386', 'PROCESSING');

INSERT INTO users (id, name, email, phone, username, password, classroom_id, study_status, role)
            VALUES (1, 'Ho Xuan Dai', 'daihx@gmail.com', '0123456789', 'daihx', '$2y$10$TWW/K7uAAJybJiGL2Ik9fexfw21Z862/wqXxPnr32mcYm7EivQ49.', 1, 'IN_PROGRESS', 'STUDENT'),
                   (2, 'Dau Duc Toan', 'toandd@gmail.com', '0123456790', 'toandd', '$2y$10$TWW/K7uAAJybJiGL2Ik9fexfw21Z862/wqXxPnr32mcYm7EivQ49.', 1, 'IN_PROGRESS', 'STUDENT'),
                   (3, 'Le Thi Hang', 'hanglt@gmail.com', '0123456791', 'hanglt', '$2y$10$TWW/K7uAAJybJiGL2Ik9fexfw21Z862/wqXxPnr32mcYm7EivQ49.', 2, 'IN_PROGRESS', 'STUDENT'),
                   (4, 'Doan Tien Loi', 'loidt@gmail.com', '0123456792', 'loidt', '$2y$10$TWW/K7uAAJybJiGL2Ik9fexfw21Z862/wqXxPnr32mcYm7EivQ49.', 2, 'IN_PROGRESS', 'STUDENT'),
                   (5, 'Nguyen Tat Phu Cuong', 'cuongntp@gmail.com', '0123456793', 'cuongntp', '$2y$10$TWW/K7uAAJybJiGL2Ik9fexfw21Z862/wqXxPnr32mcYm7EivQ49.', null, null, 'ASSISTANT'),
                   (6, 'Nguyen Nang Hung Van', 'vannnh@gmail.com', '0123456794', 'vannnh', '$2y$10$TWW/K7uAAJybJiGL2Ik9fexfw21Z862/wqXxPnr32mcYm7EivQ49.', null, null, 'TEACHER');
