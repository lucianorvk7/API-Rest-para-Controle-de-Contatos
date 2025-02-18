API de Cadastro de Pessoas e Contatos

Descrição do Projeto

O projeto consiste em uma API Rest desenvolvida em Java com Spring Boot para gerenciar um sistema de cadastro de Pessoas e seus respectivos Contatos. Cada Pessoa pode ter vários Contatos, e a API permite a realização de operações CRUD (Criar, Ler, Atualizar, Deletar) para ambas as entidades.

Tecnologias Utilizadas

Linguagem: Java (Spring Boot 3.4.2)

Banco de Dados: MySQL, MariaDB, PostgreSQL ou H2

Persistência: JPA/Hibernate

Documentação: OpenAPI (Swagger)

Funcionalidades

1. CRUD de Pessoas

Criar Pessoa

Obter Pessoa por ID

Obter Pessoa por ID para mala direta

Listar todas as Pessoas

Atualizar Pessoa por ID

Deletar Pessoa por ID

2. CRUD de Contatos

Adicionar um novo Contato a uma Pessoa

Obter Contato por ID

Listar todos os Contatos de uma Pessoa

Atualizar Contato por ID

Deletar Contato por ID

Modelagem das Entidades

Pessoa

Campo

Tipo

Restrições

ID

Long

Chave primária, não nulo

Nome

String

Não nulo

Endereço

String

Opcional

CEP

String

Opcional

Cidade

String

Opcional

UF

String

Opcional

Contato

Campo

Tipo

Restrições

ID

Long

Chave primária, não nulo

TipoContato

Integer

Não nulo (0 = Telefone, 1 = Celular)

Contato

String

Não nulo

PessoaID

Long

Chave estrangeira (Relacionamento OneToMany)

Endpoints

Pessoa

Método

Endpoint

Descrição

POST

/api/pessoas

Criar uma nova Pessoa

GET

/api/pessoas/{id}

Obter os dados de uma Pessoa por ID

GET

/api/pessoas/maladireta/{id}

Obter os dados de uma Pessoa para mala direta (usando DTO)

GET

/api/pessoas

Listar todas as Pessoas

PUT

/api/pessoas/{id}

Atualizar uma Pessoa existente

DELETE

/api/pessoas/{id}

Remover uma Pessoa por ID

Contato

Método

Endpoint

Descrição

POST

/api/contatos

Adicionar um novo Contato a uma Pessoa

GET

/api/contatos/{id}

Obter os dados de um Contato por ID

GET

/api/contatos/pessoa/{idPessoa}

Listar todos os Contatos de uma Pessoa

PUT

/api/contatos/{id}

Atualizar um Contato existente

DELETE

/api/contatos/{id}

Remover um Contato por ID

DTO - Mala Direta

No endpoint /api/pessoas/maladireta/{id}, um DTO (Data Transfer Object) é utilizado para fornecer apenas as informações relevantes:

{
  "ID": 1,
  "Nome": "Fulano",
  "MalaDireta": "Rua A, 1 - CEP: 11111-000 - Cidade/UF"
}

Como Rodar o Projeto

Pré-requisitos

Java 17+

Maven

Banco de Dados (MySQL, MariaDB, PostgreSQL ou H2)

Passos para Execução

Clone o repositório:

git clone https://github.com/seu-usuario/nome-do-repositorio.git

Configure o banco de dados no arquivo application.properties.

Execute o projeto com:

mvn spring-boot:run

Acesse o Swagger em: http://localhost:8080/swagger-ui.html

Contribuição

Sinta-se à vontade para contribuir com melhorias e novas funcionalidades. Abra um Pull Request com suas sugestões!

Licença

Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.
