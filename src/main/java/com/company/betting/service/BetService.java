package com.company.betting.service;

import com.company.betting.data.entity.Bet;

import java.util.List;

public interface BetService {


    /**
     * Создание ставки.
     *
     * @param bet ставка
     * @return сделанная ставка
     */
    Bet create(Bet bet);

    /**
     * Возвращение списка ставок по username пользователя.
     *
     * @param username ник пользователя
     * @return список ставок
     */
    List<Bet> getAllByUserUsername(String username);
}
