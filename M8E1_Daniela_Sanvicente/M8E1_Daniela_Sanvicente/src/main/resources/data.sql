INSERT INTO categoria (descripcion) VALUES ('Electrónica'), ('Ropa'), ('Libros'), ('Alimentos');

INSERT INTO producto (descripcion, precio, stock, id_categoria) VALUES 
('Laptop', 15000, 10, 1), ('Smartphone', 8000, 15, 1), ('Camiseta', 500, 20, 2), ('Jeans', 1200, 10, 2), 
('Novela', 300, 30, 3), ('Diccionario', 450, 5, 3), ('Pan', 50, 100, 4), ('Leche', 30, 50, 4), ('Tablet', 4000, 5, 1), 
('Audífonos', 1500, 10, 1);

INSERT INTO cliente (clave_cliente, nombre, paterno, fnac, curp, id_pais) VALUES 
(1, 'Ana', 'Martínez', '1992-08-15', 'MATA920815MDFRRN00', 1), (2, 'Luis', 'Hernández', '1985-03-22', 'HEGL850322HDFRNS00', 1), 
(3, 'María', 'López', '1990-12-30', 'LÓPM901230MDFLPZ00', 1), (4, 'Jorge', 'González', '1988-07-19', 'GÓJL880719HDFNNZ00', 1), 
(5, 'Claudia', 'Pérez', '1994-05-05', 'PÉCC940505MDFRRZ00', 2), (6, 'Roberto', 'Jiménez', '1983-11-11', 'JIRB831111HDFMMS00', 3), 
(7, 'Sofía', 'Moreno', '1996-02-20', 'MOSF960220MDFRNR00', 4), (8, 'Carlos', 'Navarro', '1989-09-09', 'NACR890909HDFNVL00', 5), 
(9, 'Fernando', 'Vega', '1992-04-17', 'VEGF920417HDFRGN02', 2), (10, 'Patricia', 'Soto', '1995-06-29', 'SOTP950629MDFSTN08', 3);

INSERT INTO pais VALUES (1, 'México', 'MX'), (2, 'Estados Unidos', 'US'), (3, 'Canadá', 'CA'), 
(4, 'Argentina', 'AR'), (5, 'Brasil', 'BR'), (6, 'Chile', 'CL'), (7, 'Perú', 'PE'), 
(8, 'Colombia', 'CO'), (9, 'España', 'ES');

INSERT INTO venta (clave_cliente, id_producto, fecha_venta, total_venta) VALUES 
(1, 5, '2023-02-01', 300.00), (2, 3, '2023-02-02', 450.00), (3, 2, '2023-02-03', 8000.00), (4, 1, '2023-02-04', 15000.00), 
(5, 4, '2023-02-05', 1200.00), (1, 6, '2023-02-06', 50.00), (2, 7, '2023-02-07', 30.00), (3, 8, '2023-02-08', 4000.00), 
(4, 9, '2023-02-09', 1500.00), (5, 10, '2023-02-10', 500.00), (6, 1, '2023-02-11', 15000.00), (7, 2, '2023-02-12', 8000.00), 
(8, 3, '2023-02-13', 450.00), (1, 4, '2023-02-14', 1200.00), (2, 5, '2023-02-15', 300.00), (3, 6, '2023-02-16', 50.00), 
(4, 7, '2023-02-17', 30.00), (5, 8, '2023-02-18', 4000.00), (6, 9, '2023-02-19', 1500.00), (7, 10, '2023-02-20', 500.00),
(9, 7, '2023-02-17', 50.00), (10, 3, '2023-02-18', 4500.00), (9, 9, '2023-02-20', 1600.00), (10, 10, '2023-02-20', 1500.00);
