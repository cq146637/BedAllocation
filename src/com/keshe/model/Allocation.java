package com.keshe.model;

import java.sql.Date;

public class Allocation {
	private String Bid;
	private String Pid;
	private String Stime;
	private String Etime;
	public Allocation(String bid, String pid) {
		super();
		Bid = bid;
		Pid = pid;
	}
	public Allocation() {
		super();
	}
	public Allocation(String bid, String pid, String stime, String etime) {
		super();
		Bid = bid;
		Pid = pid;
		Stime = stime;
		Etime = etime;
	}
	public String getBid() {
		return Bid;
	}
	public void setBid(String bid) {
		Bid = bid;
	}
	public String getPid() {
		return Pid;
	}
	public void setPid(String pid) {
		Pid = pid;
	}
	public String getStime() {
		return Stime;
	}
	public void setStime(String stime) {
		Stime = stime;
	}
	public String getEtime() {
		return Etime;
	}
	public void setEtime(String etime) {
		Etime = etime;
	}
}
