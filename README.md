# Anime REST API

API REST para gerenciamento de animes, criada como estudo aprofundado de Spring Boot.

## Recursos

- CRUD e busca por identificador ou nome
- Validacao de requisicoes e DTOs
- Mapeamento com MapStruct
- Tratamento centralizado de excecoes
- Persistencia com Spring Data JPA
- Swagger e testes de controller/repository

## Stack

Java 8, Spring Boot, Spring Web, Spring Data JPA, MySQL/H2, MapStruct, Lombok, Swagger e JUnit.

| Metodo | Rota | Finalidade |
|---|---|---|
| `GET` | `/animes` | Listagem paginada |
| `GET` | `/animes/{id}` | Consulta |
| `POST` | `/animes` | Cadastro |
| `PUT` | `/animes` | Atualizacao |
| `DELETE` | `/animes/{id}` | Exclusao |

> Projeto de estudo legado. Recomenda-se migrar as dependencias e a configuracao Swagger para versoes atuais.

## Autor

Desenvolvido por [Silas Melo](https://github.com/Silasmelo12).
