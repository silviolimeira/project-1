package com.example.demo;

import com.example.demo.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	
	public void init() {
		userDAO = new UserDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
				case "/new":
					showNewForm(request, response);
					break;
				case "/insert":
					insertUser(request, response);
					break;
				case "/list":
					System.out.println("Case list hit");
					listUser(request, response);
					break;
				case "/home":
					System.out.println("home hit");
					goBackToHomePage(request, response);
					break;
				case "/findEmp":
					System.out.println("findEmp hit");
					findEmployee(request, response);
					break;
				case "/editEmp":
					System.out.println("editEmp hit");
					editEmployee(request, response);
					break;
				case "/delete":
					System.out.println("deleteEmp hit");
					deleteEmployee(request, response);
					break;
				case "/doDelete":
					doDeleteEmployee(request, response);
					break;
				default:
					goBackToHomePage(request, response);
					//listUser(request, response);
					break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void doDeleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int id = Integer.parseInt(request.getParameter("empId"));
		System.out.println(id);
		User existingUser = userDAO.selectUser(id);
		if (existingUser == null) {
			request.setAttribute("status", false);
			RequestDispatcher dispatcher = request.getRequestDispatcher("status.jsp");
			dispatcher.forward(request, response);
		}
		else{
			Boolean status = userDAO.deleteUser(existingUser.getId());
			request.setAttribute("status", status);
			RequestDispatcher dispatcher = request.getRequestDispatcher("status.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("find-emp.jsp");
		request.setAttribute("delete",true);
		dispatcher.forward(request, response);
	}

	private void editEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		String name = request.getParameter("name");
		String salary = request.getParameter("salary");
		String address = request.getParameter("address");
		String department = request.getParameter("department");
		System.out.println(department);
		String phone = request.getParameter("phone");
		int id = Integer.parseInt(request.getParameter("empId"));
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setSalary(Double.parseDouble(salary));
		user.setDepartment(department);
		user.setAddress(address);
		user.setPhoneNo(phone);
		boolean status = userDAO.updateUser(user);
		request.setAttribute("status", status);
		RequestDispatcher dispatcher = request.getRequestDispatcher("status.jsp");
		dispatcher.forward(request, response);
	}

	private void findEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int id = Integer.parseInt(request.getParameter("empId"));
		System.out.println(id);
		User existingUser = userDAO.selectUser(id);
		if (existingUser == null) {
			request.setAttribute("status", false);
			RequestDispatcher dispatcher = request.getRequestDispatcher("status.jsp");
			dispatcher.forward(request, response);
		}
		else{
			if(request.getAttribute("delete") == "true"){
				userDAO.deleteUser(existingUser.getId());
			}
			request.setAttribute("user", existingUser);
			RequestDispatcher dispatcher = request.getRequestDispatcher("edit-employee.jsp");
			dispatcher.forward(request, response);
		}

	}

	private void goBackToHomePage(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listUser = userDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		try {
			String name = request.getParameter("name");
			String salary = request.getParameter("salary");
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			String department = request.getParameter("department");
			User newUser = new User();
			newUser.setName(name);
			newUser.setSalary(Double.parseDouble(salary));
			newUser.setDepartment(department);
			newUser.setAddress(address);
			newUser.setPhoneNo(phone);
			boolean status = userDAO.insertUser(newUser);
			request.setAttribute("status", status);
			RequestDispatcher dispatcher = request.getRequestDispatcher("status.jsp");
			dispatcher.forward(request, response);
		}
		catch (Exception e){
			request.setAttribute("status", false);
			RequestDispatcher dispatcher = request.getRequestDispatcher("status.jsp");
			dispatcher.forward(request, response);
		}
	}

}