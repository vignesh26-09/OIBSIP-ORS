# 🚆 Online Reservation System

## 📌 Overview
A Java-based desktop application for booking, searching, and cancelling train tickets with MySQL database integration.

---

## 🚀 Features
- 🔐 User Authentication (MySQL)
- 🎟️ Ticket Booking
- 🔍 PNR Search
- ❌ Ticket Cancellation
- 🖥️ GUI using Java Swing

---

## 🛠️ Tech Stack
- Java
- Swing (GUI)
- MySQL
- JDBC

---

## 📂 Project Structure
# 🚆 Online Reservation System

## 📌 Overview
A Java-based desktop application for booking, searching, and cancelling train tickets with MySQL database integration.

---

## 🚀 Features
- 🔐 User Authentication (MySQL)
- 🎟️ Ticket Booking
- 🔍 PNR Search
- ❌ Ticket Cancellation
- 🖥️ GUI using Java Swing

---

## 🛠️ Tech Stack
- Java
- Swing (GUI)
- MySQL
- JDBC

---

## 📂 Project Structure
main/ → UI
service/ → Business Logic
model/ → Data Models
util/ → DB Connection & Utilities


---

## ▶️ How to Run
1. Setup MySQL database
2. Add MySQL Connector/J
3. Set the database password in the environment (do not put it in source control):
   - PowerShell: `$env:DB_PASSWORD = "<your-local-mysql-password>"`
   - macOS/Linux: `export DB_PASSWORD="<your-local-mysql-password>"`
4. Optionally set `DB_USER` (defaults to `root`) and `DB_URL` (defaults to `jdbc:mysql://localhost:3306/reservation_db`).
5. Run: `java -cp ".;lib/mysql-connector-j-9.5.0.jar" main.LoginUI`


---
## 👨‍💻 Author
Vignesh
