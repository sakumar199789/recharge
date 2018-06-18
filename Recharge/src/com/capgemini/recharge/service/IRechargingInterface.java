package com.capgemini.recharge.service;
import com.capgemini.recharge.bean.*;
public interface IRechargingInterface {
	public String displayRechargePlans();
	public void addRechargeData(RechargeBean rb);
	public int generateRechargeId(); 
	public String getDetails(int recharge);
	public	int isValidPlanName(String pname);
	public boolean isValidName(String name);
	public boolean isValidPhoneNumber(Long mobile);
}
