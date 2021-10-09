
USE theaters;

-- -------------------------------------------------------

INSERT INTO theater (version, code, name, enabled) 
VALUES 
('0', UNHEX(replace(UUID(), '-', '')), "Metro", b'1'),
('0', UNHEX(replace(UUID(), '-', '')), "El Tinglado", b'1'),
('0', UNHEX(replace(UUID(), '-', '')), "Solis", b'1');

-- -------------------------------------------------------

INSERT INTO auditorium (version, code, name, theater_id) 
VALUES 
('0', UNHEX(replace(UUID(), '-', '')), "Sala 1", 1),
('0', UNHEX(replace(UUID(), '-', '')), "Sala 2", 1),
('0', UNHEX(replace(UUID(), '-', '')), "Sala 3", 1);

INSERT INTO auditorium (version, code, name, theater_id) 
VALUES 
('0', UNHEX(replace(UUID(), '-', '')), "Sala A", 2),
('0', UNHEX(replace(UUID(), '-', '')), "Sala B", 2);

INSERT INTO auditorium (version, code, name, theater_id) 
VALUES 
('0', UNHEX(replace(UUID(), '-', '')), "Auditorio General", 3);

-- -------------------------------------------------------

INSERT INTO seat (version, code, row, `column`, auditorium_id) 
VALUES 
('0', UNHEX(replace(UUID(), '-', '')), "A", "1", 1),
('0', UNHEX(replace(UUID(), '-', '')), "A", "2", 1),
('0', UNHEX(replace(UUID(), '-', '')), "A", "3", 1),
('0', UNHEX(replace(UUID(), '-', '')), "A", "4", 1),
('0', UNHEX(replace(UUID(), '-', '')), "B", "1", 1),
('0', UNHEX(replace(UUID(), '-', '')), "B", "2", 1),
('0', UNHEX(replace(UUID(), '-', '')), "B", "3", 1),
('0', UNHEX(replace(UUID(), '-', '')), "B", "4", 1);

INSERT INTO seat (version, code, row, `column`, auditorium_id) 
VALUES 
('0', UNHEX(replace(UUID(), '-', '')), "1", "1", 2),
('0', UNHEX(replace(UUID(), '-', '')), "1", "2", 2),
('0', UNHEX(replace(UUID(), '-', '')), "1", "3", 2),
('0', UNHEX(replace(UUID(), '-', '')), "1", "4", 2),
('0', UNHEX(replace(UUID(), '-', '')), "1", "5", 2),
('0', UNHEX(replace(UUID(), '-', '')), "1", "6", 2),
('0', UNHEX(replace(UUID(), '-', '')), "2", "1", 2),
('0', UNHEX(replace(UUID(), '-', '')), "2", "2", 2),
('0', UNHEX(replace(UUID(), '-', '')), "2", "3", 2),
('0', UNHEX(replace(UUID(), '-', '')), "2", "4", 2),
('0', UNHEX(replace(UUID(), '-', '')), "2", "5", 2),
('0', UNHEX(replace(UUID(), '-', '')), "2", "6", 2),
('0', UNHEX(replace(UUID(), '-', '')), "3", "1", 2),
('0', UNHEX(replace(UUID(), '-', '')), "3", "2", 2),
('0', UNHEX(replace(UUID(), '-', '')), "3", "3", 2),
('0', UNHEX(replace(UUID(), '-', '')), "3", "4", 2),
('0', UNHEX(replace(UUID(), '-', '')), "3", "5", 2),
('0', UNHEX(replace(UUID(), '-', '')), "3", "6", 2);

