-- Adminer 4.8.1 PostgreSQL 16.0 (Debian 16.0-1.pgdg120+1) dump

CREATE SEQUENCE "Categoria_id_seq" INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1;

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


CREATE SEQUENCE itens_pedido_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1;

CREATE TABLE "public"."itens_pedido" (
    "id" integer DEFAULT nextval('itens_pedido_id_seq') NOT NULL,
    "id_produto" character(36) NOT NULL,
    "id_pedido" character(36) NOT NULL,
    CONSTRAINT "itens_pedido_pkey" PRIMARY KEY ("id")
) WITH (oids = false);


CREATE SEQUENCE pagamento_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1;

CREATE TABLE "public"."pagamento" (
    "id" character(36) DEFAULT 'nextval(''pagamento_id_seq'')' NOT NULL,
    "nome" character(50) NOT NULL,
    CONSTRAINT "pagamento_pkey" PRIMARY KEY ("id")
) WITH (oids = false);


CREATE SEQUENCE pedido_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1;

CREATE TABLE "public"."pedido" (
    "id" character(36) DEFAULT 'nextval(''pedido_id_seq'')' NOT NULL,
    "senha" character(3) NOT NULL,
    "id_status" character(5) NOT NULL,
    "cpf" character(11) NOT NULL,
    "detalhes" character(255),
    "valor_total" money NOT NULL,
    "data_hora_inicio" timestamp NOT NULL,
    "data_hora_fim" timestamp NOT NULL,
    "id_pagamento" character(36) NOT NULL,
    "id_satisfacao" character(36) NOT NULL,
    CONSTRAINT "pedido_pkey" PRIMARY KEY ("id")
) WITH (oids = false);


CREATE TABLE "public"."produtos" (
    "id" character(36) NOT NULL,
    "nome" character(80) NOT NULL,
    "descricao" character(127) NOT NULL,
    "url_imagem" character(200) NOT NULL,
    "preco" money NOT NULL,
    "categoria" character(36) NOT NULL,
    CONSTRAINT "produtos_id" PRIMARY KEY ("id")
) WITH (oids = false);


CREATE SEQUENCE satisfacao_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1;

CREATE TABLE "public"."satisfacao" (
    "id" character(36) DEFAULT 'nextval(''satisfacao_id_seq'')' NOT NULL,
    "nome" character(50) NOT NULL,
    CONSTRAINT "satisfacao_pkey" PRIMARY KEY ("id")
) WITH (oids = false);


CREATE SEQUENCE status_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1;

CREATE TABLE "public"."status" (
    "id" character(5) DEFAULT 'nextval(''status_id_seq'')' NOT NULL,
    "descricao" character(255) NOT NULL,
    CONSTRAINT "status_pkey" PRIMARY KEY ("id")
) WITH (oids = false);


ALTER TABLE ONLY "public"."historico" ADD CONSTRAINT "historico_id_pedido_fkey" FOREIGN KEY (id_pedido) REFERENCES pedido(id) NOT DEFERRABLE;
ALTER TABLE ONLY "public"."historico" ADD CONSTRAINT "historico_id_status_fkey" FOREIGN KEY (id_status) REFERENCES status(id) NOT DEFERRABLE;

ALTER TABLE ONLY "public"."itens_pedido" ADD CONSTRAINT "itens_pedido_id_pedido_fkey" FOREIGN KEY (id_pedido) REFERENCES pedido(id) NOT DEFERRABLE;
ALTER TABLE ONLY "public"."itens_pedido" ADD CONSTRAINT "itens_pedido_id_produto_fkey" FOREIGN KEY (id_produto) REFERENCES produtos(id) NOT DEFERRABLE;

ALTER TABLE ONLY "public"."pedido" ADD CONSTRAINT "pedido_cpf_fkey" FOREIGN KEY (cpf) REFERENCES cliente(cpf) NOT DEFERRABLE;
ALTER TABLE ONLY "public"."pedido" ADD CONSTRAINT "pedido_id_pagamento_fkey" FOREIGN KEY (id_pagamento) REFERENCES pagamento(id) NOT DEFERRABLE;
ALTER TABLE ONLY "public"."pedido" ADD CONSTRAINT "pedido_id_satisafacao_fkey" FOREIGN KEY (id_satisafacao) REFERENCES satisfacao(id) NOT DEFERRABLE;
ALTER TABLE ONLY "public"."pedido" ADD CONSTRAINT "pedido_id_status_fkey" FOREIGN KEY (id_status) REFERENCES status(id) NOT DEFERRABLE;

ALTER TABLE ONLY "public"."produtos" ADD CONSTRAINT "produtos_categoria_fkey" FOREIGN KEY (categoria) REFERENCES categoria(id) NOT DEFERRABLE;

-- 2023-10-24 00:56:38.033066+00
