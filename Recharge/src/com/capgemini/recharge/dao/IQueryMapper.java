package com.capgemini.recharge.dao;

public interface IQueryMapper {
	public static final String RECHARGE_PLANS="select * from rechargeplans";
	public static final String VIEW_RECHARGE_DETAILS_QUERY="select * from rechargedetails where recID=?";
	public static final String INSERT_QUERY="INSERT INTO rechargedetails VALUES(?,?,?,?,?,?)";
	public static final String RECHARGEID_QUERY_SEQUENCE="select re_seq.NEXTVAL from dual";
	
}
