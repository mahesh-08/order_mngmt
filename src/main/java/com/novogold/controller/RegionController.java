package com.novogold.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.novogold.bean.Region;
import com.novogold.dbconnection.DBConnection;

@CrossOrigin(origins= {"*"},maxAge=4800,allowCredentials="false")
@RestController
public class RegionController {

	@GetMapping("/regions")
	public List<Region> getRegions() {
		List<Region> regions=new ArrayList<>();
		Connection con=DBConnection.getconnection();
		Statement stm=null;
		ResultSet rs=null;
		
		try {
			stm=con.createStatement();
			rs=stm.executeQuery("select * from region");
			while(rs.next()) {
				regions.add(new Region(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return regions;
	}
	
	@GetMapping("/allRegions")
	public List getAllRegions() {
		List<String> al=new ArrayList<>();
		al.add("pune");
		al.add("mumbai");
		al.add("nagar");
		al.add("kharadi");
		
		return al;
	
	}
	
	
}
