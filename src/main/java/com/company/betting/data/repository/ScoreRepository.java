package com.company.betting.data.repository;

import com.company.betting.data.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для счета.
 *
 * @author Николай Евсюков
 */
@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer> {
}
