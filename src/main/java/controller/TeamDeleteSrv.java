package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.dao.TeamDAO;

/**
 * Servlet implementation class TeamDeleteSrv
 */
@WebServlet("/team/delete")
public class TeamDeleteSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(TeamDeleteSrv.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOG.debug("Enter teamDeleteSrv Servlet");
		TeamDAO dao = new TeamDAO();

		String parameter = request.getParameter("id");
		try {
			int id = Integer.parseInt(parameter);
			if (parameter == null || parameter.isBlank() ) {
				request.setAttribute("deleted", false);
			} 
			
			if(dao.delete(id)){
				request.setAttribute("deleted", true);
			}
			else {
				request.setAttribute("deleted", false);
			}
			
		} catch (NumberFormatException nfe) {
			request.setAttribute("deleted", false);
		}
		request.getRequestDispatcher("/team/deleteTeam.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
