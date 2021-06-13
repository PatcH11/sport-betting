package com.company.betting.data.dto.create;

import java.util.Objects;

public class ScoreCreateDto {

    private Integer homeScore;
    private Integer awayScore;

    public Integer getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(Integer homeScore) {
        this.homeScore = homeScore;
    }

    public Integer getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(Integer awayScore) {
        this.awayScore = awayScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreCreateDto that = (ScoreCreateDto) o;
        return Objects.equals(homeScore, that.homeScore) && Objects.equals(awayScore, that.awayScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeScore, awayScore);
    }

    @Override
    public String toString() {
        return "ScoreCreateDto{" +
                "homeScore=" + homeScore +
                ", awayScore=" + awayScore +
                '}';
    }
}
