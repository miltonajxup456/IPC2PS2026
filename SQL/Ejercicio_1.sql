CREATE DATABASE Ejercicio_1;

CREATE TABLE Sucursal (
    codigo_sucursal INT AUTO_INCREMENT PRIMARY KEY,
    direccion VARCHAR(50),
    ciudad VARCHAR(20)
);

CREATE TABLE Empleado (
    numero_empleado INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30),
    cargo VARCHAR(20),
    salario DECIMAL(5,2),
    sucursal INT NOT NULL,
    FOREIGN KEY (sucursal) REFERENCES Sucursal(codigo_sucursal)
);

CREATE TABLE Editorial (
    id_editorial INT AUTO_INCREMENT PRIMARY KEY,
    nombre_editorial VARCHAR(50),
    pais_editorial VARCHAR(30),
    direccion_editorial VARCHAR(40),
    numero_telefono VARCHAR (15)
);

CREATE TABLE Autor (
    id_autor INT AUTO_INCREMENT PRIMARY KEY,
    nombre_autor VARCHAR(40),
    nacionalidad VARCHAR(30),
    fecha_nacimiento DATE
);

CREATE TABLE Libro (
    codigo_isbn VARCHAR(13) PRIMARY KEY,
    titulo VARCHAR(100),
    genero VARCHAR(40),
    precio DECIMAL(3,2),
    formato VARCHAR(15),
    numero_paginas INT, 
    cantidad_disponible INT,
    editorial INT NOT NULL,
    autor INT NOT NULL,
    FOREIGN KEY (editorial) REFERENCES Editorial(id_editorial),
    FOREIGN KEY (autor) REFERENCES Autor(id_autor)
);

CREATE TABLE Cliente (
    identificacion_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre_cliente VARCHAR(40),
    correo VARCHAR(50),
    direccion_cliente VARCHAR(40),
    tipo_cliente VARCHAR(20)
);

CREATE TABLE Pedido (
    id_pedido INT AUTO_INCREMENT PRIMARY KEY,
    fecha_compra DATE,
    estado_pedido VARCHAR(20),
    total_compra DECIMAL(5,2),
    empleado INT NOT NULL,
    cliente INT NOT NULL,
    FOREIGN KEY (empleado) REFERENCES Empleado(numero_empleado),
    FOREIGN KEY (cliente) REFERENCES Cliente(identificacion_cliente)
);

CREATE TABLE Libros_Pedido (
    id_pedido INT NOT NULL,
    codigo_libro VARCHAR(13),
    cantidad INT,
    FOREIGN KEY (id_pedido) REFERENCES Pedido(id_pedido),
    FOREIGN KEY (codigo_libro) REFERENCES Libro(codigo_isbn),
    PRIMARY KEY (id_pedido, codigo_libro)
);

CREATE TABLE Pago (
    numero_pago INT AUTO_INCREMENT PRIMARY KEY,
    metodo_pago VARCHAR(20),
    fecha_pago DATE,
    estado VARCHAR(20),
    id_pedido INT NOT NULL,
    FOREIGN KEY (id_pedido) REFERENCES Pedido(id_pedido)
);