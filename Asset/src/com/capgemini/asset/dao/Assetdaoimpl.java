package com.capgemini.asset.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.capgemini.asset.bean.AssetBean;
import com.capgemini.asset.util.DBConnection;

public class Assetdaoimpl implements IAssetdao{
	public boolean dataAuthentication(AssetBean a){
		Statement stmt=null;
		boolean temp=false;
		ResultSet rs=null;
		
		try{
			Connection conn=DBConnection.getConnection();
		 stmt=conn.createStatement(); 
		rs=stmt.executeQuery(IQueryMapper.RETRIEVE_USER_DATA);
		
		if(rs!=null){
		while(rs.next()){
		System.out.println(rs.getString(2));
		if(rs.getString(2).equals(a.getUsername())&&rs.getString(3).equals(a.getPassword())){
		temp=true;
		}
		else{
			temp=false;
		}
		}
		}
		}
	catch(Exception e){
		System.out.println(e);
	}
		return temp;
}
}
