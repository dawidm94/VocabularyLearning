package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.models.WordGroup;

public interface WordGroupRepository extends JpaRepository <WordGroup, Long> {

}
