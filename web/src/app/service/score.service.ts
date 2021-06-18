import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Score} from "../model/score";
import {AuthService} from "./auth.service";

@Injectable({
  providedIn: 'root'
})
export class ScoreService {

  constructor(private http: HttpClient, private auth: AuthService) {
  }

  getAllScores(): Observable<Score[]> {
    return this.http.post<Score[]>(`api/score`, {}, this.auth.getHttpHeader());
  }
}
