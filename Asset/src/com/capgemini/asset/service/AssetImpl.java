package com.capgemini.asset.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.asset.bean.AssetBean;

import com.capgemini.asset.dao.*;

public class AssetImpl implements IAssetInterface{

	@Override
	public boolean isValidUsername(String name) {
	Pattern namePattern=Pattern.compile("^[A-Za-z]{3,}$");
	Matcher nameMatcher=namePattern.matcher(name);
	return nameMatcher.matches();
	}
	

	@Override
	public boolean isValidPassword(String pass) {
		Pattern namePattern=Pattern.compile("^[A-Z[A-Z]{1}a-z0-9[@#$%^&*()]{1}]{8,16}$");
		Matcher nameMatcher=namePattern.matcher(pass);
		return nameMatcher.matches();
	}


	@Override
	public boolean dataAuthentication(AssetBean a) {
		IAssetdao id=new Assetdaoimpl();
		boolean temp=id.dataAuthentication(a);
		return temp;
	}
	

}
