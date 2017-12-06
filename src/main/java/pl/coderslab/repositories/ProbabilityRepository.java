package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.coderslab.entities.Probability;

public interface ProbabilityRepository extends JpaRepository <Probability, Long> {

	@Query("Select p from Probability p where p.user.id =:userId and p.word.id =:wordId")
	Probability findOneByUserIdAndWordId(@Param("userId") long userId, @Param("wordId") long wordId);
}
