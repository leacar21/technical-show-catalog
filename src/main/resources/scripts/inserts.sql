
-- USE `show`;

USE `heroku_6d56ee4795241ec`;

-- -------------------------------------------------------

INSERT INTO `show` (version, code, name, enabled) 
VALUES 
('0', UNHEX(replace(UUID(), '-', '')), "El Fantasma de la Opera", b'1'),
('0', UNHEX(replace(UUID(), '-', '')), "Romeo y Juliata", b'1'),
('0', UNHEX(replace(UUID(), '-', '')), "Hamlet", b'1');

-- -------------------------------------------------------

INSERT INTO auditorium_function_layout (version, code, name, auditorium_code) 
VALUES 
('0', UNHEX(replace(UUID(), '-', '')), "Layout 1", UNHEX("608DE0651F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), "Layout 2", UNHEX("608DE0931F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), "Layout 3", UNHEX("608E7E0B1F2611ECAE2118C04D3416FD"));


INSERT INTO function (version, code, `date`, enabled, show_id, auditorium_function_layout_id) 
VALUES 
('0', UNHEX(replace(UUID(), '-', '')), '2021-12-20 20:30:00', b'1', 1, 1),
('0', UNHEX(replace(UUID(), '-', '')), '2021-12-21 21:30:00', b'1', 1, 2),
('0', UNHEX(replace(UUID(), '-', '')), '2021-12-20 19:30:00', b'1', 2, 2),
('0', UNHEX(replace(UUID(), '-', '')), '2021-12-20 21:00:00', b'1', 3, 3);

INSERT INTO section (version, code, name, seat_price, auditorium_function_layout_id) 
VALUES 
('0', UNHEX(replace(UUID(), '-', '')), "Sección A", 2000.00, 1),
('0', UNHEX(replace(UUID(), '-', '')), "Sección B", 1500.00, 1),
('0', UNHEX(replace(UUID(), '-', '')), "Sección 1", 1000.00, 1),
('0', UNHEX(replace(UUID(), '-', '')), "Sección 2", 750.00, 2),
('0', UNHEX(replace(UUID(), '-', '')), "Sección 3", 500.00, 3),
('0', UNHEX(replace(UUID(), '-', '')), "General", 1200.00, 3);

-- -------------------------------------------------------

INSERT INTO section_seat (version, code, available, section_id, seat_code) 
VALUES 
('0', UNHEX(replace(UUID(), '-', '')), b'1', 1, UNHEX("608EBED11F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 1, UNHEX("608EBEFA1F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 1, UNHEX("608EBF061F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 1, UNHEX("608EBF0D1F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 2, UNHEX("608EBF161F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 2, UNHEX("608EBF1D1F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 2, UNHEX("608EBF2D1F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 2, UNHEX("608EBF3E1F2611ECAE2118C04D3416FD"));

INSERT INTO section_seat (version, code, available, section_id, seat_code) 
VALUES 
('0', UNHEX(replace(UUID(), '-', '')), b'1', 3, UNHEX("608F03941F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 3, UNHEX("608F03BB1F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 3, UNHEX("608F03C31F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 3, UNHEX("608F03CA1F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 3, UNHEX("608F03D21F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 3, UNHEX("608F03D81F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 4, UNHEX("608F03DF1F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 4, UNHEX("608F03E91F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 4, UNHEX("608F03F01F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 4, UNHEX("608F03FB1F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 4, UNHEX("608F040A1F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 4, UNHEX("608F040F1F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 5, UNHEX("608F04151F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 5, UNHEX("608F041A1F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 5, UNHEX("608F041F1F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 5, UNHEX("608F04241F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 5, UNHEX("608F04291F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 5, UNHEX("608F042F1F2611ECAE2118C04D3416FD"));

INSERT INTO section_seat (version, code, available, section_id, seat_code) 
VALUES 
('0', UNHEX(replace(UUID(), '-', '')), b'1', 6, UNHEX("609037531F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 6, UNHEX("6090377B1F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 6, UNHEX("609037841F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 6, UNHEX("6090378A1F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 6, UNHEX("6090378F1F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 6, UNHEX("609037951F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 6, UNHEX("6090379B1F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 6, UNHEX("609037A01F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 6, UNHEX("609037A51F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 6, UNHEX("609037AC1F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 6, UNHEX("609037B11F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 6, UNHEX("609037B71F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 6, UNHEX("609037BD1F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 6, UNHEX("609037C21F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 6, UNHEX("609037C71F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 6, UNHEX("609037CC1F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 6, UNHEX("609037D11F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 6, UNHEX("609037D71F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 6, UNHEX("609037DB1F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 6, UNHEX("609037E01F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 6, UNHEX("609037E51F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 6, UNHEX("609037F31F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 6, UNHEX("609037F81F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 6, UNHEX("609037FD1F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 6, UNHEX("609038031F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 6, UNHEX("609038081F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 6, UNHEX("6090380D1F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 6, UNHEX("609038121F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 6, UNHEX("609038171F2611ECAE2118C04D3416FD")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 6, UNHEX("6090381D1F2611ECAE2118C04D3416FD"));