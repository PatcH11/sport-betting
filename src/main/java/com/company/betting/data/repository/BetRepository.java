package com.company.betting.data.repository;

import com.company.betting.data.entity.Bet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Репозиторий для ставок.
 *
 * @author Николай Евсюков
 */
@Repository
public interface BetRepository extends JpaRepository<Bet, Integer> {

    List<Bet> getAllByUserUsername(String username);

    List<Bet> getAllByUserId(int userId);
}
