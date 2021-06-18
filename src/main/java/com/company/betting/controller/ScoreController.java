package com.company.betting.controller;

import com.company.betting.data.dto.get.ScoreGetDto;
import com.company.betting.service.ScoreService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(
        path = "/api/score",
        consumes = MediaType.APPLICATION_JSON_VALUE
)
public class ScoreController {

    private final ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @PostMapping
    public List<ScoreGetDto> getAllScores() {
        return scoreService.getScores();
    }
}
