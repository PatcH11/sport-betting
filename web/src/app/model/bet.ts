import {User} from "./user";
import {Match} from "./match";
import {Team} from "./team";

export interface Bet {
  id: number;
  user: User;
  match: Match;
  winner: Team;
}

export interface BetCreate {
  userId: number;
  matchId: number;
  teamWinnerId: number;
}
