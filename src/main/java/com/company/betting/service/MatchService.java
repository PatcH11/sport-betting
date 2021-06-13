package com.company.betting.service;

import com.company.betting.data.entity.Match;

import java.util.List;

public interface MatchService {

    /**
     * Возвращение списка матчей.
     *
     * @return список матчей
     */
    List<Match> getMatches();

    /**
     * Поиск матча по ID команды.
     *
     * @param homeId ID домашней команды
     * @param awayId ID гостевой команды
     * @return найденный матч
     */
    Match findByHomeIdOrAwayId(int homeId, int awayId);

    /**
     * Сыграть все матчи.
     *
     * @param matches список матчей, которые необходимо сыграть
     */
    void playMatches(List<Match> matches);
}
