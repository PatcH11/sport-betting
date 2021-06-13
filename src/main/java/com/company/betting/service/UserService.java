package com.company.betting.service;

import com.company.betting.data.entity.User;

public interface UserService {

    /**
     * Создание пользователя.
     *
     * @param user пользователь
     * @return созданный пользователь
     */
    User create(User user);

    /**
     * Поиск пользователя по его нику.
     *
     * @param username ник пользователя
     * @return найденный пользователь
     */
    User findByUsername(String username);
}
