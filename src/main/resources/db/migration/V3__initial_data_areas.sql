INSERT INTO areas (codigo, nombre)
VALUES
    (UNHEX(REPLACE(UUID(), '-', '')), 'Sistemas'),
    (UNHEX(REPLACE(UUID(), '-', '')), 'Contabilidad'),
    (UNHEX(REPLACE(UUID(), '-', '')), 'RRHH');