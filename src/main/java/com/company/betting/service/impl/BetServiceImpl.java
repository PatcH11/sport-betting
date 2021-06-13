package com.company.betting.service.impl;

import com.company.betting.data.entity.Bet;
import com.company.betting.data.repository.BetRepository;
import com.company.betting.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BetServiceImpl implements BetService {

    /**
     * Репозиторий для ставок.
     */
    private final BetRepository betRepository;

    @Autowired
    public BetServiceImpl(BetRepository betRepository) {
        this.betRepository = betRepository;
    }

    @Override
    public Bet create(Bet bet) {
        return betRepository.save(bet);
    }

    @Override
    public List<Bet> getAllByUserUsername(String username) {
        return betRepository.getAllByUserUsername(username);
    }
}
