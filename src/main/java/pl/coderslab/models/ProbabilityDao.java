package pl.coderslab.models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
@Transactional
public class ProbabilityDao {
	@PersistenceContext
	EntityManager entityManager;
	
	public void save(Probability entity) {
		entityManager.persist(entity);
	}

	public void update(Probability entity) {
		entityManager.merge(entity);
	}

	public void delete(Probability entity) {
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
	}

	public Probability findById(Long id) {
		return entityManager.find(Probability.class, id);
	}
	
	public List<Probability> getList(){
		Query query = entityManager.createQuery("SELECT p FROM Probability p");
		List<Probability> probabilities = query.getResultList();
		return probabilities;
	}
}
