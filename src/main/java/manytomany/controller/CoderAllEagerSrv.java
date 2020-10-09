package manytomany.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.dao.CoderDAO;
import manytomany.model.Coder;

/**
 * Servlet implementation class CoderAllEagerSrv
 */
@WebServlet("/coder/allEager")
public class CoderAllEagerSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CoderDAO dao = new CoderDAO();
		List<Coder> coders = dao.readAllEager();
		request.setAttribute("coderListEager", coders);
        request.getRequestDispatcher("/coder/allEager.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
