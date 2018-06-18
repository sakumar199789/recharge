package com.capgemini.asset.pi;
import java.util.*;

import com.capgemini.asset.bean.AssetBean;
import com.capgemini.asset.service.*;
public class AssetData {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String username,password;
		IAssetInterface ie=new AssetImpl();
		AssetBean as=new AssetBean();
		do{
			System.out.println("Enter username");
			username=s.next();
		}while(!(ie.isValidUsername(username)));
		do{
			System.out.println("Enter pasword");
			password=s.next();
		}while(!(ie.isValidPassword(password)));
		as.setUsername(username);
		as.setPassword(password);
		if(ie.dataAuthentication(as)){
			System.out.println("valid user");
		}
		else
		{
			System.out.println("Invalid User");
		}
	}
}
