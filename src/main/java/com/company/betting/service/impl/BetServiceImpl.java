package com.company.betting.service.impl;

import com.company.betting.data.dto.create.BetCreateDto;
import com.company.betting.data.dto.get.BetGetDto;
import com.company.betting.data.dto.get.UserGetDto;
import com.company.betting.data.mapper.BetMapper;
import com.company.betting.data.repository.BetRepository;
import com.company.betting.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BetServiceImpl implements BetService {

    private final BetMapper betMapper;
    private final BetRepository betRepository;

    @Autowired
    public BetServiceImpl(BetRepository betRepository,
                          BetMapper betMapper) {
        this.betRepository = betRepository;
        this.betMapper = betMapper;
    }

    @Override
    public BetGetDto create(BetCreateDto bet) {
        return betMapper.toGetDto(betRepository.save(betMapper.fromCreateDto(bet)));
    }

    @Override
    public List<BetGetDto> getAllBetsByUserId(UserGetDto user) {
        return betMapper.toGetDto(betRepository.getAllByUserId(user.getId()));
    }
}
