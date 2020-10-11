package controller.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import onetoone.model.Coder;

public class CoderDAO {
	static final Logger LOG = LoggerFactory.getLogger(CoderDAO.class);

	EntityManager entityManager;

	public CoderDAO() {
		this.entityManager = HibUtil.getEntityManager();
	}

	public List<Coder> getAll() {
		try {
			LOG.trace("enter getAll method");
			return entityManager.createQuery("SELECT c FROM Coder c", Coder.class).getResultList();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}

	public Optional<Coder> get(int id) {
		try {
			LOG.trace("enter get method");
			return Optional.ofNullable(entityManager.find(Coder.class, id));
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}

	public boolean create(Coder coder) {
		try {
			LOG.trace("enter create method");
			EntityTransaction et = entityManager.getTransaction();
			et.begin();
			entityManager.persist(coder);
			et.commit();
			return true;
		} catch (Exception ex) {
			LOG.warn("Can't persist coder", ex);
			return false;
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}

	public boolean create2(Coder coder) {
		try {
			return executeInsideTransaction(entityManager -> entityManager.persist(coder));
		} catch (Exception e) {
			LOG.warn("Can't persist coder", e);
			return false;
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}

	public List<manytomany.model.Coder> readAllEager() {
		try {
			String jpql = "SELECT DISTINCT e FROM coderManyToMany e JOIN FETCH e.teams";
			return entityManager.createQuery(jpql, manytomany.model.Coder.class).getResultList();
		} finally {
			entityManager.close();
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
