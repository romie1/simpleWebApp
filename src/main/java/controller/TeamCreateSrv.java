package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.dao.CoderDAO;
import controller.dao.TeamDAO;
import model.Team;

/**
 * Servlet implementation class TeamCreationSrv
 */
@WebServlet("/team/new")
public class TeamCreateSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeamDAO dao = new TeamDAO();
		CoderDAO coderDao = new CoderDAO();
		String name = request.getParameter("name");
		String leaderId = request.getParameter("leaderId");
		
		Team team = new Team();
		team.setName(name);
		team.setLeader(coderDao.get(Integer.parseInt(leaderId)).get());
			
		if(dao.create(team)) {
			request.setAttribute("team", team);			
		}else {
			request.setAttribute("fail", true);
		}
		request.getRequestDispatcher("/team/newTeam.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
