package pl.coderslab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.coderslab.entities.Word;

public interface WordRepository extends JpaRepository <Word, Long> {
	
	@Query("Select w from Word w where w.wordGroup.id =:wordGroupId")
	List<Word> findByWordGroupId(@Param("wordGroupId") long id);

}
