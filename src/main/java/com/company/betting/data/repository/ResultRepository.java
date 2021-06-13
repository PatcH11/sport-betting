package com.company.betting.data.repository;

import com.company.betting.data.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для результата матча.
 *
 * @author Николай Евсюков
 */
@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {
}
