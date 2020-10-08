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

import controller.dao.TeamDAO;
import model.Team;

/**
 * Servlet implementation class TeamSingleSrv
 */
@WebServlet("/team")
public class TeamSingleSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(TeamSingleSrv.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOG.debug("Enter TeamSingleSrv Servlet");
		
		TeamDAO dao = new TeamDAO();
		
		try {
			String parameter = request.getParameter("id");
			Optional<Team> team = dao.get(Integer.parseInt(parameter));
			if (team.isPresent()) {
				request.setAttribute("team", team.get());
				request.getRequestDispatcher("/team/team.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/index.html").forward(request, response);
			}
		} catch (NumberFormatException e) {
			request.getRequestDispatcher("/index.html").forward(request, response);
		}
	}

}
