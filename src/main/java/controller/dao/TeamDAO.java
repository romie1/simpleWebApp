package controller.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Coder;
import model.Team;

public class TeamDAO {

	public List<Team> getAll() {
		EntityManager em = HibUtil.getEntityManager();
		try {
			return em.createQuery("SELECT t FROM Team t", Team.class).getResultList();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}
	
	public Optional<Team> get(int id){
		EntityManager em = HibUtil.getEntityManager();
		try {
			return Optional.ofNullable(em.find(Team.class, id));
		}finally {
			if (em != null) {
				em.close();
			}
		}
	}
	
	public boolean create(Team team) {
		EntityManager em = HibUtil.getEntityManager();
		try {
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(team);
			et.commit();
			return true;
		} catch (Exception ex) {
			return false;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}
	

}
