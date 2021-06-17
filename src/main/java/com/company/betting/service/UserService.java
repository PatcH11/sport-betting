package com.company.betting.service;

import com.company.betting.data.dto.create.UserCreateDto;
import com.company.betting.data.dto.get.UserGetDto;
import com.company.betting.data.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserService {

    /**
     * Создание пользователя.
     *
     * @param user пользователь
     * @return созданный пользователь
     */
    UserGetDto create(UserCreateDto user) throws IOException;

    /**
     * Поиск пользователя по его нику.
     *
     * @param username ник пользователя
     * @return найденный пользователь
     */
    UserGetDto findByUsername(String username);

    User findById(int userId);
}
