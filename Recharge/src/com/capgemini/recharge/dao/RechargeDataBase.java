package com.capgemini.recharge.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;  
import com.capgemini.recharge.bean.RechargeBean;
import com.capgemini.recharge.exception.*;
import com.capgemini.recharge.util.*;
public class RechargeDataBase implements IRechargeInterface{
	
	
	
	@Override
	public String displayRechargePlans(){
	String planname = null;
	int amount=0;
	String msg = null;
	StringBuilder sb=new StringBuilder();
	try{  
		Connection con= DBConnection.getInstance().getConnection();	
	  
	//step3 create the statement object  
	Statement stmt=con.createStatement();  
	  
	//step4 execute query  
	ResultSet rs=stmt.executeQuery(IQueryMapper.RECHARGE_PLANS); 
	if(rs!=null){
		while(rs.next()){
			planname=rs.getString(1);
			amount=rs.getInt(2);
			sb.append(planname+"      "+Integer.toString(amount)+"\n");
			//System.out.println(details);
			
		}
	}
	

	//step5 close the connection object  
	con.close();  
	  
	}
	catch(Exception e){ 
		msg=e.getMessage();
	}
	return sb.toString();
	  
	}

	
	

	@Override
	public void addRechargeData(RechargeBean rb) {
		PreparedStatement stmt1=null;
		System.out.println("In dao");
		
		
		try{  
			Connection con1= DBConnection.getInstance().getConnection();	
			//step3 create the statement object  
			
			//  stmt.execute();
			//step4 execute query  
	//	stmt.executeQuery("CREATE TABLE rechargedetailsp(recID number,name VARCHAR2(20),mobile number(20),status VARCHAR2(20),planname VARCHAR2(20),amount number(10))"); 
			Statement stmt=con1.createStatement();  
			ResultSet rs=stmt.executeQuery("select count(*) from tab where tname='RECHARGEDETAILS'"); 
			rs.next();
			
			
			
			
			if(rs.getInt(1)==1) {
				
			}
			else
			{
				stmt1=con1.prepareStatement("CREATE TABLE rechargedetails(recID number,name VARCHAR2(20),mobile number(20),status VARCHAR2(20),planname VARCHAR2(20),amount number(10))");   
				stmt1.execute();
			}
		
		stmt1=con1.prepareStatement(IQueryMapper.INSERT_QUERY);  
		System.out.println(rb.getRechargeId());		
		stmt1.setInt(1,rb.getRechargeId());
				stmt1.setString(2,rb.getName());
				stmt1.setLong(3,rb.getMobileno());
				stmt1.setString(4,rb.getStatus());
				stmt1.setString(5,rb.getPlanname());
				stmt1.setInt(6,rb.getAmount());
				 
				stmt1.execute();
				
				//if(queryResult)
					//System.out.println(details);
					
				
			//step5 close the connection object  
			con1.close();  
			  
			}
		
		catch(Exception e){  
				String msg = e.getMessage();
			}
	}

	@Override
	public int generateRechargeId() {
		int res=0;
		try{  
			Connection con1 = DBConnection.getInstance().getConnection();	
			//step3 create the statement object  
			Statement stmt=con1.createStatement();  
			  
			//step4 execute query  
			ResultSet rs=stmt.executeQuery(IQueryMapper.RECHARGEID_QUERY_SEQUENCE); 
			
				rs.next();
			 res=rs.getInt(1);
					//System.out.println(details);
					
				
			//step5 close the connection object  
			con1.close();  
			  
			}catch(Exception e){ 
				String msg = e.getMessage();
			}
		return res;
	}

	@Override
	public String getDetails(int recharge) {
		String planname = null;
		int amount=0;
		String msg = null;
		int rechid;
		long mobile;
		String name=null,status;
		PreparedStatement stmt=null;
		StringBuilder sb=new StringBuilder();
		try{  
			Connection con = DBConnection.getInstance().getConnection();	
		stmt=con.prepareStatement(IQueryMapper.VIEW_RECHARGE_DETAILS_QUERY);
		stmt.setInt(1,recharge);
		ResultSet rs=stmt.executeQuery();
		
		if(rs!=null){
			while(rs.next()){
				rechid=rs.getInt(1);
				name=rs.getString(2);
				mobile=rs.getLong(3);
				status=rs.getString(4);
				planname=rs.getString(5);
				amount=rs.getInt(6);
				
				
				sb.append("Recharge id:"+rechid+"\nUser Name:"+name+"\nMobile Number:"+mobile+"\nStatus:"+status+"\nRechargePlan Name:"+planname+"\nRecharge Amount:"+Integer.toString(amount)+"\n");
				//System.out.println(details);
				
			}
		}
		else
		{
			throw new RechargeException("Recharge Id is Invalid.Please Enter valid one.");
		}
		
System.out.println(rs.getString(1));
		//step5 close the connection object  
		con.close();  
		  
		}
		
		catch(RechargeException e) {
			System.out.println(e);
		}
		catch(Exception e){ 
			msg=e.getMessage();
		}
	return sb.toString();
	}

	
}
