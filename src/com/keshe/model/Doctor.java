package com.keshe.model;

public class Doctor {
	private String Did;
	private String Dname; 
	private String Dsex; 
	private int Dage; 
	private String Dtele; 
	private String Daddr;
	private String Dstatus;
	private String Dposition;
	
	public Doctor() {
		super();
	}

	public Doctor(String did) {
		super();
		Did = did;
	}
	
	public Doctor(String did, String dname) {
		super();
		Did = did;
		Dname = dname;
	}

	public Doctor(String did, String dname, String dsex, int dage, String dtele, String daddr, String dstatus,
			String dposition) {
		super();
		Did = did;
		Dname = dname;
		Dsex = dsex;
		Dage = dage;
		Dtele = dtele;
		Daddr = daddr;
		Dstatus = dstatus;
		Dposition = dposition;
	}
	
	public String getDid() {
		return Did;
	}
	public void setDid(String did) {
		Did = did;
	}
	public String getDname() {
		return Dname;
	}
	public void setDname(String dname) {
		Dname = dname;
	}
	public String getDsex() {
		return Dsex;
	}
	public void setDsex(String dsex) {
		Dsex = dsex;
	}
	public int getDage() {
		return Dage;
	}
	public void setDage(int dage) {
		Dage = dage;
	}
	public String getDtele() {
		return Dtele;
	}
	public void setDtele(String dtele) {
		Dtele = dtele;
	}
	public String getDaddr() {
		return Daddr;
	}
	public void setDaddr(String daddr) {
		Daddr = daddr;
	}
	public String getDstatus() {
		return Dstatus;
	}
	public void setDstatus(String dstatus) {
		Dstatus = dstatus;
	}
	public String getDposition() {
		return Dposition;
	}
	public void setDposition(String dposition) {
		Dposition = dposition;
	}
}