package com.company.betting.service;

import com.company.betting.data.entity.Score;

import java.util.List;

public interface ScoreService {

    /**
     * Вернуть список всех счетов.
     *
     * @return список всех счетов
     */
    List<Score> getScores();
}
