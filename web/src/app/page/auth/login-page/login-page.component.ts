import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {AuthService} from "../../../service/auth.service";
import {AuthUser} from "../../../model/user";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  form: FormGroup;
  public loginInvalid = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private http: HttpClient,
    private auth: AuthService,
    private fb: FormBuilder
  ) {
    this.form = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  ngOnInit() {
    sessionStorage.setItem('token', '');
  }

  login() {
    let user = {
      username: this.form.get('username')?.value,
      password: this.form.get('password')?.value
    } as AuthUser;

    this.auth.login(user).subscribe(isValid => {
      console.log(isValid)
      if (isValid) {
        this.auth.isAuth = true;
        sessionStorage.setItem('token', btoa(user.username + ':' + user.password));
        console.log(this.auth.getTokenFromSessionStorage());
        this.router.navigate(['']);
      } else {
        alert("Authentication failed.")
      }
    });
  }
}
