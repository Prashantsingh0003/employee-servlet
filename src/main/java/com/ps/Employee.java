package com.ps;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/submitform")
public class Employee extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Set content type for the response
		response.setContentType("text/html;charset=UTF-8");

		// Retrieve form parameters from request and parse where necessary
		String empid1 = request.getParameter("empId");
		int empidfinal = Integer.parseInt(empid1); // Convert Employee ID to int

		String firstname1 = request.getParameter("firstName");
		String lastname1 = request.getParameter("lastName");
		String dob1 = request.getParameter("dob");
		String gender1 = request.getParameter("gender");
		String email1 = request.getParameter("email");
		String phone1 = request.getParameter("phone");
		String address1 = request.getParameter("address");
		String city1 = request.getParameter("city");
		String state1 = request.getParameter("state");

		String zip1 = request.getParameter("zip");
		int zipfinal = Integer.parseInt(zip1); // Convert ZIP code to int

		String department1 = request.getParameter("department");
		String designation1 = request.getParameter("designation");
		String doj1 = request.getParameter("doj");

		String salary1 = request.getParameter("salary");
		Long salaryfinal = Long.parseLong(salary1); // Convert salary to long

		// Print all retrieved data on server console for debugging
		System.out.println(empidfinal);
		System.out.println(firstname1);
		System.out.println(lastname1);
		System.out.println(dob1);
		System.out.println(gender1);
		System.out.println(email1);
		System.out.println(phone1);
		System.out.println(address1);
		System.out.println(city1);
		System.out.println(state1);
		System.out.println(zipfinal);
		System.out.println(department1);
		System.out.println(designation1);
		System.out.println(doj1);
		System.out.println(salaryfinal);

		// Prepare response writer to send output back to client
		PrintWriter out = response.getWriter();

		// Print all received values in <h1> tags on the response page
		out.print("<h3>" + empidfinal + "</h3>");
		out.print("<h3>" + firstname1 + "</h3>");
		out.print("<h3>" + lastname1 + "</h3>");
		out.print("<h3>" + dob1 + "</h3>");
		out.print("<h3>" + gender1 + "</h3>");
		out.print("<h3>" + email1 + "</h3>");
		out.print("<h3>" + phone1 + "</h3>");
		out.print("<h3>" + address1 + "</h3>");
		out.print("<h3>" + city1 + "</h3>");
		out.print("<h3>" + state1 + "</h3>");
		out.print("<h3>" + zipfinal + "</h3>");
		out.print("<h3>" + department1 + "</h3>");
		out.print("<h3>" + designation1 + "</h3>");
		out.print("<h3>" + doj1 + "</h3>");
		out.print("<h3>" + salaryfinal + "</h3>");

		try {
			// Load MySQL JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Establish connection to database "company"
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?useSSL=false", "root",
					"ROOT");

			// Prepare SQL insert statement with placeholders 
			PreparedStatement ps = c.prepareStatement("INSERT INTO employee "
					+ "(EmpId, FirstName, LastName, DOB, Gender, Email, Phone_Number, Address, City, State, Zip_Code, Department, Designation, DOJ, Salary) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			// Set values for each placeholder in prepared statement
			ps.setInt(1, empidfinal);
			ps.setString(2, firstname1);
			ps.setString(3, lastname1);
			ps.setString(4, dob1);
			ps.setString(5, gender1);
			ps.setString(6, email1);
			ps.setString(7, phone1);
			ps.setString(8, address1);
			ps.setString(9, city1);
			ps.setString(10, state1);
			ps.setInt(11, zipfinal);
			ps.setString(12, department1);
			ps.setString(13, designation1);
			ps.setString(14, doj1);
			ps.setLong(15, salaryfinal);

			// Execute the insert operation and get the result count
			int result = ps.executeUpdate();

			// Check if insert was successful and respond accordingly
			if (result > 0) {
				out.println("<h2 style='color:green;'>Employee Registered Successfully!</h2>");
			} else {
				out.println("<h2 style='color:red;'>Failed to Register Employee.</h2>");
			}

		} catch (ClassNotFoundException e) {
			// Handle error if JDBC driver class is not found
			e.printStackTrace();
			out.println("<h2 style='color:red;'>Error: " + e.getMessage() + "</h2>");
		} catch (SQLException e) {
			// Handle any SQL errors
			e.printStackTrace();
			out.println("<h2 style='color:red;'>SQL Error: " + e.getMessage() + "</h2>");
		} finally {
			out.close(); // Close the PrintWriter resource
		}
	}
}
