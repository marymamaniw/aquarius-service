CREATE TABLE IF NOT EXISTS empleados (
    codigo VARBINARY(36) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    codigo_area VARBINARY(36) NOT NULL,
    correo VARCHAR(100) UNIQUE NOT NULL,
    celular VARCHAR(9) UNIQUE NOT NULL,
    CONSTRAINT fk_empleado_area FOREIGN KEY (codigo_area)
        REFERENCES areas (codigo)
        ON DELETE CASCADE
        ON UPDATE CASCADE
) ENGINE=InnoDB;