package com.company.betting.data.dto.create;

import java.util.Objects;

public class ResultCreateDto {

    private Integer matchId;
    private Integer scoreId;

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public Integer getScoreId() {
        return scoreId;
    }

    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultCreateDto that = (ResultCreateDto) o;
        return Objects.equals(matchId, that.matchId) && Objects.equals(scoreId, that.scoreId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchId, scoreId);
    }

    @Override
    public String toString() {
        return "ResultCreateDto{" +
                "matchId=" + matchId +
                ", scoreId=" + scoreId +
                '}';
    }
}
