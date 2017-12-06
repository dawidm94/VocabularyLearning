package pl.coderslab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.coderslab.entities.WordGroup;

public interface WordGroupRepository extends JpaRepository <WordGroup, Long> {

	@Query("Select wg from WordGroup wg where wg.ifBasicGroup ='' order by lastUpdate desc")
	List<WordGroup> findByNoBasicWordGroupOrderByLastUpdate();
	
	@Query("Select wg from WordGroup wg where wg.ifBasicGroup ='' and wg.user.id=:userId")
	List<WordGroup> findNoBasicWordGroupByUserId(@Param("userId") long userId);
}

