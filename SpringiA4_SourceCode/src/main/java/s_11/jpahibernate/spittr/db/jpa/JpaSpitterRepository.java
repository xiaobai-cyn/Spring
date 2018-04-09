package s_11.jpahibernate.spittr.db.jpa;

import org.springframework.stereotype.Repository;
import s_11.jpahibernate.spittr.db.SpitterRepository;
import s_11.jpahibernate.spittr.domain.Spitter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaSpitterRepository implements SpitterRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public long count() {
		return findAll().size();
	}

	public Spitter save(Spitter spitter) {
		entityManager.persist(spitter);
		return spitter;
	}

	public Spitter findOne(long id) {
		return entityManager.find(Spitter.class, id);
	}

	public Spitter findByUsername(String username) {		
		return (Spitter) entityManager.createQuery("select s from Spitter s where s.username=?").setParameter(1, username).getSingleResult();
	}

	public List<Spitter> findAll() {
		return (List<Spitter>) entityManager.createQuery("select s from Spitter s").getResultList();
	}
	
}
