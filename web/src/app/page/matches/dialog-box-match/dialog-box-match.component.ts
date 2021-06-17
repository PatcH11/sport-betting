import {Component, Inject, OnInit, Optional} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {Match} from "../../../model/match";

@Component({
  selector: 'app-dialog-box-match',
  templateUrl: './dialog-box-match.component.html',
  styleUrls: ['./dialog-box-match.component.css']
})
export class DialogBoxMatchComponent implements OnInit {

  action: string;
  local_data: any;
  winnerId: string;
  displayedColumns: string[] = ['sportGame', 'home', 'away', 'score'];

  constructor(public dialogRef: MatDialogRef<DialogBoxMatchComponent>,
              @Optional() @Inject(MAT_DIALOG_DATA) public data: Match) {
    console.log(data);
    this.local_data = {...data};
    this.action = this.local_data.action;
  }

  ngOnInit(): void {
  }

  doAction() {
    console.log(this.local_data)
    console.log(this.winnerId);
    this.dialogRef.close({event: this.action, data: this.local_data, winnerId: this.winnerId});
  }

  closeDialog() {
    this.dialogRef.close({event: 'Cancel'});
  }
}
