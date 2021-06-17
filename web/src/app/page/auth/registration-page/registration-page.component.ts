import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AuthUser, UserCreate} from "../../../model/user";
import {switchMap} from "rxjs/operators";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "../../../service/auth.service";
import {HttpClient, HttpEventType, HttpResponse} from "@angular/common/http";
import {UserService} from "../../../service/user.service";
import {PictureService} from "../../../service/picture.service";
import {Observable} from "rxjs";
import {Picture} from "../../../model/picture";

@Component({
  selector: 'app-registration-page',
  templateUrl: './registration-page.component.html',
  styleUrls: ['./registration-page.component.css']
})
export class RegistrationPageComponent implements OnInit {

  form: FormGroup;
  public loginInvalid = false;

  selectedFiles?: FileList;
  currentFile?: File;

  fileInfos?: Observable<any>;

  pic: Picture;

  constructor(
    private userService: UserService,
    private route: ActivatedRoute,
    private router: Router,
    private http: HttpClient,
    private auth: AuthService,
    private fb: FormBuilder,
    private pictureService: PictureService
  ) {
    this.form = this.fb.group({
      username: ['', Validators.required],
      email: ['', Validators.required],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      password: ['', Validators.required],
      photo: ['', Validators.required]
    });
  }

  ngOnInit() {
  }

  selectFile(event: any): void {
    this.selectedFiles = event.target.files;
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
        this.router.navigate(['user']);
      } else {
        alert("Authentication failed.")
      }
    });
  }

  registration() {
    this.currentFile = this.selectedFiles.item(0);

    this.pictureService.uploadPicture(this.currentFile).subscribe(
      (event: any) => {
        if (event.body != undefined) {
          let user = {
            pictureId: event.body.id,
            username: this.form.get('username')?.value,
            password: this.form.get('password')?.value,
            email: this.form.get('email')?.value,
            firstName: this.form.get('firstName')?.value,
            lastName: this.form.get('lastName')?.value
          } as UserCreate;

          this.userService.createUser(user).subscribe(
            res => {
              console.log(res);
            }
          )
        }
      },
      (err: any) => {
        console.log(err);
        this.currentFile = undefined;
      });


    this.selectedFiles = undefined;

    console.log(this.pic);
  }
}

