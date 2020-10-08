package controller.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Coder;

public class CoderDAO {
	static final Logger LOG = LoggerFactory.getLogger(CoderDAO.class);

	public List<Coder> getAll() {
		EntityManager em = HibUtil.getEntityManager();
		try {
			LOG.trace("enter getAll method");
			return em.createQuery("SELECT c FROM Coder c", Coder.class).getResultList();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public Optional<Coder> get(int id) {
		EntityManager em = HibUtil.getEntityManager();
		try {
			LOG.trace("enter get method");
			return Optional.ofNullable(em.find(Coder.class, id));
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public boolean create(Coder coder) {
		EntityManager em = HibUtil.getEntityManager();
		try {
			LOG.trace("enter create method");
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(coder);
			et.commit();
			return true;
		} catch (Exception ex) {
			LOG.warn("Can't persist coder", ex);
			return false;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

}
