package com.novogold.controller;

import java.net.URI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.novogold.bean.Crops;
import com.novogold.bean.Products;
import com.novogold.bean.Sale;
import com.novogold.bean.User;
import com.novogold.dao.UserDao;
//import com.novogold.dao.UserDao;
import com.novogold.dbconnection.DBConnection;
import com.novogold.service.UserDaoService;




@CrossOrigin(origins= {"*"},maxAge=4800,allowCredentials="false")
@RestController
public class UserController {
	Connection con=DBConnection.getconnection();
	//@RequestMapping(value="/user", method = RequestMethod.POST)
	
	//public String getUser(@RequestBody String payload) {
	@PostMapping("/user")
	public User getUser(@RequestBody User viewUser) {	
		if(viewUser==null||viewUser.getUser_name()==null|viewUser.getPassword()==null)
			return null;
		User user=new User();
		System.out.println(viewUser);

		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
			stmt=con.prepareStatement("select * from user where user_name=? and password=?");
			stmt.setString(1, viewUser.getUser_name());
			stmt.setString(2, viewUser.getPassword());
			rs=stmt.executeQuery();
			if(rs==null) {
				return null;
			}
			else {
				while(rs.next()) {
					user.setUser_id(rs.getInt("user_id"));
					user.setUser_name(rs.getString("user_name"));
					user.setPassword(rs.getString("password"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//return new UserDao().getUser(viewUser);
		//System.out.println(payload);
		//System.out.println(user);
		
		//new UserDao().getUser(username);
		
		/*URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{user_id}")
		.buildAndExpand(user.getUser_id()).toUri();
		
		ResponseEntity.accepted();*/
		
		if(viewUser.getUser_name().equals(user.getUser_name())&& viewUser.getPassword().equals(user.getPassword()))
		{	
			/*PreparedStatement stmt1=null;
			String query="insert into user_session values(10001,123,curdate(),null,18.490112,73.8549919)";
			try {
				stmt1=con.prepareStatement(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
			
			return user;
		}
		else
			return null;
		
	}
	
	
	@GetMapping("/users")
	@ResponseBody
	public List getAllUsers(){
		List<String> users=new ArrayList<>();
		/*UserDao user=new UserDao();
		user.getUser("mahesh");*/
		
		//String query="select * from user where user_name='"+name+"'";
		Connection con=DBConnection.getconnection();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt= con.prepareStatement("select user_name from user");
			rs=stmt.executeQuery();
			while(rs.next()) {
				users.add(rs.getString(1));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		/*users.add("mahesh");
		users.add("karan");
		users.add("siddhesh");*/
		
		return users;
		
	}
	
	@PostMapping("/persist/user")
	public long persistedUser(@RequestBody User viewUser) {
		UserDaoService userDaoService=new UserDaoService();
		return userDaoService.insert(viewUser);
		
	}
	
	
	
	@PostMapping("/user/user")
	public User getUser1(@RequestBody String payload) {	
		User user=new User();
		System.out.println(payload);
		
		String username;
		String password;
		//payload=payload.replaceAll(",", "");		
		String array[]=payload.split(",");
		System.out.println(array[0]);
		String temp[]=array[0].split(":");
		username=temp[1];
		temp=array[1].split(":");
		password=temp[1];
		username=username.replaceAll("\"", "");
		password=password.replaceAll("\"", "");
		password=password.replaceAll("}", "");
		//System.out.println(username+" "+password);
		
		Connection con=DBConnection.getconnection();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
			stmt=con.prepareStatement("select * from user where user_name=? and password=?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			rs=stmt.executeQuery();
			if(rs==null) {
				return null;
			}
			while(rs.next()) {
				user.setUser_id(rs.getInt("user_id"));
				user.setUser_name(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(username.equals(user.getUser_name())&& password.equals(user.getPassword()))
		{	
			return user;
		}
		else
			return null;
		
	}
	
	
	@GetMapping("/crops")
	public List<Crops> getCropsType() {
		
		List<Crops> crops=new ArrayList<>();
		Statement stm=null;
		ResultSet rs=null;
		
		
		try {
			 stm=con.createStatement();
			 rs=stm.executeQuery("select * from crops");
			 while(rs.next()) {
				 crops.add(new Crops(rs.getInt(1),rs.getString(2)));
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*crops.add("field crops");
		crops.add("fodder crops");
		crops.add("vegetable crops");
		crops.add("crops1");*/
		
		return crops;
	}
	
	@GetMapping("/products/{product_id}")
	public List getProducts(@PathVariable int product_id) {
		
		List<Products> products=new ArrayList<>();
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
			stmt=con.prepareStatement("select product_id,product_name from products where crops_id=?");
			stmt.setInt(1, product_id);
			rs=stmt.executeQuery();
			while(rs.next()) {
				products.add(new Products(rs.getInt(1),rs.getString(2)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}
	
	@GetMapping("/usersale/{user_id}")
	public Sale userSale(@PathVariable int user_id) {
		Sale sales=new Sale();
		
		String query1="select sum(50kg*50+20kg*20+10kg*10+5kg*5+1kg) as day_sale  from order_package op,orders o where op.order_id=o.order_id and o.user_id=? and o.order_date=curdate()";
		String query2="select sum(50kg*50+20kg*20+10kg*10+5kg*5+1kg) as week_Sale from order_package op,orders o where op.order_id=o.order_id and o.user_id=? and o.order_date between DATE_SUB(now(),interval 7 day) and now()";
		String query3="select sum(50kg*50+20kg*20+10kg*10+5kg*5+1kg) as month_Sale from order_package op,orders o where op.order_id=o.order_id and o.user_id=? and o.order_date between DATE_SUB(now(),interval 1 month) and now()";
		String query4="select sum(50kg*50+20kg*20+10kg*10+5kg*5+1kg) as 4month_Sale from order_package op,orders o where op.order_id=o.order_id and o.user_id=? and o.order_date between DATE_SUB(now(),interval 4 month) and now()";
		String query5="select sum(50kg*50+20kg*20+10kg*10+5kg*5+1kg) as month_Sale from order_package op,orders o where op.order_id=o.order_id and o.user_id=? and o.order_date between DATE_SUB(now(),interval 1 year) and now()";
		
	
				sales.setDay(getUserSale(query1,user_id));
				sales.setWeek(getUserSale(query2,user_id));
				sales.setOneMonth(getUserSale(query3,user_id));
				sales.setFourMonth(getUserSale(query4,user_id));
				sales.setYear(getUserSale(query5,user_id));
			
		return sales;
		
	}
	
	public int getUserSale(String query,int user_id){
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
			stmt=con.prepareStatement(query);
			stmt.setInt(1, user_id);
			
			rs=stmt.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return 0;
	}
	
	
	
	
	
}
