package com.capgemini.recharge.bean;

public class RechargeBean {
	private String name;
	private long mobileno;
	private String planname;
	private String emailid;
	private String status;
	private int amount;
	private int rechargeId;
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	public String getPlanname() {
		return planname;
	}
	public void setPlanname(String planname) {
		this.planname = planname;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getRechargeId() {
		return rechargeId;
	}
	public void setRechargeId(int rechargeId) {
		this.rechargeId = rechargeId;
	}
	public String toString(){
		StringBuilder sb=new StringBuilder();
		sb.append("Printing Details of Recharge");
		sb.append("\nName is: "+name);
		sb.append("\nMobile number is: "+mobileno);
		sb.append("\nPlane name is: "+planname);
		sb.append("\nEmail Id is: "+emailid);
		sb.append("\nStatus of Recharge is: "+status);
		sb.append("\nRecharge id is:"+rechargeId);
		return sb.toString();
		 
	}
}
