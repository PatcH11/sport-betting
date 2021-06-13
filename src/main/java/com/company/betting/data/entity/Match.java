package com.company.betting.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Представление таблицы matches.
 *
 * @author Николай Евсюков
 */
@Entity
@Table(name = "matches", schema = "public")
public class Match {

    @Id
    @Column(name = "match_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "sport_game_id")
    @ManyToOne(targetEntity = SportGame.class)
    private SportGame sportGame;

    @JoinColumn(name = "score_id")
    @ManyToOne(targetEntity = Score.class)
    private Score score;

    @JoinColumn(name = "team_home_id")
    @ManyToOne(targetEntity = Team.class)
    private Team home;

    @JoinColumn(name = "team_away_id")
    @ManyToOne(targetEntity = Team.class)
    private Team away;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SportGame getSportGame() {
        return sportGame;
    }

    public void setSportGame(SportGame sportGame) {
        this.sportGame = sportGame;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public Team getHome() {
        return home;
    }

    public void setHome(Team home) {
        this.home = home;
    }

    public Team getAway() {
        return away;
    }

    public void setAway(Team away) {
        this.away = away;
    }
}