INSERT INTO seat (version, code, row, `column`, auditorium_id) 
VALUES 
('0', UNHEX(replace(UUID(), '-', '')), "1", "1", 3),
('0', UNHEX(replace(UUID(), '-', '')), "1", "2", 3),
('0', UNHEX(replace(UUID(), '-', '')), "1", "3", 3),
('0', UNHEX(replace(UUID(), '-', '')), "1", "4", 3),
('0', UNHEX(replace(UUID(), '-', '')), "1", "5", 3),
('0', UNHEX(replace(UUID(), '-', '')), "1", "6", 3),
('0', UNHEX(replace(UUID(), '-', '')), "2", "1", 3),
('0', UNHEX(replace(UUID(), '-', '')), "2", "2", 3),
('0', UNHEX(replace(UUID(), '-', '')), "2", "3", 3),
('0', UNHEX(replace(UUID(), '-', '')), "2", "4", 3),
('0', UNHEX(replace(UUID(), '-', '')), "2", "5", 3),
('0', UNHEX(replace(UUID(), '-', '')), "2", "6", 3),
('0', UNHEX(replace(UUID(), '-', '')), "3", "1", 3),
('0', UNHEX(replace(UUID(), '-', '')), "3", "2", 3),
('0', UNHEX(replace(UUID(), '-', '')), "3", "3", 3),
('0', UNHEX(replace(UUID(), '-', '')), "3", "4", 3),
('0', UNHEX(replace(UUID(), '-', '')), "3", "5", 3),
('0', UNHEX(replace(UUID(), '-', '')), "3", "6", 3);

-- ------

INSERT INTO seat (version, code, row, `column`, auditorium_id) 
VALUES 
('0', UNHEX(replace(UUID(), '-', '')), "1", "1", 4),
('0', UNHEX(replace(UUID(), '-', '')), "1", "2", 4),
('0', UNHEX(replace(UUID(), '-', '')), "1", "3", 4),
('0', UNHEX(replace(UUID(), '-', '')), "1", "4", 4),
('0', UNHEX(replace(UUID(), '-', '')), "1", "5", 4),
('0', UNHEX(replace(UUID(), '-', '')), "1", "6", 4),
('0', UNHEX(replace(UUID(), '-', '')), "1", "7", 4),
('0', UNHEX(replace(UUID(), '-', '')), "1", "8", 4),
('0', UNHEX(replace(UUID(), '-', '')), "2", "1", 4),
('0', UNHEX(replace(UUID(), '-', '')), "2", "2", 4),
('0', UNHEX(replace(UUID(), '-', '')), "2", "3", 4),
('0', UNHEX(replace(UUID(), '-', '')), "2", "4", 4),
('0', UNHEX(replace(UUID(), '-', '')), "2", "5", 4),
('0', UNHEX(replace(UUID(), '-', '')), "2", "6", 4),
('0', UNHEX(replace(UUID(), '-', '')), "2", "7", 4),
('0', UNHEX(replace(UUID(), '-', '')), "2", "8", 4),
('0', UNHEX(replace(UUID(), '-', '')), "3", "1", 4),
('0', UNHEX(replace(UUID(), '-', '')), "3", "2", 4),
('0', UNHEX(replace(UUID(), '-', '')), "3", "3", 4),
('0', UNHEX(replace(UUID(), '-', '')), "3", "4", 4),
('0', UNHEX(replace(UUID(), '-', '')), "3", "5", 4),
('0', UNHEX(replace(UUID(), '-', '')), "3", "6", 4),
('0', UNHEX(replace(UUID(), '-', '')), "3", "7", 4),
('0', UNHEX(replace(UUID(), '-', '')), "3", "8", 4);

-- ------

