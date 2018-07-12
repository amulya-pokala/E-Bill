package com.leap.hackathon.elist.utility;

public class Query {
	private Query() {

	}

	public static final String CREATECUSTOMER="INSERT INTO CUSTOMER(name,password,email,mobile,alias) VALUES(?,?,?,?,?)";
	public static final String GETCUSTOMERID="SELECT CUSTOMER_ID FROM CUSTOMER WHERE MAIL_ID=?";
	public static final String DELETECUSTOMER="DELETE FROM CUSTOMER WHERE CUSTOMERID";
	public static final String GETALLCUSTOMERBILLS="SECECT * FROM BILL WHERE CUSTOMER_ID=?";
	public static final String CREATEVENDOR="INSERT INTO VENDOR(user_name,password,email,mobile,store_name,branch) VALUES(?,?,?,?,?,?)";
	public static final String ADDITEM="INSERT INTO ?(name,price,availability) VALUES(?,?,?)";
	public static final String CREATEVENDORTABLE="CREATE TABLE ?(id int,name varchar(50),price double, availability int) ";
	public static final String FILTERBILLSBYMONTH="SELECT * FROM BILL WHERE CUSTOMER_ID = ? AND DATE LIKE %-?-%";
	public static final String GETBILLID="SELECT BILL_ID FROM BILL WHERE BILL_DATA=?";
}
