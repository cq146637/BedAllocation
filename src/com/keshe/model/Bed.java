package com.keshe.model;

public class Bed {
	private String Bid;
	private String Nid;
	private String Bstatus;
	private String Checks;
	public Bed() {
		super();
	}
	public Bed(String bid) {
		super();
		Bid = bid;
	}
	public Bed(String bid, String nid) {
		super();
		Bid = bid;
		Nid = nid;
	}
	public Bed(String bid, String bstatus, String checks) {
		super();
		Bid = bid;
		Bstatus = bstatus;
		Checks = checks;
	}
	public Bed(String bid, String nid, String bstatus, String checks) {
		super();
		Bid = bid;
		Nid = nid;
		Bstatus = bstatus;
		Checks = checks;
	}
	public String getBid() {
		return Bid;
	}
	public void setBid(String bid) {
		Bid = bid;
	}
	public String getNid() {
		return Nid;
	}
	public void setNid(String nid) {
		Nid = nid;
	}
	public String getBstatus() {
		return Bstatus;
	}
	public void setBstatus(String bstatus) {
		Bstatus = bstatus;
	}
	public String getChecks() {
		return Checks;
	}
	public void setChecks(String checks) {
		Checks = checks;
	}
}
