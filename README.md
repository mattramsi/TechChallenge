# TechChallenge

## Descrição do Projeto

O **TechChallenge** é uma aplicação desenvolvida para atender a um desafio técnico. O projeto tem como objetivo fornecer uma interface robusta para gerenciamento de produtos e clientes, utilizando uma arquitetura baseada em microserviços, onde as melhores práticas de desenvolvimento e as tecnologias mais atuais são empregadas.

## Objetivos

- **Gerenciamento de Produtos**: Permitir a criação, leitura, atualização e exclusão de produtos.
- **Gerenciamento de Clientes**: Habilitar o cadastro e a busca de clientes.
- **Registro de Pedidos**: Proporcionar funcionalidades para registrar pedidos realizados pelos clientes.
- **Dockerização**: Facilitar o ambiente de desenvolvimento e produção através do uso de Docker.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **Spring Boot**: Framework para construção de aplicações.
- **JPA/Hibernate**: Para gerenciamento de persistência.
- **Docker**: Para criação de contêineres e facilitação da execução do projeto.
- **MySQL**: Banco de dados utilizado.

## Como Iniciar o Projeto Localmente

Para iniciar o projeto localmente, siga as instruções abaixo:

### Pré-requisitos

- **Docker**: Certifique-se de ter o Docker instalado em sua máquina.
- **Docker Compose**: O Docker Compose deve estar instalado.

### Passo a Passo

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/mattramsi/TechChallenge.git
   cd TechChallenge


## Construir e executar os contêineres:

./mvnw clean install
docker-compose -f docker_compose.yml up -d --build
