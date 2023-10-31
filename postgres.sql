-- Adminer 4.8.1 PostgreSQL 16.0 (Debian 16.0-1.pgdg120+1) dump

\connect "postgres";

CREATE SEQUENCE "Categoria_id_seq" INCREMENT  MINVALUE  MAXVALUE  CACHE ;

CREATE TABLE "public"."categoria" (
    "id" character(1) DEFAULT 'nextval(''"Categoria_id_seq"'')' NOT NULL,
    "nome" character(80) NOT NULL,
    "descricao" character(127) NOT NULL,
    CONSTRAINT "Categoria_pkey" PRIMARY KEY ("id")
) WITH (oids = false);


CREATE TABLE "public"."cliente" (
    "nome" character(80) NOT NULL,
    "email" character(50) NOT NULL,
    "cpf" character(11) NOT NULL,
    CONSTRAINT "cliente_cpf" PRIMARY KEY ("cpf")
) WITH (oids = false);


CREATE SEQUENCE historico_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1;

CREATE TABLE "public"."historico" (
    "id" integer DEFAULT nextval('historico_id_seq') NOT NULL,
    "id_pedido" character(36) NOT NULL,
    "id_status" character(5) NOT NULL,
    "data_hora" timestamp NOT NULL,
    CONSTRAINT "historico_pkey" PRIMARY KEY ("id")
) WITH (oids = false);


CREATE TABLE "public"."itens_pedido" (
    "id" character(36) NOT NULL,
    "produto" character(36) NOT NULL,
    "pedido" character(36) NOT NULL,
    CONSTRAINT "itens_pedido_pkey" PRIMARY KEY ("id")
) WITH (oids = false);


CREATE TABLE "public"."pagamento" (
    "id" character(1) NOT NULL,
    "nome" character(50) NOT NULL,
    CONSTRAINT "pagamento_pkey" PRIMARY KEY ("id")
) WITH (oids = false);


CREATE SEQUENCE pedido_senha_seq INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1;

CREATE TABLE "public"."pedido" (
    "id" character(36) NOT NULL,
    "senha" character(10) DEFAULT 'nextval(''pedido_senha_seq'')',
    "id_status" character(1) NOT NULL,
    "cpf" character(11),
    "detalhes" character(255),
    "valor_total" money NOT NULL,
    "data_hora_inicio" timestamp NOT NULL,
    "data_hora_fim" timestamp,
    "id_pagamento" character(1),
    "id_satisfacao" character(1),
    CONSTRAINT "pedido_pkey" PRIMARY KEY ("id")
) WITH (oids = false);


CREATE TABLE "public"."produtos" (
    "id" uuid NOT NULL,
    "nome" character(80) NOT NULL,
    "descricao" character(127),
    "id_categoria" character(36) NOT NULL,
    "url_imagem" character(300),
    "preco" money NOT NULL
) WITH (oids = false);

INSERT INTO "produtos" ("id", "nome", "descricao", "id_categoria", "url_imagem", "preco") VALUES
('07bc64c4-fc32-4d93-a569-65162b070575',	'Hamburguer                                                                      ',	NULL,	'1                                   ',	NULL,	'$15.00'),
('48de37ee-a8aa-4455-baca-bc4a87205a5a',	'Hamburguer                                                                      ',	NULL,	'1                                   ',	NULL,	'$15.00'),
('6123911a-167d-4951-ad30-90c6830e6eee',	'Hamburguer                                                                      ',	NULL,	'1                                   ',	NULL,	'$15.00'),
('aba0cfb3-91fa-4ebc-9cba-e6b3658ac348',	'Hamburguer                                                                      ',	NULL,	'1                                   ',	NULL,	'$15.00'),
('d3b805f7-19de-4f20-980f-fab7f2e0ae1b',	'Hamburguer                                                                      ',	NULL,	'1                                   ',	NULL,	'$15.00'),
('428f588e-6862-48bd-9476-2aeda9ebb051',	'Hamburguer                                                                      ',	NULL,	'1                                   ',	NULL,	'$15.00'),
('65726786-e8e2-4f5c-a3d4-60ca1d60c659',	'Hamburguer                                                                      ',	NULL,	'1                                   ',	NULL,	'$15.00'),
('02107656-2611-453c-a559-6fec48e5b39b',	'Hamburguer                                                                      ',	NULL,	'1                                   ',	NULL,	'$15.00'),
('5f4454ab-a5df-4f98-a9cc-f614c4cf0e28',	'Hamburguer                                                                      ',	NULL,	'1                                   ',	NULL,	'$15.00'),
('94a7c5c5-0426-403e-ad10-24ab54138db1',	'Hamburguer                                                                      ',	NULL,	'1                                   ',	NULL,	'$15.00'),
('c7b2b0f4-c9ed-4f37-841f-4b4e5bbd32d9',	'Hamburguer                                                                      ',	NULL,	'1                                   ',	NULL,	'$15.00');

DELIMITER ;;

CREATE TRIGGER "set_uuid_id_trigger" BEFORE INSERT ON "public"."produtos" FOR EACH ROW EXECUTE FUNCTION set_uuid_id();;

DELIMITER ;

CREATE TABLE "public"."satisfacao" (
    "id" character(1) NOT NULL,
    "nome" character(50) NOT NULL,
    CONSTRAINT "satisfacao_pkey" PRIMARY KEY ("id")
) WITH (oids = false);


CREATE TABLE "public"."status" (
    "id" character(1) NOT NULL,
    "descricao" character(255) NOT NULL,
    CONSTRAINT "status_pkey" PRIMARY KEY ("id")
) WITH (oids = false);


ALTER TABLE ONLY "public"."historico" ADD CONSTRAINT "historico_id_pedido_fkey" FOREIGN KEY (id_pedido) REFERENCES pedido(id) NOT DEFERRABLE;
ALTER TABLE ONLY "public"."historico" ADD CONSTRAINT "historico_id_status_fkey" FOREIGN KEY (id_status) REFERENCES status(id) NOT DEFERRABLE;

ALTER TABLE ONLY "public"."pedido" ADD CONSTRAINT "pedido_id_pagamento_fkey" FOREIGN KEY (id_pagamento) REFERENCES pagamento(id) NOT DEFERRABLE;
ALTER TABLE ONLY "public"."pedido" ADD CONSTRAINT "pedido_id_satisfacao_fkey" FOREIGN KEY (id_satisfacao) REFERENCES satisfacao(id) NOT DEFERRABLE;
ALTER TABLE ONLY "public"."pedido" ADD CONSTRAINT "pedido_id_status_fkey" FOREIGN KEY (id_status) REFERENCES status(id) NOT DEFERRABLE;

ALTER TABLE ONLY "public"."produtos" ADD CONSTRAINT "produtos_id_categoria_fkey" FOREIGN KEY (id_categoria) REFERENCES categoria(id) NOT DEFERRABLE;

-- 2023-10-31 04:12:04.359411+00
