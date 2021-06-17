import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {AuthUser, User} from "../model/user";
import {Observable} from "rxjs";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  isAuth: boolean = false;

  constructor(private http: HttpClient, private router: Router) {
  }

  login(user: AuthUser): Observable<boolean> {
    return this.http.post<boolean>(`/api/auth/login`, user);
  }

  logout() {
    sessionStorage.setItem('token', '');
    this.router.navigate(['login']);
  }

  getCurrentUser(): Observable<User> {
    return this.http.post<User>(`/api/auth/current-user`, {}, this.getHttpHeader());
  }

  getHttpHeader(): { headers: HttpHeaders } {
    let headers: HttpHeaders = new HttpHeaders({
      'Authorization': 'Basic ' + sessionStorage.getItem('token')
    });
    return {headers: headers};
  }

  getTokenFromSessionStorage(): string {
    return sessionStorage.getItem('token');
  }
}
