import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Match, MatchDontPlay} from "../model/match";
import {AuthService} from "./auth.service";
import {Team} from "../model/team";
import {Bet} from "../model/bet";

@Injectable({
  providedIn: 'root'
})
export class MatchService {

  constructor(private http: HttpClient, private auth: AuthService) {
  }

  getAllMatches(): Observable<Match[]> {
    return this.http.post<Match[]>(`api/match`, {}, this.auth.getHttpHeader());
  }

  playMatches(): Observable<void> {
    return this.http.post<void>(`api/match/play`, {}, this.auth.getHttpHeader());
  }

  getDontPlayMatches(): Observable<MatchDontPlay[]> {
    return this.http.post<MatchDontPlay[]>(`api/match/dont-play`, {}, this.auth.getHttpHeader());
  }

  getMatchStatus(match: Match): string {
    if (match.score == null) {
      return "В процессе";
    }
    return match.score.homeScore + ":" + match.score.awayScore;
  }
}
