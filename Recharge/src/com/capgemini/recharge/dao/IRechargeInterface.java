package com.capgemini.recharge.dao;
import com.capgemini.recharge.bean.*;
public interface IRechargeInterface {
public String displayRechargePlans();

	public void addRechargeData(RechargeBean rb);
	public int generateRechargeId(); 
	public String getDetails(int recharge);
}
