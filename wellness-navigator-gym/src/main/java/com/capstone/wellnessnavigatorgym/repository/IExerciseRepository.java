package com.capstone.wellnessnavigatorgym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IExerciseRepository extends JpaRepository<Exception, Integer> {
}
