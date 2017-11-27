package pl.coderslab.models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
@Transactional
public class WordGroupDao {
	@PersistenceContext
	EntityManager entityManager;
	
	public void save(WordGroup entity) {
		entityManager.persist(entity);
	}

	public void update(WordGroup entity) {
		entityManager.merge(entity);
	}

	public void delete(WordGroup entity) {
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
	}

	public WordGroup findById(Long id) {
		return entityManager.find(WordGroup.class, id);
	}
	
	public List<WordGroup> getList(){
		Query query = entityManager.createQuery("SELECT w FROM WordGroup w");
		List<WordGroup> wordGroups = query.getResultList();
		return wordGroups;
	}

}
