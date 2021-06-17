package com.company.betting.controller;

import com.company.betting.data.dto.create.UserCreateDto;
import com.company.betting.data.dto.get.UserGetDto;
import com.company.betting.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(
        path = "/api/user",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserGetDto createUser(@RequestBody UserCreateDto user) throws IOException {
        return userService.create(user);
    }
}
