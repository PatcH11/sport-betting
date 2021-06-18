package com.company.betting.data.dto.get;

import java.util.Objects;

public class MatchDontPlayDto {

    private Integer id;
    private SportGameGetDto sportGame;
    private TeamGetDto home;
    private TeamGetDto away;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SportGameGetDto getSportGame() {
        return sportGame;
    }

    public void setSportGame(SportGameGetDto sportGame) {
        this.sportGame = sportGame;
    }

    public TeamGetDto getHome() {
        return home;
    }

    public void setHome(TeamGetDto home) {
        this.home = home;
    }

    public TeamGetDto getAway() {
        return away;
    }

    public void setAway(TeamGetDto away) {
        this.away = away;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchDontPlayDto that = (MatchDontPlayDto) o;
        return Objects.equals(id, that.id) && Objects.equals(sportGame, that.sportGame) && Objects.equals(home, that.home) && Objects.equals(away, that.away);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sportGame, home, away);
    }

    @Override
    public String toString() {
        return "MatchDontPlayDto{" +
                "id=" + id +
                ", sportGame=" + sportGame +
                ", home=" + home +
                ", away=" + away +
                '}';
    }
}
