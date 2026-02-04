# EventClean
Uma API avançada e escalável para gerenciamento de eventos e espaços, construída com tecnologias e princípios modernos. Este projeto foi desenvolvido para oferecer desempenho robusto, código de fácil manutenção e integração perfeita com sistemas existentes.

# Features
Gestão de Eventos: Crie, atualize, exclua e recupere eventos com facilidade.
Gestão de Espaços: Gerencie detalhes, disponibilidade e reservas de espaços.

Arquitetura Limpa: Seguindo os princípios da Arquitetura Limpa para melhor organização e manutenção do código.

Controle de Versão do Banco de Dados: Utilizando o Flyway para migrações de banco de dados consistentes e rastreáveis.
Containerização: Construído com Docker para implantação simplificada e escalabilidade.

Java Moderno: Desenvolvido com Java 17, utilizando os recursos mais recentes da linguagem.

# Tech Stack
Java 17: Recursos modernos do Java para um código mais limpo e eficiente.
Spring Framework: Inclui o Spring Boot para desenvolvimento rápido e o Spring Data para interação com o banco de dados.

Docker: Aplicativos conteinerizados para fácil implantação.

Flyway: Para gerenciar migrações de esquema de banco de dados.

PostgreSQL: Backend de banco de dados confiável e escalável.

# Arquitetura
O projeto segue os princípios da Arquitetura Limpa, garantindo:

Separação de Responsabilidades: Divisão da aplicação em camadas claras (Domínio, Aplicação, Infraestrutura e Apresentação).

Testabilidade: Alta cobertura de testes e componentes facilmente testáveis.

Flexibilidade: Fácil adaptação a novas funcionalidades e integrações.

# Estrutura do Projeto

```plaintext
src
├── main
│   ├── java
│   │   └── com.example.eventmanagement
│   │       ├── application  # Logica de Aplicação
│   │       ├── domain       # Core das Regras de Negocios
│   │       ├── infrastructure # Integrações Externas e Database
│   │       └── presentation  # Controllers e REST endpoints
│   └── resources
│       ├── db/migration     # Flyway migrations
│       └── application.yml  # Configuração da API
└── test
    └── java                 # Unit e Testes de Integração
```

---

# Começando

**Pré-requisitos**
Certifique-se de ter o seguinte instalado:

Java 17
Docker
Maven (opcional, caso não esteja usando o Docker)

# Instalação

**1- Clone o Repositorio**

git clone https://github.com/DanielMouraoDev/EventClean.git
cd event-management-api

**2- Comece a Aplicação com Docker**

docker-compose up

**3- Acesse a Documentaçao**

http://localhost:8080/swagger-ui/index.html

# Endpoints

**Eventos**
GET /eventos: Recupera uma lista de eventos.

POST /eventos: Cria um novo evento.

PUT /eventos/{id}: Atualiza um evento pelo ID.

DELETE /eventos/{id}: Exclui um evento pelo ID.

**Locais**
GET /locais: Recupera uma lista de locais.

POST /locais: Cria um novo local.

PUT /locais/{id}: Atualiza um local pelo ID.

DELETE /locais/{id}: Exclui um local pelo ID.

# Database Migrations

Este projeto utiliza o Flyway para migrações de esquema de banco de dados. Todos os scripts de migração estão localizados na pasta src/main/resources/db/migration. Para executar as migrações manualmente, utilize:

mvn flyway:migrate

# Testes Unit

mvn test

**Teste de Integração**

mvn verify




