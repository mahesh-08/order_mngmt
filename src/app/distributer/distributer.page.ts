import { Component, OnInit } from '@angular/core';
import { PopoverController } from '@ionic/angular';
import { Router } from '@angular/router';

@Component({
  selector: 'app-distributer',
  templateUrl: './distributer.page.html',
  styleUrls: ['./distributer.page.scss'],
})
export class DistributerPage implements OnInit {

  dealerList:any;
  selectedRegion:any;
  constructor(
    private route:Router
    ) { }

  ngOnInit() {

    this.dealerList=JSON.parse(localStorage.getItem("dealerList"));
    this.selectedRegion=JSON.parse(localStorage.getItem("selectedRegion"));
  }

   getdealer(dealer){
    localStorage.setItem("dealer_name",JSON.stringify(dealer.dealer_name));
    localStorage.setItem("dealer_id",JSON.stringify(dealer.dealer_id));
    this.route.navigate(['/crops']);
  }

  endDay(){
    this.route.navigate(['/end']);
  }


}
