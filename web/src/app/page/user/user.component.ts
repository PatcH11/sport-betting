import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AuthService} from "../../service/auth.service";
import {BetService} from "../../service/bet.service";
import {User} from "../../model/user";
import {Bet} from "../../model/bet";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  currentUser: User;
  displayedColumns: string[] = ['sportGame', 'home', 'away', 'think', 'status'];
  dataSource: Bet[];

  constructor(private http: HttpClient, private auth: AuthService, public betService: BetService) {
  }

  ngOnInit(): void {
    this.setCurrentUser();
  }

  logout() {
    this.auth.logout();
  }

  getUserBets() {
    console.log(this.currentUser)
    this.betService.getAllBets(this.currentUser).subscribe(
      res => {
        console.log(res);
        this.dataSource = res;
      }, error => {
        console.log('Не удалось загрузить');
      }
    )
  }

  setCurrentUser() {
    this.auth.getCurrentUser().subscribe(
      res => {
        this.currentUser = res;
        this.betService.getAllBets(res).subscribe(res => {
          this.dataSource = res;
        })
      }, error => {
        console.log('Не удалось загрузить пользователя');
      }
    )
  }

  getImg(): string {
    return "data:image/png;base64," + this.currentUser.picture.data;
  }
}
