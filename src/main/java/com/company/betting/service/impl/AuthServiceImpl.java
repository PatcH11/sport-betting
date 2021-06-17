package com.company.betting.service.impl;

import com.company.betting.data.dto.AuthUserDto;
import com.company.betting.data.dto.get.UserGetDto;
import com.company.betting.service.AuthService;
import com.company.betting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(UserService userService,
                           PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean login(AuthUserDto user) {
        UserGetDto foundUser = userService.findByUsername(user.getUsername());

        return passwordEncoder.matches(user.getPassword(), foundUser.getPassword());
    }

    @Override
    public UserGetDto getCurrentUser(HttpServletRequest request) {
        String authToken = request
                .getHeader("Authorization")
                .substring("Basic".length())
                .trim();
        String username = new String(Base64.getDecoder().decode(authToken)).split(":", 2)[0];

        return userService.findByUsername(username);
    }
}
