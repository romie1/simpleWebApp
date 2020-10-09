package manytomany.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import controller.dao.TeamDAO;
import manytomany.model.Team;

/**
 * Servlet implementation class TeamAllEager
 */
@WebServlet("/team/allEager")
public class TeamAllEagerSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static final Logger LOG = LoggerFactory.getLogger(TeamAllEagerSrv.class);
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.trace("enter TeamAllEager Servlet");
		
		TeamDAO dao = new TeamDAO();
        List<Team> teams = dao.readAllEager();
        request.setAttribute("teamListEager", teams);
        request.getRequestDispatcher("/team/teamAllEager.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
