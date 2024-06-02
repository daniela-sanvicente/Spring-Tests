ALTER TABLE IF EXISTS venta_producto
DROP FOREIGN KEY IF EXISTS fk_venta_vp;

ALTER TABLE IF EXISTS venta_producto
DROP FOREIGN KEY IF EXISTS fk_producto_vp;

DROP TABLE IF EXISTS venta_producto;

DROP TABLE IF EXISTS producto;
CREATE TABLE producto (
    id INT(11) NOT NULL AUTO_INCREMENT,
    descripcion VARCHAR(40) NOT NULL,
    precio INT(11) NOT NULL,
    stock INT(11) NOT NULL,
    id_categoria INT(11) NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS categoria;
CREATE TABLE categoria (
    id_categoria INT(11) NOT NULL AUTO_INCREMENT,
    descripcion VARCHAR(255) NOT NULL,
    PRIMARY KEY (id_categoria)
);


DROP TABLE IF EXISTS cliente;
create table cliente (
	clave_cliente int NOT NULL AUTO_INCREMENT,
	nombre varchar(25),
    paterno varchar(25),
    fnac date, curp varchar(18),
    id_pais int NULL,
    PRIMARY KEY (clave_cliente));

DROP TABLES IF EXISTS pais;
CREATE TABLE pais (
  id_pais int NOT NULL AUTO_INCREMENT,
  pais varchar(50) DEFAULT NULL,
  codigo_iso varchar(5) DEFAULT NULL,
  PRIMARY KEY (id_pais),
  UNIQUE KEY pais_UNIQUE (pais),
  UNIQUE KEY codigo_iso_UNIQUE (codigo_iso)
);

DROP TABLE IF EXISTS venta;
CREATE TABLE venta (
    id_venta INT(11) NOT NULL AUTO_INCREMENT,
    clave_cliente INT(11) NOT NULL,
    id_producto INT(11) NOT NULL,
    fecha_venta DATE NOT NULL,
    total_venta DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (id_venta)
);

CREATE TABLE IF NOT EXISTS venta_producto (
    id_venta INT,
    id_producto INT,
    PRIMARY KEY (id_venta, id_producto),
    CONSTRAINT fk_venta_vp FOREIGN KEY (id_venta) REFERENCES venta(id_venta),
    CONSTRAINT fk_producto_vp FOREIGN KEY (id_producto) REFERENCES producto(id)
);

