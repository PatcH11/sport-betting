import {SportGame} from "./sportGame";
import {Score} from "./score";
import {Team} from "./team";

export interface Match {
  id: number;
  sportGame: SportGame;
  score: Score;
  home: Team;
  away: Team;
}

export interface MatchDontPlay {
  id: number;
  sportGame: SportGame;
  home: Team;
  away: Team;
}
