package com.company.betting.controller;

import com.company.betting.data.dto.get.MatchDontPlayDto;
import com.company.betting.data.dto.get.MatchGetDto;
import com.company.betting.service.MatchService;
import com.company.betting.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(
        path = "/api/match",
        consumes = MediaType.APPLICATION_JSON_VALUE
)
public class MatchController {

    private final MatchService matchService;
    private final ScoreService scoreService;

    @Autowired
    public MatchController(MatchService matchService,
                           ScoreService scoreService) {
        this.matchService = matchService;
        this.scoreService = scoreService;
    }

    @PostMapping
    public List<MatchGetDto> getAllMatches() {
        return matchService.getMatches();
    }

    @PostMapping("/play")
    public void playMatches() {
        matchService.playMatches();
    }

    @PostMapping("/dont-play")
    public List<MatchDontPlayDto> getDontPlayMatches() {
        return matchService.getDontPlayMatches();
    }
}
