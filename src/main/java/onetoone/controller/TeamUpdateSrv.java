package onetoone.controller;

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
import onetoone.model.Team;

/**
 * Servlet implementation class TeamUpdateSrv
 */
@WebServlet("/team/update")
public class TeamUpdateSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger LOG = LoggerFactory.getLogger(TeamUpdateSrv.class);
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.debug("Enter TeamUpdateSrv Servlet");
		TeamDAO dao = new TeamDAO();
		
		try {
			String parameter = request.getParameter("id");
			String name = request.getParameter("name");
            Optional<Team> teamOpt = dao.get(Integer.parseInt(parameter));;
            if (name == null || name.isBlank() || parameter.isBlank() || !teamOpt.isPresent()) {
                request.setAttribute("fail", true);
            }else {
            	Team team = teamOpt.get();
            	team.setName(name);
            	team.setLeader(null);
            	dao.update(team);
            	request.setAttribute("team", team);
            }
		} catch (NumberFormatException e) {
			request.setAttribute("fail", true);
		}
		
		request.getRequestDispatcher("/team/updateTeam.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
