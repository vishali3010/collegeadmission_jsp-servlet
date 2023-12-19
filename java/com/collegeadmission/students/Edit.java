package com.collegeadmission.students;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.collageadmission.dao.StudentDAO;
import com.collageadmission.exception.DAOException;
import com.collageadmission.exception.InvalidStudentException;
import com.collageadmission.model.Student;
import com.collageadmission.service.StudentService;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Edit() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String action = request.getParameter("action");

		try {
			if ("accept".equals(action)) {

				StudentService.updatingStatusOfStudent(id, "Accept");
				response.sendRedirect("ViewStudentsServlet");
			} else if ("reject".equals(action)) {

				StudentService.updatingStatusOfStudent(id, "Reject");
				response.sendRedirect("ViewStudentsServlet");
			} else {
				StudentService.updatingStatusOfStudent(id, "Cancel");
				response.sendRedirect("./history.jsp");
			}
		} catch (InvalidStudentException | DAOException e) {
			e.printStackTrace();
		}

//		try {
////			Student stu = StudentDAO.findStudentByEmail(email);
//			
//			request.setAttribute("Student", stu);
//			RequestDispatcher rd = request.getRequestDispatcher("./Update.jsp");
//			rd.forward(request, response);
//			response.getWriter().append("Sucess");
//		} catch (DAOException | InvalidStudentException | SQLException e) {
//			response.getWriter().append(e.getMessage());
//			e.printStackTrace();
//		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
