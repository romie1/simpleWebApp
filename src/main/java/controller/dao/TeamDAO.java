package controller.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import onetoone.model.Team;

public class TeamDAO {
	static final Logger LOG = LoggerFactory.getLogger(TeamDAO.class);
	EntityManager entityManager;

	public TeamDAO() {
		this.entityManager = HibUtil.getEntityManager();
	}

	public List<Team> getAll() {
		try {
			return entityManager.createQuery("SELECT t FROM Team t", Team.class).getResultList();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}

	public Optional<Team> get(int id) {
		try {
			Team team = entityManager.find(Team.class, id);
			System.out.println(team.toString());
			return Optional.ofNullable(team);
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}

	public boolean create2(Team team) {
		try {
			return executeInsideTransaction(entityManager -> entityManager.persist(team));
		} catch (Exception e) {
			LOG.warn("Can't persist team", e);
			return false;
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}

	public boolean update(Team team) {

		try {
			return executeInsideTransaction(entityManager -> entityManager.merge(team));
		} catch (Exception ex) {
			return false;
		} finally {
			entityManager.close();
		}
	}

	public boolean delete(int id) {
		try {
			Team team = entityManager.find(Team.class, id);
			if (team != null) {
				return executeInsideTransaction(entityManager -> entityManager.remove(team));
			} else {
				return false;
			}
		} catch (Exception ex) {
			return false;
		} finally {
			entityManager.close();
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

	private boolean executeInsideTransaction(Consumer<EntityManager> action) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			action.accept(entityManager);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			entityTransaction.rollback();
			throw e;
		}
	}
}
