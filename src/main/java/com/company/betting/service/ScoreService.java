package com.company.betting.service;

import com.company.betting.data.dto.get.ScoreGetDto;

import java.util.List;

public interface ScoreService {

    /**
     * Вернуть список всех счетов.
     *
     * @return список всех счетов
     */
    List<ScoreGetDto> getScores();
}
