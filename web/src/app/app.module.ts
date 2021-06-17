import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {NavigationComponent} from './page/navigation/navigation.component';
import {NotFoundComponent} from './page/not-found/not-found.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {UserComponent} from './page/user/user.component';
import {MatchComponent} from './page/matches/match/match.component';
import {RouterModule, Routes} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatButtonModule} from "@angular/material/button";
import {LoginPageComponent} from './page/auth/login-page/login-page.component';
import {RegistrationPageComponent} from './page/auth/registration-page/registration-page.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {AuthGuard} from "./guards/auth.guard";
import {DialogBoxMatchComponent} from './page/matches/dialog-box-match/dialog-box-match.component';
import {MatTableModule} from '@angular/material/table'
import {MatDialogModule} from "@angular/material/dialog";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatSelectModule} from "@angular/material/select";
import {MatInputModule} from "@angular/material/input";
import {MatCardModule} from "@angular/material/card";
import {MatMenuModule} from "@angular/material/menu";
import {MatIconModule} from "@angular/material/icon";
import {MatDividerModule} from "@angular/material/divider";
import {MatSlideToggleModule} from "@angular/material/slide-toggle";
import {MatOptionModule} from "@angular/material/core";
import {MatProgressSpinnerModule} from "@angular/material/progress-spinner";

const appRoutes: Routes = [
  {
    path: '',
    component: UserComponent,
    pathMatch: 'full',
    canActivate: [AuthGuard]
  },
  {
    path: 'login', component: LoginPageComponent
  },
  {
    path: 'registration', component: RegistrationPageComponent
  },
  // {
  //   path: 'user', component: UserComponent, canActivate: [AuthGuard]
  // },
  {
    path: 'match', component: MatchComponent, canActivate: [AuthGuard]
  },
  {
    path: '**',
    component: NotFoundComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    NotFoundComponent,
    UserComponent,
    MatchComponent,
    LoginPageComponent,
    RegistrationPageComponent,
    DialogBoxMatchComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    RouterModule.forRoot(appRoutes),
    RouterModule,
    MatToolbarModule,
    MatButtonModule,
    ReactiveFormsModule,
    FormsModule,
    MatTableModule,
    MatDialogModule,
    MatFormFieldModule,
    MatSelectModule,
    MatInputModule,
    MatCardModule,
    MatMenuModule,
    MatIconModule,
    MatDividerModule,
    MatSlideToggleModule,
    MatOptionModule,
    MatProgressSpinnerModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
