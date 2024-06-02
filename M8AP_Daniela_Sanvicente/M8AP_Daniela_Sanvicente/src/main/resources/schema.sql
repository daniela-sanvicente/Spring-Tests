ALTER TABLE IF EXISTS arreglo_dulces
DROP FOREIGN KEY IF EXISTS fk_id_arreglo_ad,
DROP FOREIGN KEY IF EXISTS fk_id_dulce_ad;

DROP TABLE IF EXISTS arreglo_dulces;

ALTER TABLE IF EXISTS mesa_dulces
DROP FOREIGN KEY IF EXISTS fk_id_mesa_md,
DROP FOREIGN KEY IF EXISTS fk_id_dulce_md;

DROP TABLE IF EXISTS mesa_dulces;

ALTER TABLE IF EXISTS mesa_arreglos
DROP FOREIGN KEY IF EXISTS fk_id_mesa_ma,
DROP FOREIGN KEY IF EXISTS fk_id_arreglo_ma;

DROP TABLE IF EXISTS mesa_arreglos;

ALTER TABLE IF EXISTS carrito
DROP FOREIGN KEY IF EXISTS fk_carrito_cliente_crto;

ALTER TABLE IF EXISTS item_carrito
DROP FOREIGN KEY IF EXISTS fk_carrito_itm_crto,
DROP FOREIGN KEY IF EXISTS fk_carrito_dulce_itm_crto,
DROP FOREIGN KEY IF EXISTS fk_carrito_arreglo_itm_crto,
DROP FOREIGN KEY IF EXISTS fk_carrito_mesa_itm_crto;

ALTER TABLE IF EXISTS pago
DROP FOREIGN KEY IF EXISTS fk_pago_cliente_pgo,
DROP FOREIGN KEY IF EXISTS fk_pago_metodo_pago_pgo;

ALTER TABLE IF EXISTS orden
DROP FOREIGN KEY IF EXISTS fk_orden_cliente_ord,
DROP FOREIGN KEY IF EXISTS fk_orden_pago_ord;

ALTER TABLE IF EXISTS linea_orden
DROP FOREIGN KEY IF EXISTS fk_orden_ln_ord,
DROP FOREIGN KEY IF EXISTS fk_linea_orden_dulce_ln_ord,
DROP FOREIGN KEY IF EXISTS fk_linea_orden_arreglo_ln_ord,
DROP FOREIGN KEY IF EXISTS fk_linea_orden_mesa_ln_ord;

DROP TABLE IF EXISTS dulces;
CREATE TABLE dulces (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nombre_dulce VARCHAR (50) NOT NULL UNIQUE DEFAULT "N/A",
	precio DECIMAL(5, 2) NOT NULL DEFAULT 000.00 CHECK(precio >= 0.0),
	tema VARCHAR (100) NOT NULL DEFAULT "N/A" CHECK(LENGTH(tema) >= 1),
	tipo VARCHAR (50) NOT NULL DEFAULT "N/A" CHECK(LENGTH(tipo) >= 1),
	stock INT NOT NULL DEFAULT 0 CHECK(stock >= 0),
	imagen VARCHAR(200) CHECK(LENGTH(imagen) >= 10),
	tiempo_elaboracion VARCHAR (100) NOT NULL DEFAULT "N/A" CHECK(LENGTH(tiempo_elaboracion) >= 1)
);

DROP TABLE IF EXISTS arreglos;
CREATE TABLE arreglos (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nombre_arreglo VARCHAR (50) NOT NULL UNIQUE DEFAULT "N/A",
	precio DECIMAL(5, 2) NOT NULL DEFAULT 000.00 CHECK(precio >= 0.0),
	tema VARCHAR (100) NOT NULL DEFAULT "N/A" CHECK(LENGTH(tema) >= 1),
	tipo VARCHAR (50) NOT NULL DEFAULT "N/A" CHECK(LENGTH(tipo) >= 1),
	stock INT NOT NULL DEFAULT 0 CHECK(stock >= 0),
	imagen VARCHAR(200) CHECK(LENGTH(imagen) >= 10),
	tiempo_elaboracion VARCHAR (100) NOT NULL DEFAULT "N/A" CHECK(LENGTH(tiempo_elaboracion) >= 1),
	descripcion VARCHAR (300) NOT NULL DEFAULT "N/A" CHECK(LENGTH(descripcion) >= 1)
);

