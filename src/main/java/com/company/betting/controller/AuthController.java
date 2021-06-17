package com.company.betting.controller;

import com.company.betting.data.dto.AuthUserDto;
import com.company.betting.data.dto.get.UserGetDto;
import com.company.betting.service.AuthService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(
        path = "api/auth",
        consumes = MediaType.APPLICATION_JSON_VALUE
)
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public boolean login(@RequestBody AuthUserDto user) {
        return authService.login(user);
    }

    @PostMapping("/current-user")
    public UserGetDto getCurrentUser(HttpServletRequest request) {
        return authService.getCurrentUser(request);
    }
}
