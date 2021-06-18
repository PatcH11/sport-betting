import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Bet, BetCreate} from "../model/bet";
import {AuthService} from "./auth.service";
import {User} from "../model/user";

@Injectable({
  providedIn: 'root'
})
export class BetService {

  constructor(private http: HttpClient, private auth: AuthService) {
  }

  createBet(bet: BetCreate): Observable<Bet> {
    return this.http.post<Bet>(`api/bet/create`, bet, this.auth.getHttpHeader());
  }

  getAllBets(user: User): Observable<Bet[]> {
    return this.http.post<Bet[]>(`api/bet`, user, this.auth.getHttpHeader());
  }

  // getBetStatus(bet: Bet): string {
  //   if (bet.match.score == null) {
  //     return "В процессе";
  //   } else if (bet.match.home == bet.winner && bet.match.score.homeScore < bet.match.score.awayScore) {
  //     return "Проигрыш"
  //   } else if (bet.match.away == bet.winner && bet.match.score.homeScore > bet.match.score.awayScore) {
  //     return "Проигрыш"
  //   } else if (bet.match.away == bet.winner && bet.match.score.homeScore < bet.match.score.awayScore) {
  //     return "Выигрыш"
  //   } else if (bet.match.home == bet.winner && bet.match.score.homeScore > bet.match.score.awayScore) {
  //     return "Выигрыш"
  //   }
  // }

  getBetStatus(bet: Bet): string {
    if (bet.match.score == null) {
      return "В процессе";
    } else if (bet.match.home.id == bet.winner.id && bet.match.score.homeScore < bet.match.score.awayScore) {
      return "Проигрыш (" + bet.match.score.homeScore + ":" + bet.match.score.awayScore + ")"
    } else if (bet.match.away.id == bet.winner.id && bet.match.score.homeScore > bet.match.score.awayScore) {
      return "Проигрыш(" + bet.match.score.homeScore + ":" + bet.match.score.awayScore + ")"
    } else if (bet.match.away.id == bet.winner.id && bet.match.score.homeScore < bet.match.score.awayScore) {
      return "Выигрыш(" + bet.match.score.homeScore + ":" + bet.match.score.awayScore + ")"
    } else if (bet.match.home.id == bet.winner.id && bet.match.score.homeScore > bet.match.score.awayScore) {
      return "Выигрыш(" + bet.match.score.homeScore + ":" + bet.match.score.awayScore + ")"
    } else if (bet.match.score.homeScore == bet.match.score.awayScore) {
      return "Ничья(" + bet.match.score.homeScore + ":" + bet.match.score.awayScore + ")"
    }

    return bet.match.score.homeScore + ":" + bet.match.score.awayScore;
  }
}
