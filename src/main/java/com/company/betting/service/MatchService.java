package com.company.betting.service;

import com.company.betting.data.dto.get.MatchDontPlayDto;
import com.company.betting.data.dto.get.MatchGetDto;
import com.company.betting.data.entity.Match;

import java.util.List;

public interface MatchService {

    List<MatchDontPlayDto> getDontPlayMatches();

    /**
     * Возвращение списка матчей.
     *
     * @return список матчей
     */
    List<MatchGetDto> getMatches();

    /**
     * Поиск матча по ID команды.
     *
     * @param homeId ID домашней команды
     * @param awayId ID гостевой команды
     * @return найденный матч
     */
    MatchGetDto findByHomeIdOrAwayId(int homeId, int awayId);

    /**
     * Сыграть все матчи.
     *
     */
    void playMatches();

    Match findById(int matchId);
}
