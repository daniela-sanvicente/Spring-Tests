INSERT INTO cliente (nombre, apellidos, correo, telefono_casa, whatsapp, direccion, tipo, contrasena)
VALUES
    ('María', 'Gómez', 'maria@example.com', '1234567890', '1234567890', 'Calle Principal 123', 'clienteFinal', 'contrasena123'),
    ('Pedro', 'Martínez', 'pedro@example.com', '0987654321', '0987654321', 'Avenida Central 456', 'revendedor', 'contrasena456'),
    ('Juan', 'González', 'juan@example.com', '1122334455', '1122334455', 'Calle Secundaria 789', 'clienteFinal', 'contrasena789'),
    ('Ana', 'Hernández', 'ana@example.com', '5544332211', '5544332211', 'Calle Transversal 1011', 'revendedor', 'contrasena1011'),
    ('Carlos', 'López', 'carlos@example.com', '6677889900', '6677889900', 'Avenida Principal 1213', 'clienteFinal', 'contrasena1213');

INSERT INTO metodo_pago (metodo)
VALUES
    ('Tarjeta de crédito'),
    ('Transferencia bancaria'),
    ('Cheque'),
    ('Efectivo'),
    ('Pago móvil');

INSERT INTO pago (id_cliente, id_metodo_pago, emisor, numero_cuenta, fecha_expiracion, cvv)
VALUES
    (1, 1, 'VISA', '1234567890123456', '03/26', '123'),
    (2, 1, 'MASTERCARD', '9876543210987654', '06/27', '456'),
    (3, 1, 'MASTERCARD', '6543210987654321', '09/28', '789'),
    (4, 1, 'MASTERCARD', '0123456789012345', '12/29', '987'),
    (5, 1, 'VISA', '5432109876543210', '03/30', '654');

INSERT INTO orden (id_cliente, id_pago, tipo_orden, estatus, direccion_entrega, anticipo, momento_pedido, momento_entrega, descuento, precio_total)
VALUES
    (1, 1, 'mayoreo', 'realizado', 'Calle de la Amistad 789', 50.00, '2024-03-25 10:00:00', NULL, 0.00, 150.00),
    (2, 2, 'menudeo', 'entregado', 'Avenida Principal 321', 0.00, '2024-03-24 15:00:00', '2024-03-26 14:00:00', 10.00, 90.00),
    (3, 3, 'mayoreo', 'realizado', 'Avenida de la Paz 567', 75.00, '2024-03-26 09:00:00', NULL, 5.00, 120.00),
    (4, 4, 'mixto', 'entregado', 'Calle de la Libertad 901', 0.00, '2024-03-27 12:00:00', '2024-03-28 11:00:00', 15.00, 85.00),
    (5, 5, 'mayoreo', 'realizado', 'Boulevard de las Flores 1234', 100.00, '2024-03-28 08:00:00', NULL, 20.00, 180.00);

INSERT INTO dulces (nombre_dulce, precio, tema, tipo, stock, imagen, tiempo_elaboracion)
VALUES
    ('Paleta de Chocolate', 5.50, 'N/A', 'Chocolate', 100, 'paleta_chocolate.jpg', '2 horas'),
    ('Paleta de Amaranto', 8.50, 'N/A', 'Chocolate', 100, 'paleta_amaranto.jpg', '3 horas'),
    ('Paleta de Navidad', 12.50, 'Navidad', 'Chocolate', 100, 'paleta_navidad.jpg', '3 horas'),
    ('Bombones', 15.25, 'N/A', 'Bombón', 80, 'bombones.jpg', '3 horas'),
    ('Bombones de Café', 20.50, 'N/A', 'Bombón', 80, 'bombones_café.jpg', '3 horas'),
    ('Bombones de Navidad', 40.25, 'Navidad', 'Bombón', 80, 'bombones_navidad.jpg', '3 horas'),
    ('Bombones de Boda', 50.20, 'Boda', 'Bombón', 80, 'bombones_boda.jpg', '5 horas'),
    ('Enjambre', 25.20, 'N/A', 'Chocolate', 80, 'enjambre.jpg', '5 horas'),
    ('Brocheta de Gomita', 8.50, 'N/A', 'Gomita', 120, 'brocheta_gomita.jpg', '4 horas'),
    ('Brocheta de Gomita de Navidad', 10.50, 'Navidad', 'Gomita', 120, 'brocheta_gomita_nav.jpg', '4 horas'),
    ('Brocheta de Gomita de Boda', 12.50, 'Boda', 'Gomita', 120, 'brocheta_gomita_boda.jpg', '4 horas'),
    ('Gomita Suelta', 8.50, 'N/A', 'Gomita', 120, 'gomita_suelta.jpg', '4 horas');

INSERT INTO arreglos (nombre_arreglo, precio, tema, tipo, stock, imagen, tiempo_elaboracion, descripcion)
VALUES
    ('Arreglo de Paletas', 60.50, 'N/A', 'Chocolate', 50, 'arreglo_paletas.jpg', '3 horas', 'Arreglo de paletas de chocolate surtidas.'),
    ('Arreglo de Brochetas de Gomita', 75.00, 'N/A', 'Gomita', 30, 'arreglo_brochetas.jpg', '5 horas', 'Arreglo de brochetas de gomita.'),
    ('Arreglo de Bombones', 100.75, 'N/A', 'Bombón', 40, 'arreglo_bombones.jpg', '4 horas', 'Arreglo de bombones surtidos.'),
    ('Arreglo Mixto', 90.75, 'N/A', 'Mixto', 40, 'arreglo_mixto.jpg', '4 horas', 'Arreglo de dulces mixtos.');

INSERT INTO arreglo_dulces (id_arreglo, id_dulce) 
    VALUES 
        (1, 1), 
        (1, 2), 
        (1, 3), 
        (2, 9), 
        (2, 10), 
        (2, 11), 
        (3, 4), 
        (3, 5), 
        (3, 6), 
        (3, 7), 
        (4, 1), 
        (4, 4), 
        (4, 9);
