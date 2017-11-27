package pl.coderslab.models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
@Transactional
public class WordDao {
	@PersistenceContext
	EntityManager entityManager;
	
	public void save(Word entity) {
		entityManager.persist(entity);
	}

	public void update(Word entity) {
		entityManager.merge(entity);
	}

	public void delete(Word entity) {
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
	}

	public Word findById(Long id) {
		return entityManager.find(Word.class, id);
	}

	public List<Word> getList(){
		Query query = entityManager.createQuery("SELECT w FROM Word w");
		List<Word> words = query.getResultList();
		return words;
	}
}
