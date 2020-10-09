package controller.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import onetoone.model.Team;

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

	public Optional<Team> get(int id) {
		EntityManager em = HibUtil.getEntityManager();
		try {
			Team team = em.find(Team.class, id);
			System.out.println(team.toString());
			return Optional.ofNullable(team);
		} finally {
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

	public boolean update(Team team) {
		EntityManager em = HibUtil.getEntityManager();

		try {
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.merge(team);
			et.commit();
			return true;
		} catch (Exception ex) {
			return false;
		} finally {
			em.close();
		}
	}

	public boolean delete(int id) {
		EntityManager em = HibUtil.getEntityManager();

		try {
			EntityTransaction et = em.getTransaction();
			et.begin();
			Team team = em.find(Team.class, id);
			if (team != null) {
				em.remove(team);
				et.commit();
				return true;
			} else {
				et.rollback();
				return false;
			}
		} catch (Exception ex) {
			return false;
		} finally {
			em.close();
		}
	}

	public List<manytomany.model.Team> readAllEager() {
		EntityManager em = null;
		try {
			em = HibUtil.getEntityManager();
			String jpql = "SELECT DISTINCT e FROM teamManyToMany e JOIN FETCH e.coders";
			return em.createQuery(jpql, manytomany.model.Team.class).getResultList();
		} finally {
			em.close();
		}
	}
}
