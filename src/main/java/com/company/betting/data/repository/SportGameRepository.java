package com.company.betting.data.repository;

import com.company.betting.data.entity.SportGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для вида спортивной игры
 *
 * @author Николай Евсюков.
 */
@Repository
public interface SportGameRepository extends JpaRepository<SportGame, Integer> {
}
