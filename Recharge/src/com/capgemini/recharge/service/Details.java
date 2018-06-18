package com.capgemini.recharge.service;

//import com.capgemini.recharge.dao.IRechargeInterface;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.recharge.dao.IRechargeInterface;
import com.capgemini.recharge.dao.RechargeDataBase;
import com.capgemini.recharge.bean.*;
public class Details implements IRechargingInterface{

	@Override
	public String displayRechargePlans() {
		IRechargeInterface ie=new RechargeDataBase();
		String details=ie.displayRechargePlans();
		return details;
	}

	@Override
	public void addRechargeData(RechargeBean rb) {
		IRechargeInterface ie=new RechargeDataBase();
		ie.addRechargeData(rb);
	}

	@Override
	public int generateRechargeId() {
		IRechargeInterface ie=new RechargeDataBase();
		int res=ie.generateRechargeId();
		return res;
	}

	@Override
	public String getDetails(int recharge) {
		IRechargeInterface ie=new RechargeDataBase();
		String details=ie.getDetails(recharge);
		
		return details;
	}

	@Override
	public	int isValidPlanName(String pname) {
		if(pname.equals("Rc99")){
			return 99;
		}
		else if(pname.equals("Rc150")){
			return 150;
		}
		else if(pname.equals("Rc299")){
			return 299;
		}
		else if(pname.equals("Rc500")){
			return 500;
		}
		return 0;
	}

	@Override
	public boolean isValidName(String name) {
		Pattern namePattern=Pattern.compile("^[A-Za-z]{3,}$");
		Matcher nameMatcher=namePattern.matcher(name);
		return nameMatcher.matches();
	}

	@Override
	public boolean isValidPhoneNumber(Long mobile) {
		Pattern mobilePhone=Pattern.compile("^[1-9]{1}[0-9]{9}$");
	Matcher nameMatcher=mobilePhone.matcher(mobile.toString());
		return nameMatcher.matches();
	
	}

	
	}

	


