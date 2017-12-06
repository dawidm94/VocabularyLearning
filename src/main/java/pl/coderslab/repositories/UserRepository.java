package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.entities.User;

public interface UserRepository extends JpaRepository <User, Long> {

	User findByLogin(String login);
	
}
