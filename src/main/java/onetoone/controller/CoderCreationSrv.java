package onetoone.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.dao.CoderDAO;
import onetoone.model.Coder;

/**
 * Servlet implementation class CoderCreation
 */
@WebServlet("/coder/new")
public class CoderCreationSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//da id 222
		String id = request.getParameter("id");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String salary = request.getParameter("salary");
		
		Coder coder = new Coder();
		coder.setId(Integer.parseInt(id));
		coder.setFirstName(firstName);
		coder.setLastName(lastName);
		coder.setHireDate(LocalDate.now());
		coder.setSalary(Double.parseDouble(salary));
		
		CoderDAO dao = new CoderDAO();
		//se lo ha creato, restituisce true
		if(dao.create(coder)){
			request.setAttribute("coder", coder);			
		}else {
			request.setAttribute("fail", true);
		}
		request.getRequestDispatcher("/coder/new.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
