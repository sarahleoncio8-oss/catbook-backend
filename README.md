CatBook - Backend API

Esta é a API RESTful construída em Java com Spring Boot para o projeto CatBook. Ela é responsável por receber as requisições do frontend e gerenciar 
as operações de CRUD diretamente em um banco de dados relacional.

Configuração Obrigatória do Banco de Dados
Para que o projeto funcione, é obrigatório criar e configurar o banco de dados localmente. Siga os passos:

1. Abra o seu banco de dados MySQL (via terminal ou MySQL Workbench).
2. Execute o seguinte comando para criar o banco: `CREATE DATABASE catbook_db;`
3. No projeto Spring Boot, abra o arquivo `src/main/resources/application.properties`.
4. Altere as configurações de credenciais (`spring.datasource.username` e `spring.datasource.password`) colocando o usuário e a senha do seu MySQL local.

Como rodar o projeto Java
1. Abra a pasta do projeto em uma IDE.
3. Localize o arquivo principal `CatbookBackendApplication.java`.
4. Clique no botão verde de "Run" (Executar) na sua IDE. O servidor iniciará em `http://localhost:8080`.

Endpoints da API REST
A API possui as seguintes rotas baseadas em `/gatos`:

GET /gatos - Retorna uma lista em JSON com todos os gatinhos salvos no banco.
POST /gatos - Salva um novo gatinho. Requer um body JSON com `catId`, `urlImagem` e `nome`.
PUT /gatos/{id} - Atualiza as informações (como o nome) de um gatinho específico através do seu ID.
DELETE /gatos/{id} - Deleta um gatinho do banco de dados utilizando o seu ID.
