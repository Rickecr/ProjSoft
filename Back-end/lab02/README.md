# Laboratório 2 - Lab CRUD de produtos com REST, Spring Boot e JPA/hibernate

> Ter um contato inicial com o framework de desenvolvimento que iremos adotar na disciplina (spring boot) para desenvolver uma aplicação muito simples.

Vamos criar um CRUD de um produto, utilizando o spring boot e o hibernate. Vamos utilizar o JPA (Java Persistence API) como interface para utilizar o hibernate e por consequência conectar o banco e a aplicação. O JPA é uma interface que serve de abstração para que você possa utilizar diversos ORMs. ORM (Object Relational Mapper) é o serviço que mapeia objetos para dados do banco de dados e vice versa. Uma ferramenta ORM muito usada é o hibernate, mas existem diversas outras.

Ao final do lab você deve ter uma api que tem serviços para criar, atualizar, deletar e buscar um produto genérico. Você deve ter integração com algum banco de dados e você terá como opcional tratamento de exceptions que irá auxiliá-lo no seu projeto.

- [X] Criando o Model Produto.
- [X] Criando o DAO de Produto.
- [X] Criando o Service de Produto.
- [X] Criando o Controller de Produtos:
  - [X] Create:
    - [X] Cadastrar um novo produto(POST).
  - [X] Read:
    - [X] Buscar um produto especificado pelo ID(GET).
    - [X] Retornar todos os produtos cadastrados(GET).
  - [X] Update:
    - [X] Atualizar um produto por completo(PUT).
    - [X] Atualizar um produto parcialmente(PATCH).
  - [X] Delete:
    - [X] Deletar um produto pelo ID(DELETE).
- [X] Conexão com o banco de dados:
  - [X] H2
- [X] Testando com o Postman.
