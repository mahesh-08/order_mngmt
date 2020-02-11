import { Component, OnInit } from '@angular/core';
import { MyService } from '../my.service';
import { PopoverController, AlertController } from '@ionic/angular';
import { ProductsComponent } from '../products/products.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-crops',
  templateUrl: './crops.page.html',
  styleUrls: ['./crops.page.scss'],
})
export class CropsPage implements OnInit {

  
  constructor(private ser:MyService,
    public popoverController: PopoverController,
    public alertController: AlertController,
    private route:Router) { }

  ngOnInit() {
    this.ser.getCropTypes().subscribe((crops)=>{this.crop_types=crops;
    for(let i=0;i<this.crop_types.length;i++){
      this.crop_types[i].totalquanity=0;
    }
    localStorage.setItem("crop_types",JSON.stringify(this.crop_types));
    });
    this.dealer_name=JSON.parse(localStorage.getItem("dealer_name"));
  }

  crop_types:any;
  productList:any;
  dealer_name:any;

  totalItem=0;
  totalquantity=0;
  crops_id;

  getProducts(crop_id){
    this.crops_id=crop_id;
    localStorage.setItem("crops_id",JSON.stringify(crop_id));
    this.crop_types=JSON.parse(localStorage.getItem("crop_types"));
     this.productList=JSON.parse(localStorage.getItem("productList"+crop_id));

     if(this.productList==null){
      this.ser.getProduct(crop_id).subscribe((product)=>{this.productList=product;
       for(let i=0;i<this.productList.length;i++){
            this.productList[i].totalquanity=0;
      }      
      localStorage.setItem("productList"+crop_id,JSON.stringify(this.productList)); 
    });
    }
       
  }

  async order(product){
    
      localStorage.setItem("product_id",JSON.stringify(product.product_id));
      const popover = await this.popoverController.create({
      component: ProductsComponent,
      componentProps:{"product_name":product.product_name},
      translucent: true
    });
    
     await popover.present();
     await popover.onDidDismiss().then(() => this.refresh());
  }
  refresh() {
    this.crop_types=JSON.parse(localStorage.getItem("crop_types"));
    let crop_id=JSON.parse(localStorage.getItem("crops_id"));
    this.productList=JSON.parse(localStorage.getItem("productList"+crop_id));
    this.totalItem=JSON.parse(localStorage.getItem("productListNames")).length;
    this.totalquantity=0;
    for(let i=0;i<this.crop_types.length;i++){
      this.totalquantity=this.totalquantity+this.crop_types[i].totalquanity;
    }
    
  }

  placeOrder(){
    let msg;
    this.ser.placeOrder().subscribe(
      async str=>{
      msg=str;
      if(msg=="Order Placed")
      {
        const alert = await this.alertController.create({
          header: 'success',
          subHeader: '',
          message: 'Order has been successfully placed for <h4>'+this.dealer_name+'</h4>',
          buttons: ['OK']
        });
    
        await alert.present();
        localStorage.removeItem("cropsArray");
        let productListNames=JSON.parse(localStorage.getItem("productListNames"));
        for(let i=0;i<productListNames.length;i++){
          localStorage.removeItem(productListNames[i]);
        }
        localStorage.removeItem("productListNames");
        this.route.navigate(['/distributer']);

      }
      else{
        const alert = await this.alertController.create({
          header: 'error',
          subHeader: '',
          message: 'Order not placed',
          buttons: ['OK']
        });
        await alert.present();

        }
    });
  }

  cancelBtn(){

    localStorage.removeItem("cropsArray");
        let productListNames=JSON.parse(localStorage.getItem("productListNames"));
        if(productListNames!=null){
        for(let i=0;i<productListNames.length;i++){
          localStorage.removeItem(productListNames[i]);
        }
        localStorage.removeItem("productListNames");
      }
        
    this.route.navigate(['/distributer']);
    
  }

}