INSERT INTO seat (version, code, row, `column`, auditorium_id) 
VALUES 
('0', UNHEX(replace(UUID(), '-', '')), "1", "1", 5),
('0', UNHEX(replace(UUID(), '-', '')), "1", "2", 5),
('0', UNHEX(replace(UUID(), '-', '')), "1", "3", 5),
('0', UNHEX(replace(UUID(), '-', '')), "1", "4", 5),
('0', UNHEX(replace(UUID(), '-', '')), "1", "5", 5),
('0', UNHEX(replace(UUID(), '-', '')), "1", "6", 5),
('0', UNHEX(replace(UUID(), '-', '')), "1", "7", 5),
('0', UNHEX(replace(UUID(), '-', '')), "1", "8", 5),
('0', UNHEX(replace(UUID(), '-', '')), "2", "1", 5),
('0', UNHEX(replace(UUID(), '-', '')), "2", "2", 5),
('0', UNHEX(replace(UUID(), '-', '')), "2", "3", 5),
('0', UNHEX(replace(UUID(), '-', '')), "2", "4", 5),
('0', UNHEX(replace(UUID(), '-', '')), "2", "5", 5),
('0', UNHEX(replace(UUID(), '-', '')), "2", "6", 5),
('0', UNHEX(replace(UUID(), '-', '')), "2", "7", 5),
('0', UNHEX(replace(UUID(), '-', '')), "2", "8", 5),
('0', UNHEX(replace(UUID(), '-', '')), "3", "1", 5),
('0', UNHEX(replace(UUID(), '-', '')), "3", "2", 5),
('0', UNHEX(replace(UUID(), '-', '')), "3", "3", 5),
('0', UNHEX(replace(UUID(), '-', '')), "3", "4", 5),
('0', UNHEX(replace(UUID(), '-', '')), "3", "5", 5),
('0', UNHEX(replace(UUID(), '-', '')), "3", "6", 5),
('0', UNHEX(replace(UUID(), '-', '')), "3", "7", 5),
('0', UNHEX(replace(UUID(), '-', '')), "3", "8", 5);

-- -------------------------------------------------------

INSERT INTO seat (version, code, row, `column`, auditorium_id) 
VALUES 
('0', UNHEX(replace(UUID(), '-', '')), "1", "1", 6),
('0', UNHEX(replace(UUID(), '-', '')), "1", "2", 6),
('0', UNHEX(replace(UUID(), '-', '')), "1", "3", 6),
('0', UNHEX(replace(UUID(), '-', '')), "1", "4", 6),
('0', UNHEX(replace(UUID(), '-', '')), "1", "5", 6),
('0', UNHEX(replace(UUID(), '-', '')), "1", "6", 6),
('0', UNHEX(replace(UUID(), '-', '')), "1", "7", 6),
('0', UNHEX(replace(UUID(), '-', '')), "1", "8", 6),
('0', UNHEX(replace(UUID(), '-', '')), "1", "9", 6),
('0', UNHEX(replace(UUID(), '-', '')), "1", "10", 6),
('0', UNHEX(replace(UUID(), '-', '')), "2", "1", 6),
('0', UNHEX(replace(UUID(), '-', '')), "2", "2", 6),
('0', UNHEX(replace(UUID(), '-', '')), "2", "3", 6),
('0', UNHEX(replace(UUID(), '-', '')), "2", "4", 6),
('0', UNHEX(replace(UUID(), '-', '')), "2", "5", 6),
('0', UNHEX(replace(UUID(), '-', '')), "2", "6", 6),
('0', UNHEX(replace(UUID(), '-', '')), "2", "7", 6),
('0', UNHEX(replace(UUID(), '-', '')), "2", "8", 6),
('0', UNHEX(replace(UUID(), '-', '')), "2", "9", 6),
('0', UNHEX(replace(UUID(), '-', '')), "2", "10", 6),
('0', UNHEX(replace(UUID(), '-', '')), "3", "1", 6),
('0', UNHEX(replace(UUID(), '-', '')), "3", "2", 6),
('0', UNHEX(replace(UUID(), '-', '')), "3", "3", 6),
('0', UNHEX(replace(UUID(), '-', '')), "3", "4", 6),
('0', UNHEX(replace(UUID(), '-', '')), "3", "5", 6),
('0', UNHEX(replace(UUID(), '-', '')), "3", "6", 6),
('0', UNHEX(replace(UUID(), '-', '')), "3", "7", 6),
('0', UNHEX(replace(UUID(), '-', '')), "3", "8", 6),
('0', UNHEX(replace(UUID(), '-', '')), "3", "9", 6),
('0', UNHEX(replace(UUID(), '-', '')), "3", "10", 6);