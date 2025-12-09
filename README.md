# CQRS Student Project – Spring Boot

This project is a simple demonstration of the **CQRS (Command Query Responsibility Segregation)** pattern using two separate Spring Boot microservices:

* **Write Service** – handles creating students and stores data in **SQL Server**
* **Read Service** – handles reading students and uses **MySQL**

Both services communicate through **RabbitMQ**.
This setup is made for learning purposes to show the separation of write and read operations.

---

## 📌 How the System Works

1. A student is added through the **Write Service**.
2. The Write Service saves the student to **SQL Server**.
3. It then sends an event to **RabbitMQ**.
4. The **Read Service** listens to RabbitMQ and updates its **MySQL** read database.
5. Clients call the Read Service to get student data.

---

## 🛠️ Technologies Used

* Java **21**
* Spring Boot
* Maven
* RabbitMQ
* SQL Server (write model)
* MySQL (read model)

---

## 📁 Project Structure

```
cqrs-student/
├── write-service/
└── read-service/
```

---

## 🔐 Environment Variables

Both microservices require one environment variable to run correctly:

### Required Variable

* **`JASYPT_ENCRYPTOR_PASSWORD`**
  Used by **Jasypt** to decrypt encrypted values in `application.properties`.
  Without this variable, the application will fail to start.

### Examples

#### Linux / macOS

```bash
export JASYPT_ENCRYPTOR_PASSWORD=yourSecretPassword
```

#### Windows PowerShell

```powershell
setx JASYPT_ENCRYPTOR_PASSWORD "yourSecretPassword"
```

#### Docker Compose

```yaml
environment:
  - JASYPT_ENCRYPTOR_PASSWORD=yourSecretPassword
```

> ⚠️ **Do not commit the real password to GitHub.**
> Use a strong password during development and deployment.

---

## 🚀 Running the Project

1. Start RabbitMQ, MySQL, and SQL Server.
2. Set **JASYPT_ENCRYPTOR_PASSWORD** in your environment.
3. Update database and RabbitMQ settings in both services.
4. Build the project:

```bash
mvn clean install
```

5. Run each service:

```bash
mvn spring-boot:run
```

---

## 📡 API Endpoints

### Write Service

* **POST** `/students` – Add a new student

### Read Service

* **GET** `/students/{id}` – Get a student by ID
