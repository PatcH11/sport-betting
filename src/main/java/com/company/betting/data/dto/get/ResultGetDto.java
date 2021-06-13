package com.company.betting.data.dto.get;

import java.util.Objects;

public class ResultGetDto {

    private Integer id;
    private MatchGetDto match;
    private ScoreGetDto score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MatchGetDto getMatch() {
        return match;
    }

    public void setMatch(MatchGetDto match) {
        this.match = match;
    }

    public ScoreGetDto getScore() {
        return score;
    }

    public void setScore(ScoreGetDto score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultGetDto that = (ResultGetDto) o;
        return Objects.equals(id, that.id) && Objects.equals(match, that.match) && Objects.equals(score, that.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, match, score);
    }

    @Override
    public String toString() {
        return "ResultGetDto{" +
                "id=" + id +
                ", match=" + match +
                ", score=" + score +
                '}';
    }
}
