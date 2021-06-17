import {Match} from "./match";
import {Score} from "./score";

export interface Result {
  id: number;
  match: Match;
  score: Score;
}

export interface ResultCreate {
  matchId: number;
  scoreId: number;
}
