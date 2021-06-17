package com.company.betting.controller;

import com.company.betting.data.dto.create.BetCreateDto;
import com.company.betting.data.dto.get.BetGetDto;
import com.company.betting.data.dto.get.UserGetDto;
import com.company.betting.service.BetService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(
        path = "api/bet",
        consumes = MediaType.APPLICATION_JSON_VALUE
)
public class BetController {

    private final BetService betService;

    public BetController(BetService betService) {
        this.betService = betService;
    }

    @PostMapping("/create")
    public BetGetDto createBet(@RequestBody BetCreateDto betCreateDto) {
        return betService.create(betCreateDto);
    }

    @PostMapping
    public List<BetGetDto> getAllUserBets(@RequestBody UserGetDto user) {
        return betService.getAllBetsByUserId(user);
    }
}
