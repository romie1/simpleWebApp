package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.dao.TeamDAO;
import model.Team;

/**
 * Servlet implementation class TeamCreationSrv
 */
@WebServlet("/team/new")
public class TeamCreationSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		
		Team team = new Team();
		team.setName(name);
		
		TeamDAO dao = new TeamDAO();
		if(dao.create(team)) {
			System.out.println("********created team" + team.toString());
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
