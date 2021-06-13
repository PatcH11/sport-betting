package com.company.betting.data.dto.get;

import java.util.Objects;

public class ScoreGetDto {

    private Integer id;
    private Integer homeScore;
    private Integer awayScore;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
        ScoreGetDto that = (ScoreGetDto) o;
        return Objects.equals(id, that.id) && Objects.equals(homeScore, that.homeScore) && Objects.equals(awayScore, that.awayScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, homeScore, awayScore);
    }

    @Override
    public String toString() {
        return "ScoreGetDto{" +
                "id=" + id +
                ", homeScore=" + homeScore +
                ", awayScore=" + awayScore +
                '}';
    }
}
