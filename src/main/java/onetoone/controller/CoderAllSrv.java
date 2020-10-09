package onetoone.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.dao.CoderDAO;
import onetoone.model.Coder;

/**
 * Get all coders
 */
@WebServlet("/coder/all")
public class CoderAllSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(CoderAllSrv.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CoderDAO dao = new CoderDAO();
		List<Coder> coders = dao.getAll();
		LOG.debug("Coders: " + coders);
		request.setAttribute("coders", coders);
		
		request.getRequestDispatcher("/coder/all.jsp").forward(request, response);
	}

}
