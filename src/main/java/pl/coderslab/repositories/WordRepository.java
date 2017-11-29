package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.models.Word;

public interface WordRepository extends JpaRepository <Word, Long> {

}
