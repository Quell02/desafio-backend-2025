Set-Content -Path README.md -Value @"

\# Nome do Projeto

\*\*Aplicação Full Stack com React + Spring Boot\*\*



\# Integrantes do Grupo

\- Raquel Anselmo

\- Gustavo Angelo



\# Descrição do Projeto

Este projeto é uma aplicação full stack que integra frontend em React com backend em Spring Boot.

Permite criar, listar, editar e deletar dados de usuários, posts e produtos.

O backend utiliza JWT para autenticação, garantindo acesso seguro às rotas protegidas.

O frontend consome a API utilizando Axios e está estruturado com componentes reutilizáveis e Hooks.



\# Tecnologias Utilizadas

\- \*\*Frontend:\*\* React, React Router, Axios, Material-UI

\- \*\*Backend:\*\* Java 17, Spring Boot, JPA, H2 (para testes locais)

\- \*\*Extras:\*\* JWT (Autenticação), Swagger (Documentação)



\# Como Rodar o Projeto Localmente

\## Backend

```bash

mvn clean install

mvn spring-boot:run



