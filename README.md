Mateus Felipe Brunetti dos Santos, RA: 22012698-2

Vitor Galetti Martins, RA: 22019959-2

# API de Times e Campeonatos

Esta API permite o gerenciamento de **times** e **campeonatos**. Você pode cadastrar, atualizar, listar e deletar times e campeonatos, além de associar times a campeonatos.

## Endpoints

### 1. **Times**

#### **1.1 Criar um novo Time** - `POST /times`
Cadastra um novo time na aplicação.

**URL**:
POST http://localhost:8080/times


**Corpo da requisição (JSON)**:

    {

    "nome": "Flamengo",  
    "pontos": 45
  
    }

**Resposta Esperada**:


    {

    "id": 1,    
    "nome": "Flamengo",
    "pontos": 45
  
    }

#### 1.2 Atualizar um Time - PUT /times/{id}

Atualiza um time existente, substituindo o time atual.

URL: PUT http://localhost:8080/times/{id}

**Corpo da requisição (JSON):**


    {

    "nome": "Flamengo Atualizado",
    "pontos": 47
    }

**Resposta Esperada:**


    {

    "id": 1,
    "nome": "Flamengo Atualizado",
    "pontos": 47
  
    }
    
#### 1.3 Listar Todos os Times - GET /times

Retorna todos os times cadastrados.

URL: GET http://localhost:8080/times

Resposta Esperada:


    [
      {
        "id": 1,
        "nome": "Flamengo",
        "pontos": 45
      },
      {
        "id": 2,
        "nome": "Palmeiras",
        "pontos": 50
      }
    ]
    
#### 1.4 Deletar um Time - DELETE /times/{id}
Deleta um time pelo seu ID.

URL: DELETE http://localhost:8080/times/{id}

Resposta Esperada:

    Status HTTP: 200 OK para sucesso.
    Status HTTP: 404 NOT FOUND se o time não for encontrado.
    
### 2. Campeonatos
#### 2.1 Criar um novo Campeonato - POST /campeonatos
Cadastra um novo campeonato na aplicação.

URL: POST http://localhost:8080/campeonatos

**Corpo da requisição (JSON):**

    {
      "nome": "Campeonato Brasileiro",
      "dataInicio": "2025-04-10",
      "dataFim": "2025-12-10",
      "times": [
        {
          "id": 1,
          "nome": "Flamengo",
          "pontos": 45
        },
        {
          "id": 2,
          "nome": "Palmeiras",
          "pontos": 50
        }
      ]
    }
    
**Resposta Esperada:**


    {
      "id": 1,
      "nome": "Campeonato Brasileiro",
      "dataInicio": "2025-04-10",
      "dataFim": "2025-12-10",
      "times": [
        {
          "id": 1,
          "nome": "Flamengo",
          "pontos": 45
        },
        {
          "id": 2,
          "nome": "Palmeiras",
          "pontos": 50
        }
      ]
    }
    
#### 2.2 Atualizar um Campeonato - PUT /campeonatos/{id}
Atualiza um campeonato existente, substituindo o campeonato atual.

URL: PUT http://localhost:8080/campeonatos/{id}

**Corpo da requisição (JSON):**


    {
      "nome": "Campeonato Brasileiro Atualizado",
      "dataInicio": "2025-05-01",
      "dataFim": "2025-12-30",
      "times": [
        { "id": 1 },
        { "id": 2 }
      ]
    }
    
**Resposta Esperada:**


    {
      "id": 1,
      "nome": "Campeonato Brasileiro Atualizado",
      "dataInicio": "2025-05-01",
      "dataFim": "2025-12-30",
      "times": [
        { "id": 1 },
        { "id": 2 }
      ]
    }
    
#### 2.3 Listar Todos os Campeonatos - GET /campeonatos
Retorna todos os campeonatos cadastrados.

URL: GET http://localhost:8080/campeonatos

**Resposta Esperada:**

    [
      {
        "id": 1,
        "nome": "Campeonato Brasileiro",
        "dataInicio": "2025-04-10",
        "dataFim": "2025-12-10",
        "times": [
          {
            "id": 1,
            "nome": "Flamengo",
            "pontos": 45
          },
          {
            "id": 2,
            "nome": "Palmeiras",
            "pontos": 50
          }
        ]
      }
    ]
    
#### 2.4 Deletar um Campeonato - DELETE /campeonatos/{id}
Deleta um campeonato pelo seu ID.

URL: DELETE http://localhost:8080/campeonatos/{id}

**Resposta Esperada:**

    Status HTTP: 200 OK para sucesso.
    Status HTTP: 404 NOT FOUND se o campeonato não for encontrado.
    
## Como Rodar a Aplicação Localmente
Clone o repositório:

    git clone https://github.com/usuario/nome-do-repositorio.git
    cd nome-do-repositorio

Rodando a aplicação: Se você tiver o Spring Boot configurado corretamente, basta rodar a aplicação utilizando o seguinte comando:

    ./mvnw spring-boot:run
    
Ou se estiver usando o IntelliJ IDEA, você pode rodar a aplicação diretamente pela IDE.

#### Acessando a API: A API estará disponível em http://localhost:8080/.

## Tecnologias Utilizadas

**Spring Boot para construção da API.**

**Spring Data JPA para persistência no banco de dados.**

**PostgreSQL (ou qualquer outro banco configurado) para armazenar os dados.**

**Postman para testar as requisições.**
