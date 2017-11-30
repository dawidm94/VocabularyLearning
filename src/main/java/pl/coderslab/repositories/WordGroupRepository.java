package pl.coderslab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.coderslab.models.WordGroup;

public interface WordGroupRepository extends JpaRepository <WordGroup, Long> {

	@Query("Select wg from WordGroup wg where wg.ifBasicGroup =''")
	List<WordGroup> findByNoBasicWordGroup();
}

