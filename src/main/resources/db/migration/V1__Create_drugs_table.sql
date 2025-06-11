CREATE SCHEMA IF NOT EXISTS pharmacy;

CREATE TABLE pharmacy.drugs (
                                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                code VARCHAR(100),
                                name VARCHAR(255),
                                dose VARCHAR(100),
                                form VARCHAR(100),
                                manufacturer VARCHAR(255),
                                available_units INT,
                                price DOUBLE
);

insert into pharmacy.drugs values (6,'dd', 'gg', 'ww', '33', 'rgeg', 5, 8.0)