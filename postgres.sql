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
    "pedido" character(36) NOT NULL,
    "produto" uuid NOT NULL,
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
    "preco" money NOT NULL,
    CONSTRAINT "produtos_pkey" PRIMARY KEY ("id")
) WITH (oids = false);


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

ALTER TABLE ONLY "public"."itens_pedido" ADD CONSTRAINT "itens_pedido_id_fkey" FOREIGN KEY (id) REFERENCES pedido(id) NOT DEFERRABLE;
ALTER TABLE ONLY "public"."itens_pedido" ADD CONSTRAINT "itens_pedido_produto_fkey" FOREIGN KEY (produto) REFERENCES produtos(id) NOT DEFERRABLE;

ALTER TABLE ONLY "public"."pedido" ADD CONSTRAINT "pedido_id_pagamento_fkey" FOREIGN KEY (id_pagamento) REFERENCES pagamento(id) NOT DEFERRABLE;
ALTER TABLE ONLY "public"."pedido" ADD CONSTRAINT "pedido_id_satisfacao_fkey" FOREIGN KEY (id_satisfacao) REFERENCES satisfacao(id) NOT DEFERRABLE;
ALTER TABLE ONLY "public"."pedido" ADD CONSTRAINT "pedido_id_status_fkey" FOREIGN KEY (id_status) REFERENCES status(id) NOT DEFERRABLE;

ALTER TABLE ONLY "public"."produtos" ADD CONSTRAINT "produtos_id_categoria_fkey" FOREIGN KEY (id_categoria) REFERENCES categoria(id) NOT DEFERRABLE;

-- 2023-10-31 04:33:44.888758+00