DROP TABLE IF EXISTS arreglo_dulces;
CREATE TABLE arreglo_dulces (
	id_arreglo INT NOT NULL,
	id_dulce INT NOT NULL,

	CONSTRAINT PRIMARY KEY (id_arreglo, id_dulce),
	CONSTRAINT fk_id_arreglo_ad FOREIGN KEY (id_arreglo) REFERENCES arreglos (id) ON DELETE CASCADE,
	CONSTRAINT fk_id_dulce_ad FOREIGN KEY (id_dulce) REFERENCES dulces (id) ON DELETE CASCADE
);

DROP TABLE IF EXISTS mesas;
CREATE TABLE mesas (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nombre_mesa VARCHAR (50) NOT NULL UNIQUE DEFAULT "N/A",
	precio DECIMAL(5, 2) NOT NULL DEFAULT 000.00 CHECK(precio >= 0.0),
	tema VARCHAR (100) NOT NULL DEFAULT "N/A" CHECK(LENGTH(tema) >= 1),
	tipo VARCHAR (50) NOT NULL DEFAULT "N/A" CHECK(LENGTH(tipo) >= 1),
	imagen VARCHAR(200) CHECK(LENGTH(imagen) >= 10),
	cotizacion VARCHAR (250) NOT NULL DEFAULT "N/A" CHECK(LENGTH(cotizacion) >= 1),
	tiempo_elaboracion VARCHAR (100) NOT NULL DEFAULT "N/A" CHECK(LENGTH(tiempo_elaboracion) >= 1),
	descripcion VARCHAR (300) NOT NULL DEFAULT "N/A" CHECK(LENGTH(descripcion) >= 1)
);

DROP TABLE IF EXISTS mesa_dulces;
CREATE TABLE mesa_dulces (
	id_mesa INT NOT NULL,
	id_dulce INT NOT NULL,

	CONSTRAINT PRIMARY KEY (id_mesa, id_dulce),
	CONSTRAINT fk_id_mesa_md FOREIGN KEY (id_mesa) REFERENCES mesas (id) ON DELETE CASCADE,
	CONSTRAINT fk_id_dulce_md FOREIGN KEY (id_dulce) REFERENCES dulces (id) ON DELETE CASCADE
);

DROP TABLE IF EXISTS mesa_arreglos;
CREATE TABLE mesa_arreglos (
	id_mesa INT NOT NULL,
	id_arreglo INT NOT NULL,

	CONSTRAINT PRIMARY KEY (id_mesa, id_arreglo),
	CONSTRAINT fk_id_mesa_ma FOREIGN KEY (id_mesa) REFERENCES mesas (id) ON DELETE CASCADE,
	CONSTRAINT fk_id_arreglo_ma FOREIGN KEY (id_arreglo) REFERENCES arreglos (id) ON DELETE CASCADE
);

DROP TABLE IF EXISTS cliente;
CREATE TABLE cliente (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR (30) NOT NULL CHECK(LENGTH(nombre) >= 1),
	apellidos VARCHAR (80) NOT NULL CHECK(LENGTH(apellidos) >= 1),
	correo VARCHAR (80) NOT NULL UNIQUE DEFAULT "N/A" CHECK(LENGTH(correo) >= 1),
	telefono_casa VARCHAR (20) NOT NULL DEFAULT "N/A" CHECK(LENGTH(telefono_casa) >= 10),
	whatsapp VARCHAR (20) NOT NULL DEFAULT "N/A" CHECK(LENGTH(whatsapp) >= 10),
	direccion VARCHAR (200) NOT NULL DEFAULT "N/A" CHECK(LENGTH(direccion) >= 10),
	tipo VARCHAR (50) NOT NULL DEFAULT "N/A" CHECK(LENGTH(tipo) >= 1),
	contrasena VARCHAR (30) NOT NULL DEFAULT "N/A" CHECK(LENGTH(contrasena) >= 6)
);

DROP TABLE IF EXISTS carrito;
CREATE TABLE carrito (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	id_cliente INT NOT NULL,

	CONSTRAINT fk_carrito_cliente_crto FOREIGN KEY (id_cliente) REFERENCES cliente (id) ON DELETE CASCADE
);

