import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Match} from "../model/match";
import {AuthService} from "./auth.service";
import {Team} from "../model/team";

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
}
