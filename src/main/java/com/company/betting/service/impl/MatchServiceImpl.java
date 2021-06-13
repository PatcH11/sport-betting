package com.company.betting.service.impl;

import com.company.betting.data.entity.Match;
import com.company.betting.data.entity.Score;
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

    /**
     * Репозиторий для матчей.
     */
    private final MatchRepository matchRepository;

    /**
     * Репозиторий для счетов.
     */
    private final ScoreRepository scoreRepository;

    @Autowired
    public MatchServiceImpl(MatchRepository matchRepository,
                            ScoreRepository scoreRepository) {
        this.matchRepository = matchRepository;
        this.scoreRepository = scoreRepository;
    }

    @Override
    public List<Match> getMatches() {
        return matchRepository.findAll();
    }

    @Override
    public Match findByHomeIdOrAwayId(int homeId, int awayId) {
        return matchRepository.findByHomeIdOrAwayId(homeId, awayId);
    }

    @Override
    @Transactional
    public void playMatches(List<Match> matches) {
        for (Match match : matches) {

            Score score = new Score();

            match.setScore(score);

            matchRepository.save(match);

            score.setHomeScore(RandomNumberGenerator.generateRandomNumber(5));
            score.setAwayScore(RandomNumberGenerator.generateRandomNumber(5));

            scoreRepository.save(score);
        }
    }
}
