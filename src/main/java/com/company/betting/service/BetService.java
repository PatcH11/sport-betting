package com.company.betting.service;

import com.company.betting.data.dto.create.BetCreateDto;
import com.company.betting.data.dto.get.BetGetDto;
import com.company.betting.data.dto.get.UserGetDto;

import java.util.List;

public interface BetService {


    /**
     * Создание ставки.
     *
     * @param bet ставка
     * @return сделанная ставка
     */
    BetGetDto create(BetCreateDto bet);

    /**
     * Возвращение списка ставок по username пользователя.
     *
     * @param user пользователь
     * @return список ставок
     */
    List<BetGetDto> getAllBetsByUserId(UserGetDto user);
}
