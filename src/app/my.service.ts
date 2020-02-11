import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http'
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class MyService {
  getRegion() {
    return this.http.get("http://localhost:8080/regions");
  }

  constructor(private http:HttpClient,private route:Router) { }


  login(a:any) 
  {
    return this.http.post("http://localhost:8080/user", JSON.parse(a), {responseType:'json'});
     
 }

 getDealer(regionId){
  return this.http.get("http://localhost:8080/dealers/"+regionId);
}

getCropTypes(){
  return this.http.get("http://localhost:8080/crops");
}

getProduct(cropId){
  return this.http.get("http://localhost:8080/products/"+cropId);
}


placeOrder(){

  let order=JSON.parse(localStorage.getItem("cropsArray"));
  let user_id=JSON.parse(localStorage.getItem("user_id"));
  let dealer_id=JSON.parse(localStorage.getItem("dealer_id"));
  //alert(user_id+" "+dealer_id);
  //alert(JSON.stringify(order));
  let tempArray:any={};
  tempArray.user_id=user_id;
  tempArray.dealer_id=dealer_id;
  tempArray.order=order;
 // console.log(tempArray);
  return this.http.post("http://localhost:8080/order", tempArray, {responseType:'text'});


}


  totalOrder(user_id){
    return this.http.get("http://localhost:8080/totalorders/"+user_id);
  }

  orderDetails(dealerList:any){
    
    //alert(JSON.stringify(dealerList));
    return this.http.post("http://localhost:8080/dealerorderdetails",dealerList);
  }

  userSale(user_id){
    return this.http.get("http://localhost:8080/usersale/"+user_id);
  }

}