DROP TABLE IF EXISTS item_carrito;
CREATE TABLE item_carrito (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	id_carrito INT NOT NULL,
	id_dulce INT NOT NULL,
	id_arreglo INT NOT NULL,
	id_mesa INT NOT NULL,
	cantidad INT NOT NULL DEFAULT 0 CHECK(cantidad >= 0),

	CONSTRAINT fk_carrito_itm_crto FOREIGN KEY (id_carrito) REFERENCES carrito (id) ON DELETE CASCADE,
	CONSTRAINT fk_carrito_dulce_itm_crto FOREIGN KEY (id_dulce) REFERENCES dulces (id) ON DELETE CASCADE,
	CONSTRAINT fk_carrito_arreglo_itm_crto FOREIGN KEY (id_arreglo) REFERENCES arreglos (id) ON DELETE CASCADE,
	CONSTRAINT fk_carrito_mesa_itm_crto FOREIGN KEY (id_mesa) REFERENCES mesas (id) ON DELETE CASCADE
);

DROP TABLE IF EXISTS metodo_pago;
CREATE TABLE metodo_pago (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	metodo VARCHAR(50) NOT NULL UNIQUE DEFAULT "N/A" CHECK(LENGTH(metodo) >= 1)
);

DROP TABLE IF EXISTS pago;
CREATE TABLE pago (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	id_cliente INT NOT NULL,
	id_metodo_pago INT NOT NULL,
	emisor VARCHAR (50) NOT NULL DEFAULT "N/A" CHECK(LENGTH(emisor) >= 1),
	numero_cuenta VARCHAR (20) NOT NULL DEFAULT "N/A" CHECK(LENGTH(numero_cuenta) >= 16),
	fecha_expiracion VARCHAR (10) NOT NULL DEFAULT "N/A" CHECK(LENGTH(fecha_expiracion) >= 5),
	cvv CHAR (3) NOT NULL DEFAULT "N/A" CHECK(LENGTH(cvv) = 3),

	CONSTRAINT fk_pago_cliente_pgo FOREIGN KEY (id_cliente) REFERENCES cliente (id) ON DELETE CASCADE,
	CONSTRAINT fk_pago_metodo_pago_pgo FOREIGN KEY (id_metodo_pago) REFERENCES metodo_pago (id) ON DELETE CASCADE
);

DROP TABLE IF EXISTS orden;
CREATE TABLE orden (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	id_cliente INT NOT NULL,
	id_pago INT NOT NULL,
	tipo_orden VARCHAR (50) NOT NULL DEFAULT "N/A" CHECK(LENGTH(tipo_orden) >= 1),
	estatus VARCHAR (50) NOT NULL DEFAULT "N/A" CHECK(LENGTH(estatus) >= 1),
	direccion_entrega VARCHAR (200) NOT NULL DEFAULT "N/A" CHECK(LENGTH(direccion_entrega) >= 1),
	anticipo DECIMAL(5, 2) DEFAULT 000.00 CHECK(anticipo >= 0.0),
	momento_pedido DATETIME NOT NULL DEFAULT NOW(),
	momento_entrega DATETIME UNIQUE,
	descuento DECIMAL(5, 2) NOT NULL DEFAULT 000.00 CHECK(descuento >= 0.0),
	precio_total DECIMAL(6, 2) NOT NULL DEFAULT 0000.00 CHECK(precio_total >= 0.0),

	CONSTRAINT fk_orden_cliente_ord FOREIGN KEY (id_cliente) REFERENCES cliente (id) ON DELETE CASCADE,
	CONSTRAINT fk_orden_pago_ord FOREIGN KEY (id_pago) REFERENCES pago (id) ON DELETE CASCADE
);

DROP TABLE IF EXISTS linea_orden;
CREATE TABLE linea_orden (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	id_orden INT NOT NULL,
	id_dulce INT NOT NULL,
	id_arreglo INT NOT NULL,
	id_mesa INT NOT NULL,
	cantidad INT NOT NULL DEFAULT 0 CHECK(cantidad >= 0),
	precio DECIMAL(6, 2) NOT NULL DEFAULT 0000.00 CHECK(precio >= 0.0),

	CONSTRAINT fk_orden_ln_ord FOREIGN KEY (id_orden) REFERENCES orden (id) ON DELETE CASCADE,
	CONSTRAINT fk_linea_orden_dulce_ln_ord FOREIGN KEY (id_dulce) REFERENCES dulces (id) ON DELETE CASCADE,
	CONSTRAINT fk_linea_orden_arreglo_ln_ord FOREIGN KEY (id_arreglo) REFERENCES arreglos (id) ON DELETE CASCADE,
	CONSTRAINT fk_linea_orden_mesa_ln_ord FOREIGN KEY (id_mesa) REFERENCES mesas (id) ON DELETE CASCADE
);
