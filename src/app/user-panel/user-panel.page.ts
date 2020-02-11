import { Component, OnInit } from '@angular/core';
import { MyService } from '../my.service';
import { Platform } from '@ionic/angular';
import { SplashScreen } from '@ionic-native/splash-screen/ngx';
import { StatusBar } from '@ionic-native/status-bar/ngx';

@Component({
  selector: 'app-user-panel',
  templateUrl: './user-panel.page.html',
  styleUrls: ['./user-panel.page.scss'],
})
export class UserPanelPage implements OnInit {

  constructor(private ser:MyService,
    private platform: Platform,
    private splashScreen: SplashScreen,
    private statusBar: StatusBar) {
   }

   selectedRegion:number=0;
  regionList:any;
  dealerList:any;

  ngOnInit() {
    this.platform.ready().then(() => {
      this.statusBar.styleDefault();
      this.splashScreen.hide();
      this.ser.getRegion().subscribe((region)=>this.regionList=region);
    });
  }
  

  getDealer(regionId:number){
    this.ser.getDealer(regionId).subscribe((dealer)=>this.dealerList=dealer);
  }


}
