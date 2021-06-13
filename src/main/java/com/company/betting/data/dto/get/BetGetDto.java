package com.company.betting.data.dto.get;

import java.util.Objects;

public class BetGetDto {

    private Integer id;
    private UserGetDto user;
    private MatchGetDto match;
    private TeamGetDto winner;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserGetDto getUser() {
        return user;
    }

    public void setUser(UserGetDto user) {
        this.user = user;
    }

    public MatchGetDto getMatch() {
        return match;
    }

    public void setMatch(MatchGetDto match) {
        this.match = match;
    }

    public TeamGetDto getWinner() {
        return winner;
    }

    public void setWinner(TeamGetDto winner) {
        this.winner = winner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BetGetDto betGetDto = (BetGetDto) o;
        return Objects.equals(id, betGetDto.id) && Objects.equals(user, betGetDto.user) && Objects.equals(match, betGetDto.match) && Objects.equals(winner, betGetDto.winner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, match, winner);
    }

    @Override
    public String toString() {
        return "BetGetDto{" +
                "id=" + id +
                ", user=" + user +
                ", match=" + match +
                ", winner=" + winner +
                '}';
    }
}
