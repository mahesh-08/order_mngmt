import { Component, OnInit } from '@angular/core';
import { NavParams, PopoverController } from '@ionic/angular';




@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss'],
})
export class ProductsComponent implements OnInit {

  product_name:any;
 kg50:number=0;
 kg20:number=0;
 kg10:number=0;
 kg5:number=0;
 kg1:number=0;
 totalquantity;
 crop_types:any;
  constructor(public navParams:NavParams,public popoverController: PopoverController) {
    this.product_name=this.navParams.get("product_name");
   }

  ngOnInit() {
    this.cropsArray=JSON.parse(localStorage.getItem("cropsArray"));
    this.crop_types=JSON.parse(localStorage.getItem("crop_types"));

    this.productListNames=JSON.parse(localStorage.getItem("productListNames"));
    if(this.productListNames==null)
      this.productListNames=[];
  }

  add50KG(sign){
    if(sign=='+')
      this.kg50++;
    if(sign=='-' && this.kg50>0)
      this.kg50--;
  }

  add20KG(sign){
    if(sign=='+')
    this.kg20++;
  if(sign=='-' && this.kg20>0)
    this.kg20--;
  }
  add10KG(sign){
    if(sign=='+')
      this.kg10++;
    if(sign=='-' && this.kg10>0)
      this.kg10--;
  
  }

  add5KG(sign){
    if(sign=='+')
      this.kg5++;
    if(sign=='-' && this.kg5>0)
      this.kg5--;
     
  }

  add1KG(sign){
    if(sign=='+')
      this.kg1++;
    if(sign=='-' && this.kg1>0)
      this.kg1--;
    
  }
  cropsArray:any[];
  productListNames:any[];
  addOrder(){
      
      this.totalquantity=this.kg50*50+this.kg20*20+this.kg10*10+this.kg5*5+this.kg1;
      

      let crops_id=JSON.parse(localStorage.getItem("crops_id"));
     
       let productList=JSON.parse(localStorage.getItem("productList"+crops_id));

       //create list of product+crops_id names
       this.productListNames.push("productList"+crops_id);
        localStorage.setItem("productListNames",JSON.stringify(this.productListNames));


      let product_id=JSON.parse(localStorage.getItem("product_id"));
      for(let i=0;i<productList.length;i++){
        if(productList[i].product_id==product_id){
            productList[i].totalquanity=this.totalquantity;
        }
      }

      for(let i=0;i<this.crop_types.length;i++){
        if(this.crop_types[i].crops_id==crops_id){
          this.crop_types[i].totalquanity=this.crop_types[i].totalquanity+this.totalquantity;
        }
      }

     
    localStorage.setItem("productList"+crops_id,JSON.stringify(productList));
    localStorage.setItem("crop_types",JSON.stringify(this.crop_types));

    let packages:any={};
    packages.kg50=this.kg50;
    packages.kg20=this.kg20;
    packages.kg10=this.kg10;
    packages.kg5=this.kg5;
    packages.kg1=this.kg1;
    
    if(this.cropsArray==null){
      this.cropsArray=[];
    }

    let temp:any={};
      temp.crop_id=JSON.parse(localStorage.getItem("crops_id"));
      temp.product_id=JSON.parse(localStorage.getItem("product_id"));
      temp.packages=packages;

      /* get crop_id and product_id from cropsArray and chech with local storage ids */

      let flag:Boolean=false;
      for(let i=0;i<this.cropsArray.length;i++){
        let croporder=this.cropsArray[i];

        if(croporder.crop_id==temp.crop_id && croporder.product_id==temp.product_id){
          this.cropsArray[i]=temp;
          flag=true;
        }
      }
      if(flag==false)
       this.cropsArray.push(temp);

      localStorage.setItem("cropsArray",JSON.stringify(this.cropsArray));
    this.popoverController.dismiss();
  }

  cancelBtn(){
    this.popoverController.dismiss();
  }


}
