package pl.coderslab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.coderslab.entities.History;

public interface HistoryRepository extends JpaRepository <History, Long> {
	
	@Query(value = "select * from history where user_id =:userId order by solveDate desc limit 10", nativeQuery = true)
	List<History> findLast10ByUserId(@Param("userId") long userId);
	
}
