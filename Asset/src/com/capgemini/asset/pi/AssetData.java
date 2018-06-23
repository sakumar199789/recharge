package com.capgemini.asset.pi;
import java.util.*;

import com.capgemini.asset.bean.AssetBean;
import com.capgemini.asset.service.*;
public class AssetData {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String usernameId,password;
		boolean check=true;
		IAssetInterface ie=new AssetImpl();
		AssetBean as=new AssetBean();
		
		System.out.println("1.Admin \n2.User");
		System.out.println("Enter your option:");
		int option=s.nextInt();
		
		//Authentication of User name and Password
		
		do{
		do{
			System.out.println("Enter Name/User Id");
			usernameId=s.next();
		}while(!(ie.isValidUsername(usernameId)));
		do{
			System.out.println("Enter Password");
			password=s.next();
		}while(!(ie.isValidPassword(password)));
		as.setUsername(usernameId);
		as.setPassword(password);
		
		}while(!ie.dataAuthentication(as));
		
		
		
		
		/*if(as.getUserType().equals("ADMIN")){
			System.out.println("1.Add New Asset \n 2.Modify Asset details \n 3.View Asset Requests");
			System.out.println("Enter your option:");
			option=s.nextInt();
			switch(option){
				case 1:
						
			
			
			
			}*/
		}
			
		
		
	}

