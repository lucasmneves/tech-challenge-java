# tech-challenge-java

# Lanchonete Fast Food - Sistema de Gerenciamento de Produtos

## Descrição

Este projeto faz parte de um sistema de autoatendimento de fast food desenvolvido para uma lanchonete em expansão. O módulo de gerenciamento de produtos permite a criação, edição, remoção e busca de produtos por categoria.

## Características

- **Cadastro de Produtos**: Permite a criação de novos produtos com detalhes como nome, descrição, preço e imagem.
- **Edição de Produtos**: Facilita a atualização das informações dos produtos.
- **Remoção de Produtos**: Fornece a funcionalidade para excluir produtos do sistema.
- **Busca por Categoria**: Pesquise produtos com base em suas categorias.


## Tecnologias Utilizadas

- **Linguagem**: Java
- **Framework**: Spring Boot
- **Banco de Dados**: PostgreSQL
- **ORM**: Hibernate

## Como Rodar o Projeto

1. **Pré-requisitos**:
    - Java JDK 17
    - Maven instalado
    - Docker instalado e em execução

2. Rode o comando `mvn clean package -DskipTests` na raiz do projeto para gerar o arquivo .jar

3. Em seguida rode o comando `docker-compose up` para iniciar os containers do banco de dados e da aplicação
