-- Adminer 4.8.1 PostgreSQL 16.0 (Debian 16.0-1.pgdg120+1) dump

CREATE SEQUENCE "Categoria_id_seq" INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1;

CREATE TABLE "public"."categoria" (
    "id" VARCHAR(1) DEFAULT 'nextval(''"Categoria_id_seq"'')' NOT NULL,
    "nome" VARCHAR(80) NOT NULL,
    "descricao" VARCHAR(127) NOT NULL,
    CONSTRAINT "Categoria_pkey" PRIMARY KEY ("id")
) WITH (oids = false);


CREATE TABLE "public"."cliente" (
    "nome" VARCHAR(80) NOT NULL,
    "email" VARCHAR(50) NOT NULL,
    "cpf" VARCHAR(11) NOT NULL,
    CONSTRAINT "cliente_cpf" PRIMARY KEY ("cpf")
) WITH (oids = false);


CREATE SEQUENCE historico_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1;

CREATE TABLE "public"."historico" (
    "id" integer DEFAULT nextval('historico_id_seq') NOT NULL,
    "id_pedido" VARCHAR(36) NOT NULL,
    "id_status" VARCHAR(5) NOT NULL,
    "data_hora" timestamp NOT NULL,
    CONSTRAINT "historico_pkey" PRIMARY KEY ("id")
) WITH (oids = false);


CREATE SEQUENCE itens_pedido_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1;

CREATE TABLE "public"."itens_pedido" (
    "id" VARCHAR(36)  NOT NULL,
    "produto" VARCHAR(36) NOT NULL,
    "pedido" VARCHAR(36) NOT NULL,
    CONSTRAINT "itens_pedido_pkey" PRIMARY KEY ("id")
) WITH (oids = false);


CREATE TABLE "public"."pagamento" (
    "id" VARCHAR(1) NOT NULL,
    "nome" VARCHAR(50) NOT NULL,
    CONSTRAINT "pagamento_pkey" PRIMARY KEY ("id")
) WITH (oids = false);

CREATE TABLE "public"."pedido" (
    "id" VARCHAR(36)  NOT NULL,
    "senha" VARCHAR(10) NOT NULL,
    "id_status" VARCHAR(1) NOT NULL,
    "cpf" VARCHAR(11),
    "detalhes" VARCHAR(255),
    "valor_total" money NOT NULL,
    "data_hora_inicio" timestamp NOT NULL,
    "data_hora_fim" timestamp,
    "id_pagamento" VARCHAR(1),
    "id_satisfacao" VARCHAR(1),
    CONSTRAINT "pedido_pkey" PRIMARY KEY ("id")
) WITH (oids = false);

CREATE TABLE "public"."produtos" (
    "id" VARCHAR(36) NOT NULL,
    "nome" VARCHAR(80) NOT NULL,
    "descricao" VARCHAR(127) NOT NULL,
    "url_imagem" VARCHAR(200) NOT NULL,
    "preco" character varying NOT NULL,
    "id_categoria" VARCHAR(36) NOT NULL,
    CONSTRAINT "produtos_id" PRIMARY KEY ("id")
) WITH (oids = false);


CREATE TABLE "public"."satisfacao" (
    "id" VARCHAR(1)  NOT NULL,
    "nome" VARCHAR(50) NOT NULL,
    CONSTRAINT "satisfacao_pkey" PRIMARY KEY ("id")
) WITH (oids = false);


CREATE TABLE "public"."status" (
    "id" VARCHAR(1)  NOT NULL,
    "descricao" VARCHAR(255) NOT NULL,
    CONSTRAINT "status_pkey" PRIMARY KEY ("id")
) WITH (oids = false);


ALTER TABLE ONLY "public"."historico" ADD CONSTRAINT "historico_id_pedido_fkey" FOREIGN KEY (id_pedido) REFERENCES pedido(id) NOT DEFERRABLE;
ALTER TABLE ONLY "public"."historico" ADD CONSTRAINT "historico_id_status_fkey" FOREIGN KEY (id_status) REFERENCES status(id) NOT DEFERRABLE;

ALTER TABLE ONLY "public"."itens_pedido" ADD CONSTRAINT "itens_pedido_pedido_fkey" FOREIGN KEY (pedido) REFERENCES pedido(id) NOT DEFERRABLE;
ALTER TABLE ONLY "public"."itens_pedido" ADD CONSTRAINT "itens_pedido_produto_fkey" FOREIGN KEY (produto) REFERENCES produtos(id) NOT DEFERRABLE;

--ALTER TABLE ONLY "public"."pedido" ADD CONSTRAINT "pedido_cpf_fkey" FOREIGN KEY (cpf) REFERENCES cliente(cpf) NOT DEFERRABLE;
ALTER TABLE ONLY "public"."pedido" ADD CONSTRAINT "pedido_id_pagamento_fkey" FOREIGN KEY (id_pagamento) REFERENCES pagamento(id) NOT DEFERRABLE;
ALTER TABLE ONLY "public"."pedido" ADD CONSTRAINT "pedido_id_satisfacao_fkey" FOREIGN KEY (id_satisfacao) REFERENCES satisfacao(id) NOT DEFERRABLE;
ALTER TABLE ONLY "public"."pedido" ADD CONSTRAINT "pedido_id_status_fkey" FOREIGN KEY (id_status) REFERENCES status(id) NOT DEFERRABLE;

ALTER TABLE ONLY "public"."produtos" ADD CONSTRAINT "produtos_categoria_fkey" FOREIGN KEY (id_categoria) REFERENCES categoria(id) NOT DEFERRABLE;

-- 2023-10-24 00:56:38.033066+00

INSERT INTO "satisfacao" ("id", "nome")
VALUES ('0', 'Sem avaliacao'),  ('5', 'Otimo'),  ('4', 'Bom'), ('3', 'Regular'), ('2', 'Ruim'),  ('1', 'Pessimo');

INSERT INTO "status" ("id", "descricao")
VALUES ('1', 'Carrinho aberto'),  ('2', 'Carrinho confirmado'),  ('3', 'Pagamento efetuado'), ('4', 'Recebido'),  ('5', 'Em preparo'), ('6', 'Pronto'), ('7', 'Entregue ao cliente');

INSERT INTO "pagamento" ("id", "nome")
VALUES ('0', 'Pagamento nao selecionado'), ('1', 'Debito'),  ('2', 'Credito'),  ('3', 'Mercado pago');

INSERT INTO "categoria" ("id", "nome", "descricao")
VALUES ('1', 'Lanches', 'Lanches'), ('2', 'Bebida', 'Bebida'),  ('3', 'Acompanhamento', 'Acompanhamento'),  ('4', 'Sobremesa', 'Sobremesa');

INSERT INTO "produtos" ("id", "nome", "descricao", "url_imagem", "preco", "id_categoria")
VALUES ('48de37ee-a8aa-4455-baca-bc4a87205a5a', 'Hamburguer', 'Pao, alface, molho, queijo', 'path/hamburguer.png', '10', '1'), ('58de37ee-1233-4455-baca-bc4a87205a23', 'Coca-cola', 'Sem acucar', 'path/coca.png', '5', '2'), ('29de37ee-1233-4455-baca-bc4a87205a44', 'Batata frita', '', 'path/batata.png', '7', '3');