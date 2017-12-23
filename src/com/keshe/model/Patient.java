package com.keshe.model;

public class Patient {
	private String Pid;
	private String Pname;
	private String Psex;
	private int Page;
	private String Ptele;
	private String Paddr;
	private String Pdescribe;
	private String Pstatus;
	private String Did;
	
	public Patient() {
		super();
	}
	public Patient(String pid) {
		super();
		Pid = pid;
	}
	public Patient(String pstatus, String did) {
		super();
		Pstatus = pstatus;
		Did = did;
	}
	public Patient(String pid, String pname, String did) {
		super();
		Pid = pid;
		Pname = pname;
		Did = did;
	}
	public Patient(String pid, String pname, String psex, int page, String ptele, String paddr, String pdescribe,
			String pstatus, String did) {
		super();
		Pid = pid;
		Pname = pname;
		Psex = psex;
		Page = page;
		Ptele = ptele;
		Paddr = paddr;
		Pdescribe = pdescribe;
		Pstatus = pstatus;
		Did = did;
	}
	public String getPid() {
		return Pid;
	}
	public void setPid(String pid) {
		Pid = pid;
	}
	public String getPname() {
		return Pname;
	}
	public void setPname(String pname) {
		Pname = pname;
	}
	public String getPsex() {
		return Psex;
	}
	public void setPsex(String psex) {
		Psex = psex;
	}
	public int getPage() {
		return Page;
	}
	public void setPage(int page) {
		Page = page;
	}
	public String getPtele() {
		return Ptele;
	}
	public void setPtele(String ptele) {
		Ptele = ptele;
	}
	public String getPaddr() {
		return Paddr;
	}
	public void setPaddr(String paddr) {
		Paddr = paddr;
	}
	public String getPdescribe() {
		return Pdescribe;
	}
	public void setPdescribe(String pdescribe) {
		Pdescribe = pdescribe;
	}
	public String getPstatus() {
		return Pstatus;
	}
	public void setPstatus(String pstatus) {
		Pstatus = pstatus;
	}
	public String getDid() {
		return Did;
	}
	public void setDid(String did) {
		Did = did;
	}
}
