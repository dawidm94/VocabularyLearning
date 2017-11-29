package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.models.Probability;

public interface ProbabilityRepository extends JpaRepository <Probability, Long> {

}
