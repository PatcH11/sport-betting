package com.company.betting.util;

/**
 * Генерация случайных чисел.
 *
 * @author Николай Евсюков
 */
public class RandomNumberGenerator {

    /**
     * Генерация случайных числе в промежутке от 0 до max.
     *
     * @param max максимальное число
     * @return случайное число в промежутке от 0 до max
     */
    public static int generateRandomNumber(int max) {
        return (int) (Math.random() * ++max);
    }
}
