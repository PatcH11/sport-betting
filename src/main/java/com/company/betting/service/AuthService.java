package com.company.betting.service;

import com.company.betting.data.dto.AuthUserDto;
import com.company.betting.data.dto.get.UserGetDto;

import javax.servlet.http.HttpServletRequest;

public interface AuthService {

    boolean login(AuthUserDto user);

    UserGetDto getCurrentUser(HttpServletRequest request);
}
