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

## Como Rodar o Projeto com docker

1. **Pré-requisitos**:
   - Java JDK 17
   - Maven instalado
   - Docker instalado e em execução

2. Rode o comando `mvn clean package -DskipTests` na raiz do projeto para gerar o arquivo .jar

3. Em seguida rode o comando `docker-compose up` para iniciar os containers do banco de dados e da aplicação

## Arquitetura
A arquitetura utiliza diversos serviços da AWS e tecnologias Kubernetes para gerenciar e escalar automaticamente o aplicativo de fast food, lidando com tráfego de entrada, processamento de pedidos e integração com serviços externos de pagamento.


## Como Rodar o Projeto com kubernates

As instruções a seguir detalham a ordem e os comandos para subir os componentes do projeto no Kubernetes.

### ConfigMaps
```
kubectl apply -f constantes.configmap.yaml
kubectl apply -f postgres-sql.configmap.yaml
```

### Secrets
```
kubectl apply -f db-login.secrets.yaml
```

### Services
```
kubectl apply -f fiap-burger.svc.yaml
kubectl apply -f postgres.svc.yaml
```

### Deployments
```
kubectl apply -f postgres.deployment.yaml
kubectl apply -f fiap-burger.deployment.yaml
```

### Horizontal Pod Autoscaler
```
kubectl apply -f fiap-burger.hpa.yaml
```




**Componentes Principais**
- AWS Load Balancer: Distribui o tráfego de entrada para os serviços dentro do cluster Kubernetes.
- Route 53: Gerencia o DNS, conectando solicitações dos usuários ao Load Balancer.
- Ingress Controller: Gerencia o acesso externo aos serviços no cluster Kubernetes.
- Serviços Kubernetes: Incluem Frontend, Backend e Payment API Gateway.
- Pods: Containers executando a aplicação (UI e API).
- HPA (Horizontal Pod Autoscaler): Escala automaticamente os Pods com base na utilização de recursos.
- AWS RDS/ElastiCache: Banco de dados e caching.
- EKS Control Plane: Gerencia o cluster Kubernetes.
- ConfigMaps e Secrets: Armazenam configurações e segredos.
- IAM Roles for Service Accounts (IRSA): Gerencia permissões de acesso.
- VPC: Rede virtual privada da AWS.
- CloudWatch: Monitoramento e logs.
- Auto Scaling Group: Escala automaticamente as instâncias EC2.
  