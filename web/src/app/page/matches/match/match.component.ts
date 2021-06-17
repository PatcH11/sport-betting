import {Component, OnInit} from '@angular/core';
import {Match} from "../../../model/match";
import {MatchService} from "../../../service/match.service";
import {MatDialog} from "@angular/material/dialog";
import {DialogBoxMatchComponent} from "../dialog-box-match/dialog-box-match.component";
import {BetService} from "../../../service/bet.service";
import {BetCreate} from "../../../model/bet";
import {AuthService} from "../../../service/auth.service";

@Component({
  selector: 'app-match',
  templateUrl: './match.component.html',
  styleUrls: ['./match.component.css']
})
export class MatchComponent implements OnInit {

  displayedColumns: string[] = ['sportGame', 'home', 'away', 'score', 'action'];
  dataSource: Match[];
  currentUserId: number;

  constructor(public dialog: MatDialog,
              private matchService: MatchService,
              private betService: BetService,
              private auth: AuthService) {
  }

  ngOnInit(): void {
    this.setCurrentUserId();
    this.getAllMatches();
  }

  getAllMatches() {
    this.matchService.getAllMatches().subscribe(
      res => {
        console.log(res);
        this.dataSource = res;
      }, error => {
        console.log('Матчи не загрузились!');
      }
    );
  }

  openDialog(action, obj) {
    obj.action = action;
    const dialogRef = this.dialog.open(DialogBoxMatchComponent, {
      width: '350px',
      data: obj
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log(result.winnerId);
      if (result.event == 'Add') {
        this.createBet(result.data, result.winnerId);
      }
    });
  }

  createBet(row_obj, winnerId) {
    let bet = {
      userId: this.currentUserId,
      matchId: row_obj.id,
      teamWinnerId: winnerId
    } as BetCreate;

    console.log(bet);

    this.betService.createBet(bet).subscribe(() => this.refresh());
  }

  playMatches() {
    this.matchService.playMatches().subscribe(() => this.refresh());
  }

  refresh() {
    this.matchService.getAllMatches().subscribe((data: Match[]) => {
      this.dataSource = data
    })
  }

  setCurrentUserId() {
    this.auth.getCurrentUser().subscribe(
      res => {
        this.currentUserId = res.id;
      }, error => {
        console.log('Ошибка получения пользователя');
      }
    )
  }
}
