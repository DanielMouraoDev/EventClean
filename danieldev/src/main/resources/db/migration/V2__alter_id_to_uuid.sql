-- V2__alter_id_to_uuid.sql

-- 1. Removemos a restrição de Chave Primária atual
ALTER TABLE tb_event DROP CONSTRAINT tb_event_pkey;

-- 2. Alteramos o tipo da coluna 'id' para VARCHAR(36)
-- Usamos 'USING id::varchar' para converter os números existentes (1, 2, 3) em texto ("1", "2", "3")
ALTER TABLE tb_event ALTER COLUMN id TYPE VARCHAR(36) USING id::varchar;

-- 3. Adicionamos a Chave Primária de volta
ALTER TABLE tb_event ADD PRIMARY KEY (id);

-- 4. Removemos a sequência automática (o BIGSERIAL anterior),
-- já que agora o seu Core gera o ID manualmente
DROP SEQUENCE IF EXISTS tb_event_id_seq CASCADE;