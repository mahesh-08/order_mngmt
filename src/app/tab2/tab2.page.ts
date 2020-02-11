import { Component } from '@angular/core';
import { MyService } from '../my.service';

@Component({
  selector: 'app-tab2',
  templateUrl: 'tab2.page.html',
  styleUrls: ['tab2.page.scss']
})
export class Tab2Page {

  userSale: any;
  user_id;
  user_name;
  total;
  constructor(private ser: MyService) {
    this.user_id = JSON.parse(localStorage.getItem("user_id"));
    this.user_name = JSON.parse(localStorage.getItem("user_name"));
    this.ser.userSale(this.user_id).subscribe(sale => this.userSale = sale);
  }



  btnClick(btn) {

    if (btn == 'd')
      this.total = this.userSale.day;
    if (btn == '1w')
      this.total = this.userSale.week
    if(btn == '1m')
       this.total = this.userSale.oneMonth
    if(btn == '4m')
      this.total = this.userSale.fourMonth
    if(btn == 'y')
      this.total = this.userSale.year
  }

}
