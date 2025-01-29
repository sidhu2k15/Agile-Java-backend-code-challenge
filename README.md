# **User Management API (Spring Boot + CQRS + H2 + Flyway)**
This is a **Spring Boot-based REST API** that manages a collection of users using **CQRS (Command Query Responsibility Segregation)**. It utilizes an **in-memory H2 database**, with **Flyway** for database migrations, and provides **pagination, API documentation (Swagger), and unit tests**.

---

## **Features**
✔️ **CQRS Architecture** (Separate Query & Command Handlers)  
✔️ **CRUD Operations** for Users  
✔️ **Pagination** for listing users  
✔️ **H2 Database (In-Memory) with Flyway** for migrations  
✔️ **Swagger API Documentation**  
✔️ **User Grouping by Country, State, City**  
✔️ **Unit Tests with JUnit & MockMvc**  
✔️ **Random User Generation** (Uses [Random User Generator API](https://randomuser.me))  

---

## **Tech Stack**
- **Spring Boot 2.x**
- **Spring Data JPA**
- **H2 Database (In-Memory)**
- **Flyway (Database Migrations)**
- **Springfox Swagger (API Documentation)**
- **JUnit 5 & MockMvc (Testing)**

---

## **Installation & Setup**

### **1️⃣ Clone the Repository**
```sh
git clone https://github.com/sidhu2k15/Agile-Java-backend-code-challenge.git
cd user-management-api
git checkout master
```

### **2️⃣ Build and Run the Project**
* Clean and Build User Management
    ```bash
    cd {project_root_directory}
    gradle clean
    gradle buildAll
    ```

* Get the distribution zip file from the distributions folder
    ```bash
    cd {project_root_directory}/build/distributions/user-management-x.x.x.zip
    ```

* Deploy and run
    ```bash
    unzip user-management-x.x.x.zip
    ```
        ```bash
        java -jar user-management-x.x.x.jar




### **3️⃣ Access the API**
After starting the server, open:  
✅ **Swagger UI**: [`http://localhost:8080/swagger`]
✅ **API JSON**: [`http://localhost:8080/api-docs`]   
✅ **H2 Console**: [`http://localhost:8080/h2-console`](http://localhost:8080/h2-console) (JDBC URL: `jdbc:h2:mem:testdb`)

---

## **API Endpoints**
### **1️⃣ User Management**
| Method | Endpoint | Description |
|--------|---------|-------------|
| `GET` | `/api/users/?page={page}&size={size}` | Get paginated list of users |
| `GET` | `/api/users/{username}/` | Get a user by username |
| `POST` | `/api/users/` | Create a new user |
| `PUT` | `/api/users/{username}/` | Update an existing user |
| `DELETE` | `/api/users/{username}/` | Delete a user |

### **2️⃣ Extra Features**
| Method | Endpoint | Description |
|--------|---------|-------------|
| `GET` | `/api/users/generate/{number}/` | Generate `{number}` random users |
| `GET` | `/api/users/tree/` | Get users grouped by Country → State → City |

---

## **Database Schema (H2)**
| Column | Type | Constraints |
|--------|------|------------|
| `username` | VARCHAR(50) | PRIMARY KEY |
| `name` | VARCHAR(100) | NOT NULL |
| `email` | VARCHAR(100) | NOT NULL, UNIQUE |
| `gender` | VARCHAR(10) | NOT NULL |
| `picture` | VARCHAR(255) | - |
| `country` | VARCHAR(50) | - |
| `state` | VARCHAR(50) | - |
| `city` | VARCHAR(50) | - |

> **Check the Database:**  
> Open [H2 Console](http://localhost:8080/h2-console) and enter:  
> **JDBC URL**: `jdbc:h2:mem:testdb`  
> **User**: `sa`  
> **Password**: (leave empty)

---

## **Contributing**
✅ Fork the repository  
✅ Create a new branch (`feature-xyz`)  
✅ Commit your changes  
✅ Push to your branch  
✅ Open a Pull Request  

---

## **License**
📝 **MIT License** - Feel free to modify and use it! 😊
