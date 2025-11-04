-- Crear la base de datos
CREATE DATABASE bikeshop;

-- Usar la base de datos
USE bikeshop;

-- Crear la tabla productos
CREATE TABLE productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    ruta_imagen VARCHAR(1024),
    descripcion VARCHAR(255)
);
ALTER TABLE productos
ADD COLUMN precio DECIMAL(10,2) NOT NULL DEFAULT 0.00;

INSERT INTO productos (nombre, ruta_imagen, descripcion, precio)
VALUES
('Bicicleta de Montaña Trek Marlin 7',
 'https://example.com/img/trek-marlin7.jpg',
 'Bicicleta de montaña con cuadro de aluminio y suspensión delantera RockShox.',
 650000.00),

('Casco Giro Fixture',
 'https://example.com/img/giro-fixture.jpg',
 'Casco versátil con sistema de ajuste Roc Loc Sport para mayor comodidad.',
 45000.00),

('Guantes Bontrager Circuit',
 'https://example.com/img/bontrager-circuit.jpg',
 'Guantes de ciclismo ligeros y transpirables, ideales para largas rutas.',
 25000.00),

('Luz Delantera Bontrager Ion 200',
 'https://example.com/img/bontrager-ion200.jpg',
 'Luz LED recargable por USB con potencia de 200 lúmenes.',
 30000.00),

('Bicicleta de Ruta Specialized Allez',
 'https://example.com/img/specialized-allez.jpg',
 'Bicicleta de ruta con cuadro de aluminio y grupo Shimano Claris.',
 720000.00);
s