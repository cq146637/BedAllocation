package com.keshe.model;

public class User {
	private String Uaccount;
	private String Uname;
	private String Upassword;
	private String Utype;
	public User() {
		super();
	}
	
	public User(String uaccount, String uname) {
		super();
		Uaccount = uaccount;
		Uname = uname;
	}
	

	public User(String uaccount, String uname, String utype) {
		super();
		Uaccount = uaccount;
		Uname = uname;
		Utype = utype;
	}

	public User(String uaccount) {
		super();
		Uaccount = uaccount;
	}

	public User(String uaccount, String uname, String upassword, String utype) {
		super();
		Uaccount = uaccount;
		Uname = uname;
		Upassword = upassword;
		Utype = utype;
	}
	public String getUaccount() {
		return Uaccount;
	}
	public void setUaccount(String uaccount) {
		Uaccount = uaccount;
	}
	public String getUname() {
		return Uname;
	}
	public void setUname(String uname) {
		Uname = uname;
	}
	public String getUpassword() {
		return Upassword;
	}
	public void setUpassword(String upassword) {
		Upassword = upassword;
	}
	public String getUtype() {
		return Utype;
	}
	public void setUtype(String utype) {
		Utype = utype;
	}

}
