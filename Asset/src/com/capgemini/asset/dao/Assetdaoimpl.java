package com.capgemini.asset.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.capgemini.asset.bean.AssetBean;
import com.capgemini.asset.exception.AssetException;
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
			//System.out.println(rs.getString(2));
		if((rs.getString(2).equals(a.getUserNameId())||rs.getString(1).equals(a.getUserNameId()))&&rs.getString(3).equals(a.getPassword())){
		temp=true;
		break;
		}
		else{
			temp=false;
		}
		}
		}
		/*if(temp==false)
		{
			throw new AssetException("Please Enter valid Credentials");
		}*/
		if(temp==true){
		a.setUserType(rs.getString(4));
		//System.out.println(a.getUserType());
		}
		else
			{
			System.err.println("Please Enter valid name and password.");
			}
			}
	catch(AssetException e){
		System.out.println(e);
	}
		catch(Exception e){
		System.out.println(e);
	}
		finally{
			try{
				
			
			rs.close();
			stmt.close();
		}
			catch(Exception e)
			{
				System.out.println(e);
			}
			}
		return temp;
}
}
