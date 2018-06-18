package com.capgemini.recharge.pi;
import java.util.Scanner;

import com.capgemini.recharge.bean.RechargeBean;
import com.capgemini.recharge.dao.IRechargeInterface;
import com.capgemini.recharge.dao.RechargeDataBase;
import com.capgemini.recharge.service.Details;
import com.capgemini.recharge.service.IRechargingInterface;
public class UserInput {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String name=null;
		long mobile=0;
		IRechargingInterface ie=new Details();
		boolean check=true;
		RechargeBean rb=new RechargeBean();
		boolean flag=true;
		int amt=0;
		
		
		//Validating User name
		
		
		do{
				System.out.println("Enter the name");
				name=sc.next();
		}while(!(ie.isValidName(name)));
		
		
		//Validating Phone Number
		
		
		
		do{		
			System.out.println("Enter the mobile number");
				mobile=sc.nextLong();
		}while(!(ie.isValidPhoneNumber(mobile)));	
				
		String details_plans=ie.displayRechargePlans();
		System.out.println(details_plans);
		//Validating Plan Name
		
		System.out.println("Enter the plan Name:");
		String planname=sc.next();
		
		if((amt=ie.isValidPlanName(planname))>0){
			rb.setRechargeId(ie.generateRechargeId());
			rb.setPlanname(planname);
			rb.setAmount(amt);
			rb.setStatus("success");
			System.out.println("Your mobile has been recharged .... recharge id is :<"+rb.getRechargeId()+">");
			
		}
		else{
			rb.setRechargeId(ie.generateRechargeId());
			rb.setPlanname(planname);
			rb.setAmount(amt);
			rb.setStatus("fail");
			System.err.println("Your mobile has not been recharged.Plan name incorrect.");
			
		}
		rb.setName(name);
		rb.setMobileno(mobile);
	ie.addRechargeData(rb);
		
		
		System.out.println("Enter recharge id:");
		int rechargeid=sc.nextInt();
		String details=ie.getDetails(rechargeid);
		System.out.println(details);
	
		}
		


}
