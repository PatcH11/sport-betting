package com.company.betting.data.repository;

import com.company.betting.data.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для матчей.
 *
 * @author Николай Евсюков
 */
@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {

    /**
     * Поиск матча по ID команды.
     *
     * @param homeId ID домашней команды
     * @param awayId ID гостевой команды
     * @return найденный матч
     */
    Match findByHomeIdOrAwayId(int homeId, int awayId);
}
