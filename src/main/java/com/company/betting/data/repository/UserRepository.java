package com.company.betting.data.repository;

import com.company.betting.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для пользователя.
 *
 * @author Николай Евсюков
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * Поиск пользователя по его нику.
     *
     * @param username ник пользователя
     * @return найденный пользователь
     */
    User findByUsername(String username);
}
