import { Component, OnInit } from '@angular/core';
import { MyService } from '../my.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-end',
  templateUrl: './end.page.html',
  styleUrls: ['./end.page.scss'],
})
export class EndPage implements OnInit {

  totalDistributor=0;
  productive:any;
  nonProductive=0;
  dealerList:any;
  orderDetails:any;


  constructor(private ser:MyService,private route:Router) { }
  myDate: String = new Date().toISOString();
  ngOnInit() {
    this.dealerList=JSON.parse(localStorage.getItem("dealerList"));
    this.totalDistributor=this.dealerList.length;
    let user_id=JSON.parse(localStorage.getItem("user_id"));
    this.ser.totalOrder(user_id).subscribe(productive=>{
      this.productive=productive;
      //alert(this.productive);
    });

    //alert(JSON.stringify(this.dealerList));
    this.ser.orderDetails(this.dealerList).subscribe(ordedetails=>{
      this.orderDetails=ordedetails;
    });
    //alert(this.orderDetails);
    //console.log(JSON.stringify(this.orderDetails));
  }

  



  endNow(){
    this.route.navigate(['/tabs']);
  }

  


}
