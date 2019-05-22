# Projeto de Software - Back-End

> Repositório da disciplina de Projeto de Software da parte de Back-End - 2019.1

# Plano de Aula:

## Parte 1: Introdução ao Back-End:

> Introdução sobre como funciona o back-end, o que é uma API, o que são frameworks.

- [X] - O que é back-end ?
- [X] - O que é uma API ?
- [X] - Back-end Framework.

## Parte 2: Arquiteturas:

> Aula sobre as arquiteturas web existentes e quais serão estudadas na disciplina.

- [X] - Cliente/Servidor:
  - [X] - Servidor oferece serviços para diversos clientes.

- [X] - Arquitetura P2P - Peer to Peer.:
  - [X] - Não há separação de cliente e servidor.
  - [X] - Cada nó da rede funciona tanto como cliente quanto servidor. Ex: Torrents

- [X] - Arquitetura Monolítica:
  - [X] - Um único sistema, com todos os módulos dentro dele. Um único jar.
  - [X] - Facilita na hora do deploy.
  - [X] - Dificulta na hora de manutenção.
  - [X] - Não há repetição do código.
  
- [X] - Arquitetura de Microserviços:
  - [X] - Separação dos módulos.
  - [X] - Facilita na hora de manutenção.
  - [X] - Dificulta na hora do deploy.
  - [X] - Repetição de código e dos dados.

- [X] - Padrão MVC:
  - [X] - Model-View-Controller

- [X] - Spring MVC:
  - [X] - @Controller
  - [X] - @RestController
  - [X] - @GetMapping
  - [X] - @RequestParam
  - [X] - @RequestMapping
  - [X] - @SpringBootApplication
  - [X] - Model
  - [X] - Thymeleaf
  - [X] - Templates

## Laboratório 1 - Lab Hello World com REST e Spring Boot

> Ter um contato inicial com o framework de desenvolvimento que iremos adotar na disciplina (spring boot) para desenvolver uma aplicação muito simples.


O objetivo desse laboratório é introduzi-lo ao framework spring boot, aprendendo seus conceitos iniciais. No final deste laboratório, você já será capaz de entender como iniciar um servidor back-end que recebe requisições personalizadas por você. 

Os slides da aula dada associada a este lab estão aqui.

Sua tarefa aqui é criar uma aplicação Spring Boot, que contenha um controller (controlador) que recebe requisições. Dentro desse controller, é necessário que você crie uma rota do tipo HTTP GET, que retorna um arquivo do tipo HTML.

A seguir, iremos introduzi-lo a uma sequência de passos para entender melhor como fazer isso, desde a instalação dos programas necessários até a programação de uma primeira rota simples. O resto é com você!

- [X] - Instalação e entendimento.
- [X] - Spring Boot na prática.
- [X] - API Rest - @RestController e JSON.
