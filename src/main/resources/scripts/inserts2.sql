
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
('0', UNHEX(replace(UUID(), '-', '')), "Layout 1", UNHEX("D471C2322FB111EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), "Layout 2", UNHEX("D471C28C2FB111EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), "Layout 3", UNHEX("D4BA5B0B2FB111EC9E1512F59F6291DF"));


INSERT INTO function (version, code, `date`, enabled, show_id, auditorium_function_layout_id) 
VALUES 
('0', UNHEX(replace(UUID(), '-', '')), '2021-12-20 20:30:00', b'1', 5, 5),
('0', UNHEX(replace(UUID(), '-', '')), '2021-12-21 21:30:00', b'1', 5, 15),
('0', UNHEX(replace(UUID(), '-', '')), '2021-12-20 19:30:00', b'1', 15, 15),
('0', UNHEX(replace(UUID(), '-', '')), '2021-12-20 21:00:00', b'1', 25, 25);

INSERT INTO section (version, code, name, seat_price, auditorium_function_layout_id) 
VALUES 
('0', UNHEX(replace(UUID(), '-', '')), "Sección A", 2000.00, 5),
('0', UNHEX(replace(UUID(), '-', '')), "Sección B", 1500.00, 5),
('0', UNHEX(replace(UUID(), '-', '')), "Sección 1", 1000.00, 15),
('0', UNHEX(replace(UUID(), '-', '')), "Sección 2", 750.00, 15),
('0', UNHEX(replace(UUID(), '-', '')), "Sección 3", 500.00, 15),
('0', UNHEX(replace(UUID(), '-', '')), "General", 1200.00, 25);

-- -------------------------------------------------------

INSERT INTO section_seat (version, code, available, section_id, seat_code) 
VALUES 
('0', UNHEX(replace(UUID(), '-', '')), b'1', 5, UNHEX("596F72152FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 5, UNHEX("596F72832FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 5, UNHEX("596F72912FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 5, UNHEX("596F729D2FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 15, UNHEX("596F72A52FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 15, UNHEX("596F72B22FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 15, UNHEX("596F72BC2FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 15, UNHEX("596F72C82FB211EC9E1512F59F6291DF"));

INSERT INTO section_seat (version, code, available, section_id, seat_code) 
VALUES 
('0', UNHEX(replace(UUID(), '-', '')), b'1', 25, UNHEX("59EAA55B2FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 25, UNHEX("59EAA5A62FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 25, UNHEX("59EAA5AF2FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 25, UNHEX("59EAA5B62FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 25, UNHEX("59EAA5BB2FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 25, UNHEX("59EAA5C22FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 35, UNHEX("59EAA5C92FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 35, UNHEX("59EAA5D02FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 35, UNHEX("59EAA5D62FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 35, UNHEX("59EAA5DD2FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 35, UNHEX("59EAA5E32FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 35, UNHEX("59EAA5E92FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 45, UNHEX("59EAA5EF2FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 45, UNHEX("59EAA5F42FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 45, UNHEX("59EAA5F92FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 45, UNHEX("59EAA6022FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 45, UNHEX("59EAA6092FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 45, UNHEX("59EAA6122FB211EC9E1512F59F6291DF"));

INSERT INTO section_seat (version, code, available, section_id, seat_code) 
VALUES 
('0', UNHEX(replace(UUID(), '-', '')), b'1', 55, UNHEX("67C982C92FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 55, UNHEX("67C9831E2FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 55, UNHEX("67C983282FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 55, UNHEX("67C983312FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 55, UNHEX("67C983392FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 55, UNHEX("67C983402FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 55, UNHEX("67C983472FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 55, UNHEX("67C9834E2FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 55, UNHEX("67C983572FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 55, UNHEX("67C9835E2FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 55, UNHEX("67C983672FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 55, UNHEX("67C983702FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 55, UNHEX("67C983772FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 55, UNHEX("67C9837E2FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 55, UNHEX("67C9838E2FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 55, UNHEX("67C983992FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 55, UNHEX("67C983A12FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 55, UNHEX("67C983A72FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 55, UNHEX("67C983AE2FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 55, UNHEX("67C983B42FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 55, UNHEX("67C983BA2FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 55, UNHEX("67C983C12FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 55, UNHEX("67C983C82FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 55, UNHEX("67C983CF2FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 55, UNHEX("67C983D52FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 55, UNHEX("67C983DE2FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 55, UNHEX("67C983E42FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 55, UNHEX("67C983F32FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 55, UNHEX("67C983FF2FB211EC9E1512F59F6291DF")),
('0', UNHEX(replace(UUID(), '-', '')), b'1', 55, UNHEX("67C984072FB211EC9E1512F59F6291DF"));