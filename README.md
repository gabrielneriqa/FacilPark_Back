# 📘 README.md — FacilPark API

```markdown
# 🚗 FacilPark API  
### Sistema de Controle de Estacionamento — Backend Monolítico em Spring Boot

A **FacilPark API** é uma aplicação **monolítica**, desenvolvida em **Java 23** com **Spring Boot 3**, seguindo boas práticas de arquitetura como *Strategy*, *Factory* e *Service Layer*.  
O sistema controla a entrada, saída e listagem de vagas de um estacionamento.

---

## 🏗️ Arquitetura

A aplicação é **monolítica**, composta por:

- **Controllers** — expõem endpoints REST  
- **Services** — regras de negócio  
- **Strategies** — cálculo de valor por permanência  
- **Factories** — criação de objetos de domínio  
- **Models** — representação dos veículos  
- **Repository (in-memory)** — armazena as vagas em memória  
- **Config** — regras gerais do estacionamento  

Todo o backend reside em **um único projeto**, com execução única via Spring Boot — caracterizando uma **arquitetura monolítica tradicional**.

---

## 🚀 Tecnologias Utilizadas

- **Java 23**
- **Spring Boot 3.2**
- **Maven**
- **REST API**
- **Arquitetura baseada em Strategy e Factory**
- **Armazenamento em memória (sem banco de dados)**

---

## 📦 Estrutura do Projeto

```

src/main/java/com/facilpark/
│
├── controller/            # Endpoints REST
│   └── EstacionamentoController.java
│
├── service/               # Regras de negócio
│   └── EstacionamentoService.java
│
├── model/                 # Modelos de veículos e vagas
│   ├── Veiculo.java
│   ├── Carro.java
│   ├── Moto.java
│   ├── Caminhao.java
│   └── Vaga.java
│
├── factory/               # Factory para criação dos veículos
│   └── VeiculoFactory.java
│
├── strategy/              # Estratégias de cálculo de valor
│   ├── CalculoValorStrategy.java
│   └── CalculoValorPorEntradaStrategy.java
│
├── repository/            # Repositório em memória
│   └── EstacionamentoRepository.java
│
├── config/                # Configurações gerais
│   └── EstacionamentoConfig.java
│
└── FacilparkApplication.java

```

---

## ⚙️ Instalação

### 1️⃣ Instale o Java 23  
Verifique:
```

java -version
javac -version

```

### 2️⃣ Instale o Maven  
Verifique:
```

mvn -v

````

### 3️⃣ Baixe as dependências
```bash
mvn clean install
````

### 4️⃣ Rode a aplicação

```bash
mvn spring-boot:run
```

A API ficará disponível em:
➡️ `http://localhost:8080`

---

## 📡 Endpoints da API

### ✔️ 1. Registrar entrada

**POST /entrada**

**Body:**

```json
{
  "tipo": "carro",
  "placa": "ABC-1234"
}
```

**Retorno:**

```json
{
  "tipo": "carro",
  "placa": "ABC-1234"
}
```

---

### ✔️ 2. Registrar saída

**POST /saida**

**Body:**

```json
{
  "placa": "ABC-1234"
}
```

**Retorno:**

```json
{
  "valor": 12.50
}
```

---

### ✔️ 3. Listar vagas

**GET /vagas**

**Retorno:**

```json
[
  { "ocupada": true, "placa": "ABC-1234" },
  { "ocupada": false }
]
```

---

## 🧠 Regras de negócio

### Entrada de veículo:

* Cria um veículo via **Factory**
* Verifica se há vaga disponível
* Ocupa a próxima vaga livre
* Registra horário

### Saída de veículo:

* Procura vaga pela placa
* Executa **Strategy de cálculo**
* Libera vaga

### Valores base:

* Carro → R$ 5 por entrada
* Moto → R$ 3 por entrada
* Caminhão → R$ 10 por entrada

*(Você pode alterar em `CalculoValorPorEntradaStrategy`.)*

---

## 🧪 Coleção Postman

Uma coleção Postman com os 3 endpoints está disponível no arquivo:

`postman_collection.json`

Ou você pode importar manualmente usando o exemplo deste README.

---

## 🧱 Por que a aplicação é monolítica?

✔️ Todo código está dentro do mesmo backend
✔️ Todas as regras de negócio em um único deploy
✔️ Nenhum microserviço
✔️ Frontend separado **não** muda a arquitetura do backend
✔️ Banco de dados (se houver futuramente) seria único e centralizado

---

## 📄 Licença

Este projeto é de uso acadêmico/didático.
Sinta-se livre para melhorar, estudar e evoluir a aplicação.

---

## ✨ Autor
João Emanuel e Gabriel Raniere
Refatorações e transformação em API REST realizadas em colaboração com ChatGPT.

```

