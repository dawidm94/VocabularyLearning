package pl.coderslab.models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
@Transactional
public class UserDao {
	@PersistenceContext
	EntityManager entityManager;
	
	public void save(User entity) {
		entityManager.persist(entity);
	}

	public void update(User entity) {
		entityManager.merge(entity);
	}

	public void delete(User entity) {
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
	}

	public User findById(Long id) {
		return entityManager.find(User.class, id);
	}
	
	public List<User> getList(){
		Query query = entityManager.createQuery("SELECT u FROM User u");
		List<User> users = query.getResultList();
		return users;
	}
}
