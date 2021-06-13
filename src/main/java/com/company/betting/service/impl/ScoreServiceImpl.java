package com.company.betting.service.impl;

import com.company.betting.data.entity.Score;
import com.company.betting.data.repository.ScoreRepository;
import com.company.betting.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    /**
     * Репозиторий для счетов.
     */
    private final ScoreRepository scoreRepository;

    @Autowired
    public ScoreServiceImpl(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    @Override
    public List<Score> getScores() {
        return scoreRepository.findAll();
    }
}
