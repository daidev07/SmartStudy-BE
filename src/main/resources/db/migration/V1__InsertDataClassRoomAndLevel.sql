INSERT INTO levels (id, name) VALUES (1, '1'), (2, '2'), (3, '3');

INSERT INTO classrooms (id, name, level_id) VALUES (1, 'KN234', 1), (2, 'KN246', 2);

INSERT INTO users (id, name, email, phone, username, password, classroom_id, study_status)
            VALUES (1, 'Ho Xuan Dai', 'daihx@gmail.com', '0123456789', 'daihx', '$2y$10$TWW/K7uAAJybJiGL2Ik9fexfw21Z862/wqXxPnr32mcYm7EivQ49.', 1, 'IN_PROGRESS'),
                   (2, 'Dau Duc Toan', 'toandd@gmail.com', '0123456790', 'toandd', '$2y$10$TWW/K7uAAJybJiGL2Ik9fexfw21Z862/wqXxPnr32mcYm7EivQ49.', 1, 'IN_PROGRESS'),
                   (3, 'Le Thi Hang', 'hanglt@gmail.com', '0123456791', 'hanglt', '$2y$10$TWW/K7uAAJybJiGL2Ik9fexfw21Z862/wqXxPnr32mcYm7EivQ49.', 2, 'IN_PROGRESS'),
                   (4, 'Doan Tien Loi', 'loidt@gmail.com', '0123456792', 'loidt', '$2y$10$TWW/K7uAAJybJiGL2Ik9fexfw21Z862/wqXxPnr32mcYm7EivQ49.', 2, 'IN_PROGRESS'),
                   (5, 'Nguyen Tat Phu Cuong', 'cuongntp@gmail.com', '0123456793', 'cuongntp', '$2y$10$TWW/K7uAAJybJiGL2Ik9fexfw21Z862/wqXxPnr32mcYm7EivQ49.', null, null),
                   (6, 'Nguyen Nang Hung Van', 'vannnh@gmail.com', '0123456794', 'vannnh', '$2y$10$TWW/K7uAAJybJiGL2Ik9fexfw21Z862/wqXxPnr32mcYm7EivQ49.', null, null);

INSERT INTO roles (id, name) VALUES (1, 'USER'), (2, 'ASSISTANT'), (3, 'TEACHER');

INSERT INTO user_roles (id, user_id, role_id) VALUES (1, 1, 1), (2, 2, 1), (3, 3, 1), (4, 4, 1), (5, 5, 2), (6, 6, 3);
