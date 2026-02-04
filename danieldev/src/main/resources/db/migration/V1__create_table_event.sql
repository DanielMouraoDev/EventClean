-- V1_create_table_event.sql

     CREATE TABLE tb_event (
         id BIGSERIAL PRIMARY KEY,
         name VARCHAR(255) NOT NULL,
         description TEXT,
         identifier VARCHAR(255) UNIQUE NOT NULL,
         local_event VARCHAR(255),
         manager VARCHAR(255),
         data_start TIMESTAMP WITHOUT TIME ZONE NOT NULL,
         data_end TIMESTAMP WITHOUT TIME ZONE NOT NULL,
         capacity INTEGER NOT NULL,
         type VARCHAR(50) NOT NULL

);
