package com.capgemini.recharge.exception;

public class RechargeException extends Exception{
	String excep;	
	public RechargeException(String str){
			excep=str;
		}
public String toString(){
	return excep;
}
}
