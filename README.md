
# CEP API - Consulta de Endereços

Este projeto é uma **API REST** para consulta de CEPs, com integração simulada via **WireMock** e persistência de consultas em um banco **PostgreSQL**.

A aplicação foi totalmente containerizada usando **Docker** e **Docker Compose**, o que permite subir toda a solução com um único comando.

---

## 🚀 Tecnologias

- **Java 17** e **Spring Boot 3**
- **PostgreSQL 15**
- **WireMock** (mock de serviço externo)
- **pgAdmin 4** (interface web para o banco)
- **Docker e Docker Compose**
- **Lombok**

---

## ⚙️ Como Rodar o Projeto

### **1. Clonar o repositório**
```bash
git clone https://github.com/EdurdoAndrade-Ds/cep-api.git
cd cep-api
```

### **2. Rodar com Docker**
O comando abaixo irá construir e iniciar todos os containers:
```bash
docker-compose up --build
```

Isso irá subir:
- **API**: `http://localhost:8081`
- **WireMock**: `http://localhost:8082`
- **pgAdmin**: `http://localhost:8085`  
  Login: `admin@admin.com` | Senha: `admin`
- **PostgreSQL**: `localhost:5432` (usuário `postgres`, senha `postgres`)

---

## 🔗 Endpoints da API

### **1. Consultar CEP**
```http
GET /api/cep/{cep}
```
**Exemplo de uso:**
```
http://localhost:8081/api/cep/01001000
```
**Exemplo de resposta:**
```json
{
  "cep": "01001000",
  "logradouro": "Praça do Centro",
  "bairro": "Jardins",
  "cidade": "São Paulo",
  "uf": "SP"
}
```

---

### **2. Listar Logs de Consultas**
```http
GET /api/logs
```
**Exemplo de uso:**
```
http://localhost:8081/api/logs
```
Retorna todos os registros de consultas realizados, armazenados no banco PostgreSQL.

---

### **3. Fallback para CEP não mapeado**
Se o CEP não estiver definido no **WireMock**, o retorno será:
```json
{
  "erro": "CEP não encontrado."
}
```

---

## 🗂️ Estrutura do Projeto
```text
cep-api/
├── src/
│   ├── main/
│   │   ├── java/org/cep/api/
│   │   │   ├── controller/  # Endpoints REST
│   │   │   ├── client/      # Cliente HTTP para integração externa
│   │   │   ├── service/     # Lógica de negócios
│   │   │   ├── repository/  # Acesso ao banco (JPA)
│   │   │   └── model/       # Entidades e DTOs
│   │   └── resources/
│   │       ├── application.properties
│   │       └── wiremock/    # Arquivos de mock (mappings)
├── docker-compose.yml
├── Dockerfile
└── README.md
```

---

## 📜 Licença

Este projeto está sob a licença MIT.

---

## ✨ Autor
- **Eduardo Andrade** - [GitHub](https://github.com/EdurdoAndrade-Ds)

