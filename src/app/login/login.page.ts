import { Component, OnInit } from '@angular/core';
import { MyService } from '../my.service';
import { Router } from '@angular/router';
import { AlertController } from '@ionic/angular';

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {
  geolocationPosition: Position;

  constructor(private ser:MyService,
    private alertController: AlertController,
    private route:Router,
) { }


  ngOnInit() {

    if (window.navigator && window.navigator.geolocation) {
      window.navigator.geolocation.getCurrentPosition(
          position => {
              this.geolocationPosition = position,
                  
              console.log(position)
          },
          error => {
              switch (error.code) {
                  case 1:
                      console.log('Permission Denied');
                      break;
                  case 2:
                      console.log('Position Unavailable');
                      break;
                  case 3:
                      console.log('Timeout');
                      break;
              }
          }
      );
  };
  
  }

  user_name:string;
  password:string;
  loginUser:any;
  
  async login()
  {
   const obj:any={};
   obj.user_name = this.user_name;
   obj.password = this.password;
   obj.latitude= this.geolocationPosition.coords.latitude;
   obj.longitude=this.geolocationPosition.coords.longitude;
        console.log(obj);
       this.ser.login(JSON.stringify(obj)).subscribe(async arg =>{
          this.loginUser=arg;
          if(this.loginUser==""||this.loginUser==null){
            const alert = await this.alertController.create({
              header: 'error',
              subHeader: '',
              message: 'Enter valid User Name and Password',
              buttons: ['OK']
            });
        
            await alert.present();
            return;
          }
          else{
            const alert = await this.alertController.create({
              header: 'success',
              subHeader: '',
              message: 'Login succesfull',
              buttons: ['OK']
            });
        
            await alert.present();
            localStorage.setItem("user_id",JSON.stringify(this.loginUser.user_id));
            localStorage.setItem("user_name",JSON.stringify(this.loginUser.user_name));
            
            this.route.navigate(['/tabs']);
          }
       });
  }


  
  next(){
    this.route.navigate(['/tabs']);
  }

}
