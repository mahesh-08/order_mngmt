import { Component, OnInit } from '@angular/core';
import { MyService } from '../my.service';
import { Platform, PopoverController, AlertController } from '@ionic/angular';
import { SplashScreen } from '@ionic-native/splash-screen/ngx';
import { StatusBar } from '@ionic-native/status-bar/ngx';
import { Router } from '@angular/router';
import { ProductsComponent } from '../products/products.component';

@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss']
})
export class Tab1Page implements OnInit{
  ngOnInit() {
      this.ser.getRegion().subscribe((region)=>this.regionList=region);
  }

  constructor(private ser:MyService,
    private route:Router,
    /* private platform: Platform,
    private splashScreen: SplashScreen,
    private statusBar: StatusBar, */
    public alertController: AlertController,
    public popoverController: PopoverController
    ) {}

  selectedRegionId:number=0;
  selectedRegion_name:any
  regionList:any;
  dealerList:any;
  selectRegion="Select Region";
  day_start:true;


  getDealer(regionid){
    for(let i=0;i<this.regionList.length;i++){
      if(this.regionList[i].region_id==regionid)
      this.selectedRegion_name=this.regionList[i].region_name;
    }
    localStorage.setItem("selectedRegion",JSON.stringify(this.selectedRegion_name));
    this.ser.getDealer(regionid).subscribe((dealer)=>this.dealerList=dealer);
  
  }


  async startDay(){
   
    if(this.dealerList==null || this.dealerList==""){
      const alert = await this.alertController.create({
        header: 'error',
        subHeader: '',
        message: 'No region selected',
        buttons: ['OK']
      });
  
      await alert.present();
      return;
    }


    localStorage.setItem("dealerList",JSON.stringify(this.dealerList));
  
    localStorage.setItem("regionList",JSON.stringify(this.regionList));
    this.route.navigate(['/distributer']);
   
  }

 
}
