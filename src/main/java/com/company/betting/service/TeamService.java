package com.company.betting.service;

import com.company.betting.data.entity.Team;

public interface TeamService {

    /**
     * Поиск команды по ее ID.
     *
     * @param id ID команды
     * @return найденная команда
     */
    Team findById(int id);
}
