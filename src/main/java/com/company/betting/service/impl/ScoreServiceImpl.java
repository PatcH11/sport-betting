package com.company.betting.service.impl;

import com.company.betting.data.dto.get.ScoreGetDto;
import com.company.betting.data.mapper.ScoreMapper;
import com.company.betting.data.repository.ScoreRepository;
import com.company.betting.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    private final ScoreMapper scoreMapper;
    private final ScoreRepository scoreRepository;

    @Autowired
    public ScoreServiceImpl(ScoreRepository scoreRepository,
                            ScoreMapper scoreMapper) {
        this.scoreRepository = scoreRepository;
        this.scoreMapper = scoreMapper;
    }

    @Override
    public List<ScoreGetDto> getScores() {
        return scoreMapper.toGetDto(scoreRepository.findAll());
    }
}
