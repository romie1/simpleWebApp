package onetoone.controller;

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
 * Servlet implementation class TeamAllSrv
 */
@WebServlet("/team/all")
public class TeamAllSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(TeamAllSrv.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOG.debug("Enter TeamAllSrv");
		TeamDAO dao = new TeamDAO();
		request.setAttribute("teams", dao.getAll());
		request.getRequestDispatcher("/team/teamList.jsp").forward(request, response);
	}

}
