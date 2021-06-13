package com.company.betting.service.impl;

import com.company.betting.data.entity.Team;
import com.company.betting.data.repository.TeamRepository;
import com.company.betting.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {

    /**
     * Репозиторий для команды.
     */
    private final TeamRepository teamRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Team findById(int id) {
        return teamRepository.findById(id).get();
    }
}
