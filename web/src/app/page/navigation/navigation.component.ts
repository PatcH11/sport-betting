import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../service/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  isAuthenticated: boolean;

  constructor(private auth: AuthService, private router: Router) {
  }

  ngOnInit(): void {
    if (this.auth.getTokenFromSessionStorage() == '') {
      this.isAuthenticated = false;
    } else {
      this.isAuthenticated = true;
    }
  }

  logout() {
    this.auth.logout();
  }
}
