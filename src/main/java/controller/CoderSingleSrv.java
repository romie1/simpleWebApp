package controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.dao.CoderDAO;
import model.Coder;

/**
 * Servlet implementation class CoderSingleSrv
 */
@WebServlet("/coder")
public class CoderSingleSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(CoderSingleSrv.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOG.debug("Enter CoderSingleSrv Servlet");
		
		CoderDAO dao = new CoderDAO();
		
		try {
			String parameter = request.getParameter("id");
			Optional<Coder> coder = dao.get(Integer.parseInt(parameter));
			if (coder.isPresent()) {
				request.setAttribute("coder", coder.get());
				request.getRequestDispatcher("/coder/single.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/index.html").forward(request, response);
			}
		} catch (NumberFormatException e) {
			request.getRequestDispatcher("/index.html").forward(request, response);
		}
	}

}
