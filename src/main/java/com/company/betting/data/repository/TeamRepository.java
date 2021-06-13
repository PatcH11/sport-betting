package com.company.betting.data.repository;

import com.company.betting.data.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для команд.
 *
 * @author Николай Евсюков
 */
@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

    /**
     * Поиск команды по ее названию.
     *
     * @param name название команды
     * @return найденная команда
     */
    Team findByName(String name);
}
