package com.leap.hackathon.elist.utility;

public class Query {
	private Query() {

	}

	public static final String CREATECUSTOMER="INSERT INTO CUSTOMER(name,password,email,mobile,alias) VALUES(?,?,?,?,?)";
	public static final String GETCUSTOMERID="SELECT CUSTOMER_ID FROM CUSTOMER WHERE MAIL_ID=?";
	public static final String DELETECUSTOMER="DELETE FROM CUSTOMER WHERE CUSTOMERID";
	public static final String GETALLCUSTOMERBILLS="SECECT * FROM BILL WHERE CUSTOMER_ID=?";
	public static final String CREATEVENDOR="INSERT INTO VENDOR(user_name,password,email,mobile,store_name,branch) VALUES(?,?,?,?,?,?)";
	

}
