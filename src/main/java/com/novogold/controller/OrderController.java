package com.novogold.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.novogold.bean.Order;
import com.novogold.bean.OrderObject;
import com.novogold.bean.Packages;
import com.novogold.dbconnection.DBConnection;

@CrossOrigin(origins= {"*"},maxAge=4800,allowCredentials="false")
@RestController
public class OrderController {
	static long order_id=100111;
	Connection con=DBConnection.getconnection();
	@PostMapping("/order")
	public String placeOrder(@RequestBody OrderObject obj) {
		if(obj==null)
			return null;
		
		PreparedStatement stmt=null;
		PreparedStatement stmt1=null;
		
		int user_id=obj.getUser_id();
		int dealer_id=obj.getDealer_id();
		List<Order> orders=obj.getOrder();
	
		LocalDate date=LocalDate.now();
		
		int orderquery1 = 0;
		int orderquery2=0;
		try {
			stmt=con.prepareStatement("insert into orders values(?,?,?,?)");
			
			stmt.setLong(1,order_id);
			stmt.setInt(2, user_id);
			stmt.setInt(3,dealer_id);
			stmt.setString(4,date.toString());
			
			orderquery1=stmt.executeUpdate();
			if(orderquery1>0) {
				
				Iterator<Order> itr=orders.iterator();
				while(itr.hasNext()) {
					Order ord=itr.next();
					Packages pack=ord.getpackages();
					
					stmt1=con.prepareStatement("insert into order_package values(?,?,?,?,?,?,?,?)");
					stmt1.setLong(1,order_id );
					
					stmt1.setInt(2,ord.getCrop_id() );
					stmt1.setInt(3,ord.getProduct_id() );
					stmt1.setInt(4,pack.getKg50() );
					stmt1.setInt(5,pack.getKg20() );
					stmt1.setInt(6,pack.getKg10() );
					stmt1.setInt(7,pack.getKg5() );
					stmt1.setInt(8,pack.getKg1() );
					orderquery2=stmt1.executeUpdate();
					
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(orderquery1>0 && orderquery2>0) {
			order_id++;
			return "Order Placed";
		}
		else
			return null;
		//return "Order Placed";
	}
	
	@GetMapping("/totalorders/{user_id}")
	public int totalOrders(@PathVariable int user_id) {
		
		LocalDate date=LocalDate.now();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		int count=0;
		try {
			stmt=con.prepareStatement("select count(*) from orders where user_id=? and order_date=curdate()");
			stmt.setInt(1,user_id);
			rs=stmt.executeQuery();
			while(rs.next()) {
				count=rs.getInt(1);
				//System.out.println(count);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return count;
	}
	
	
	
}
