package com.company.betting.data.repository;

import com.company.betting.data.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для картинок.
 *
 * @author Николай Евсюков
 */
@Repository
public interface PictureRepository extends JpaRepository<Picture, Integer> {

    /**
     * Поиск картинки по ее названию.
     *
     * @param name название картинки
     * @return найденная картинка
     */
    Picture findByName(String name);
}
