package com.capgemini.asset.service;

import com.capgemini.asset.bean.AssetBean;

public interface IAssetInterface {
	public boolean isValidUsername(String name);
	public boolean isValidPassword(String pass);
	public boolean dataAuthentication(AssetBean a);
}
