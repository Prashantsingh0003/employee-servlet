

````markdown
# Employee Registration System 🚀

This is a **Java EE Web Application** for registering employees into a MySQL database using **Servlets** and **HTML5/CSS3**. It demonstrates form handling, server-side processing, and database interaction using **JDBC**.

---

## 📋 Features

- 📄 Employee Registration Form with client-side & server-side validation
- 📤 Data submission via HTTP POST to a Servlet
- 🗄️ Store employee records in a MySQL database
- 🎨 Clean and responsive UI built with HTML & CSS
- 🧾 Print submitted values on the server console (for debugging)

---

## 🧑‍💻 Technologies Used

| Layer      | Technology          |
|------------|---------------------|
| Frontend   | HTML5, CSS3         |
| Backend    | Java (Servlets)     |
| Database   | MySQL               |
| IDE        | Eclipse             |
| Server     | Apache Tomcat       |
| JDBC       | MySQL Connector/J   |

---

## 🔧 Setup Instructions

1. **Clone the Repository**

   ```bash
   git clone https://github.com/your-username/employee-registration.git
````

2. **Import into Eclipse**

   * Open Eclipse.
   * Go to: `File → Import → Dynamic Web Project → Select the project folder`.

3. **Add MySQL Connector**

   * Download MySQL JDBC driver (Connector/J).
   * Add the `.jar` file to your project’s Build Path and also to `WEB-INF/lib`.

4. **Run on Tomcat**

   * Right-click project → Run As → Run on Server.
   * Open browser: [http://localhost:8080/EmployeeRegistration/employee\_form.html](http://localhost:8080/EmployeeRegistration/employee_form.html)

---

## 📬 Form Fields Captured

* Employee ID
* First Name & Last Name
* Date of Birth & Gender
* Email & Phone
* Address, City, State, ZIP Code
* Department & Designation
* Date of Joining
* Salary

---

## ✅ Sample Output

* Submitted data is displayed back in the browser.
* **Success Message**: `Employee Registered Successfully!`
* Also stored in MySQL database under `company` schema.

---

## 📸 Screenshots

### 🔹 1. Registration Form (Before Submission)


![image](https://github.com/user-attachments/assets/cd3d0839-76fb-44bf-88c2-6ed2e014825b)

### 🔹 3. MySQL Database Record

![image](https://github.com/user-attachments/assets/292d2e2e-a5ad-4729-8285-4fc63b1a403e)


---

## 📝 Notes

* Servlet is mapped using `@WebServlet("/submitform")`.
* Update your DB credentials inside the servlet code:

```java
DriverManager.getConnection(
  "jdbc:mysql://localhost:3306/company?useSSL=false", "yourUsername", "yourPassword"
);
```

---

## 🤝 Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you'd like to change.

---

## 🙋‍♂️ Author

**Prashant Singh**
🔗 [LinkedIn](https://www.linkedin.com/in/prashant-singh2/)
📫 Email: [prashantftp03@gmail.com](mailto:prashantftp03@gmail.com)


