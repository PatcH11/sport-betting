package com.company.betting.data.dto.create;

import java.util.Objects;

public class BetCreateDto {

    private Integer userId;
    private Integer matchId;
    private Integer teamWinnerId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public Integer getTeamWinnerId() {
        return teamWinnerId;
    }

    public void setTeamWinnerId(Integer teamWinnerId) {
        this.teamWinnerId = teamWinnerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BetCreateDto that = (BetCreateDto) o;
        return Objects.equals(userId, that.userId) && Objects.equals(matchId, that.matchId) && Objects.equals(teamWinnerId, that.teamWinnerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, matchId, teamWinnerId);
    }

    @Override
    public String toString() {
        return "BetCreateDto{" +
                "userId=" + userId +
                ", matchId=" + matchId +
                ", teamWinnerId=" + teamWinnerId +
                '}';
    }
}
