package com.novogold.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.novogold.bean.Dealer;
import com.novogold.bean.DealerOrderDetails;
import com.novogold.dbconnection.DBConnection;

@CrossOrigin(origins= {"*"},maxAge=4800,allowCredentials="false")
@RestController
public class DealerController {
	Connection con=DBConnection.getconnection();
	@GetMapping("/dealers/{regionId}")
	public List<Dealer> getDealer(@PathVariable int regionId) {
		List<Dealer> dealers=new ArrayList<>();
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
			stmt=con.prepareStatement("select * from dealers where region_id=?;");
			stmt.setInt(1,regionId);
			rs=stmt.executeQuery();
			if(rs==null) {
				return null;
			}
			else {
				while(rs.next()) {
					if(rs.getInt(1)==0) {
						return null;
					}
					else
					{
						Dealer dl=new Dealer();
						dl.setDealer_id(rs.getInt(1));
						dl.setDealer_name(rs.getString(2));
						dl.setRegion_id(rs.getInt(3));
						dl.setAddress(rs.getString(4));
						dealers.add(dl);
						
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		/*dealers.add("Agrostar");
		dealers.add("abc");
		dealers.add("asd");
		dealers.add("zxcv");
		*/
		return dealers;
		
	}
	
	@PostMapping("/dealerorderdetails")
	public List dealerOrderDetails(@RequestBody List<Dealer> dealersList) {
		
		//System.out.println(dealersList);
		List<DealerOrderDetails> dealerOrderDetails=new ArrayList<>();
		PreparedStatement stmt=null;
		PreparedStatement stmt1=null;
		ResultSet rs=null;
		ResultSet rs1=null;
		String query1="select sum(50kg*50+20kg*20+10kg*10+5kg*5+1kg) as Total_order from order_package where " + 
				"order_id = (select o.order_id from orders o,dealers d where d.dealer_id=o.dealer_id and d.dealer_name=?"
				+ " group by order_date order by order_date desc limit 1 )";
		
		String query2="select count(*) as Total_order from order_package where " + 
				"order_id = (select o.order_id from orders o,dealers d where d.dealer_id="
				+ "o.dealer_id and d.dealer_name=? group by order_date order by order_date desc limit 1 )";
		
		Iterator<Dealer> itr=dealersList.iterator();
		while(itr.hasNext()) {
			Dealer dealer=itr.next();
			//System.out.println(dealer);
			try {
				stmt=con.prepareStatement(query1);
				stmt1=con.prepareStatement(query2);
				
				stmt.setString(1,dealer.getDealer_name());
				stmt1.setString(1,dealer.getDealer_name());
				
				rs=stmt.executeQuery();
				rs1=stmt1.executeQuery();
				while(rs.next()) {
					rs1.next();
					//System.out.println(rs.getInt(1));
					DealerOrderDetails temp=new DealerOrderDetails();
					temp.setDealer_id(dealer.getDealer_id());
					temp.setDealer_name(dealer.getDealer_name());
					temp.setTotal_weight(rs.getInt(1));
					temp.setItem_quantity(rs1.getInt(1));
					dealerOrderDetails.add(temp);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return dealerOrderDetails;
		
	}
	
}
