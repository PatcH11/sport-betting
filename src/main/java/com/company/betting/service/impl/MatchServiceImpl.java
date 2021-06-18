package com.company.betting.service.impl;

import com.company.betting.data.dto.get.MatchDontPlayDto;
import com.company.betting.data.dto.get.MatchGetDto;
import com.company.betting.data.dto.get.ScoreGetDto;
import com.company.betting.data.entity.Match;
import com.company.betting.data.entity.Score;
import com.company.betting.data.mapper.MatchMapper;
import com.company.betting.data.mapper.ScoreMapper;
import com.company.betting.data.repository.MatchRepository;
import com.company.betting.data.repository.ScoreRepository;
import com.company.betting.service.MatchService;
import com.company.betting.util.RandomNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    private final MatchMapper matchMapper;
    private final ScoreMapper scoreMapper;
    private final ScoreRepository scoreRepository;
    private final MatchRepository matchRepository;

    @Autowired
    public MatchServiceImpl(MatchRepository matchRepository,
                            ScoreRepository scoreRepository,
                            MatchMapper matchMapper,
                            ScoreMapper scoreMapper) {
        this.matchRepository = matchRepository;
        this.scoreRepository = scoreRepository;
        this.matchMapper = matchMapper;
        this.scoreMapper = scoreMapper;
    }

    @Override
    public List<MatchDontPlayDto> getDontPlayMatches() {
        List<MatchDontPlayDto> matchDontPlayDtos = matchMapper.toMatchDontPlayDto(matchRepository.findAll());
        return matchDontPlayDtos;
    }

    @Override
    public List<MatchGetDto> getMatches() {
        return matchMapper.toGetDto(matchRepository.findAll());
    }

    @Override
    public MatchGetDto findByHomeIdOrAwayId(int homeId, int awayId) {
        return matchMapper.toGetDto(matchRepository.findByHomeIdOrAwayId(homeId, awayId));
    }

    @Override
    @Transactional
    public void playMatches() {
        List<MatchGetDto> matches = getMatches();

        for (MatchGetDto match : matches) {

            Score score = new Score();

            score.setHomeScore(RandomNumberGenerator.generateRandomNumber(5));
            score.setAwayScore(RandomNumberGenerator.generateRandomNumber(5));

            scoreRepository.save(score);

            match.setScore(scoreMapper.toGetDto(score));

            matchRepository.save(matchMapper.fromGetDto(match));
        }
    }

    @Override
    public Match findById(int matchId) {
        return matchRepository.findById(matchId).get();
    }
}
