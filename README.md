
-----

# 📌 FinTech CashPoint Simulator

The FinTech CashPoint Simulator is a Java-based desktop application that simulates the basic operations of an Automated Teller Machine (ATM). It provides functionalities such as user authentication, cash withdrawal, deposits, balance enquiry, mini statements, and more.

This project is designed to demonstrate Java Swing (GUI), JDBC (Database Connectivity), and object-oriented programming principles.

## 🚀 Features

  - 🔑 User Authentication (Login/Signup)
  - 🏦 Deposit Money
  - 💸 Withdraw Cash (Custom & Fast Cash options)
  - 📊 Balance Enquiry
  - 📜 Mini Statement Generation
  - 🔄 Transaction History
  - 🖥️ Simple Graphical User Interface (GUI) using Java Swing

## 🛠️ Technologies Used

  - **Programming Language:** Java
  - **Database:** MySQL (via JDBC)
  - **IDE:** NetBeans
  - **UI:** Java Swing
  - **Build Tool:** Ant

## 📂 Project Structure

```
FinTech-CashPoint-Simulator/
│
├── src/ASimulatorSystem/
│   ├── Login.java
│   ├── Signup.java
│   ├── Signup2.java
│   ├── Signup3.java
│   ├── Transactions.java
│   ├── Deposit.java
│   ├── Withdrawl.java
│   ├── FastCash.java
│   ├── BalanceEnquiry.java
│   ├── MiniStatement.java
│   ├── Pin.java
│   ├── Conn.java
│   └── Practice.java
│
├── fintech_cashpoint.sql   # SQL script for database setup
├── build.xml
├── manifest.mf
└── nbproject/              # NetBeans project settings
```

## ⚙️ Setup & Installation

#### 1\. Clone the repository

```bash
git clone https://github.com/your-username/FinTech-CashPoint-Simulator.git
cd FinTech-CashPoint-Simulator
```

#### 2\. Open in NetBeans IDE

Import the project into NetBeans as an existing project with Ant build.

#### 3\. Configure Database

  - Create a new database in your MySQL server.
  - Import the provided `fintech_cashpoint.sql` script to set up the tables.

<!-- end list -->

```bash
mysql -u root -p your_database_name < fintech_cashpoint.sql
```

#### 4\. Update Database Credentials

In the `src/ASimulatorSystem/Conn.java` file, update your MySQL username and password:

```java
Connection c = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/your_database_name", "root", "your_password");
```

#### 5\. Build & Run the Project

  - Use the **Run Project** button in NetBeans.
  - Or, run the following command in your terminal:

<!-- end list -->

```bash
ant run
```

## 🗄️ Database Schema

#### Users Table

| Column      | Type          | Description                  |
| :---------- | :------------ | :--------------------------- |
| **card\_no** | `VARCHAR(20)` | Unique card number (PK)      |
| pin         | `VARCHAR(10)` | User PIN (password)          |
| name        | `VARCHAR(100)`| Full name                    |
| dob         | `DATE`        | Date of Birth                |
| gender      | `VARCHAR(10)` | Gender                       |
| email       | `VARCHAR(100)`| Email address                |
| phone       | `VARCHAR(15)` | Contact number               |
| address     | `VARCHAR(255)`| User address                 |
| balance     | `DECIMAL`     | Account balance              |

#### Transactions Table

| Column      | Type          | Description                       |
| :---------- | :------------ | :-------------------------------- |
| **id** | `INT (PK)`    | Auto-increment transaction ID     |
| card\_no     | `VARCHAR(20)` | Linked card number                |
| date        | `TIMESTAMP`   | Transaction timestamp             |
| type        | `VARCHAR(20)` | `Deposit`, `Withdraw`, `FastCash` |
| amount      | `DECIMAL`     | Transaction amount                |

## 🎯 Future Enhancements

  - [ ] Add card number & PIN validation
  - [ ] Implement encryption for secure login
  - [ ] Add admin panel for bank staff
  - [ ] Improve UI with modern JavaFX

## 📸 Screenshots

*TESTING ( WILL UPLOAD SOON)*



#                                                                                                 MADE WITH 💖 MANOHAR DARIPALLI
