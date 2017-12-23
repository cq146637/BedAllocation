package com.keshe.model;

public class Nurse {
	private String Nid;
	private String Nname;
	private String Nsex;
	private int Nage;
	private int NageL;
	private int NageH;
	private String Ntele;
	private String Naddr;
	private String Nstatus;
	public Nurse() {
		super();
	}
	
	public Nurse(String nid, String nname) {
		super();
		Nid = nid;
		Nname = nname;
	}

	public Nurse(String nname, String nsex, String ntele) {
		super();
		Nname = nname;
		Nsex = nsex;
		Ntele = ntele;
	}

	public Nurse(String nid, String nname, String nsex, int nageL, int nageH, String ntele, String naddr) {
		super();
		Nid = nid;
		Nname = nname;
		Nsex = nsex;
		NageL = nageL;
		NageH = nageH;
		Ntele = ntele;
		Naddr = naddr;
	}

	public Nurse(String nid, String nname, String nsex, int nage, String ntele, String naddr, String nstatus) {
		super();
		Nid = nid;
		Nname = nname;
		Nsex = nsex;
		Nage = nage;
		Ntele = ntele;
		Naddr = naddr;
		Nstatus = nstatus;
	}
	
	public Nurse(String nid) {
		super();
		Nid = nid;
	}

	public String getNid() {
		return Nid;
	}
	public void setNid(String nid) {
		Nid = nid;
	}
	public String getNname() {
		return Nname;
	}
	public void setNname(String nname) {
		Nname = nname;
	}
	public String getNsex() {
		return Nsex;
	}
	public void setNsex(String nsex) {
		Nsex = nsex;
	}
	public int getNage() {
		return Nage;
	}
	public void setNage(int nage) {
		Nage = nage;
	}
	public String getNtele() {
		return Ntele;
	}
	public void setNtele(String ntele) {
		Ntele = ntele;
	}
	public String getNaddr() {
		return Naddr;
	}
	public void setNaddr(String naddr) {
		Naddr = naddr;
	}
	public String getNstatus() {
		return Nstatus;
	}
	public void setNstatus(String nstatus) {
		Nstatus = nstatus;
	}

	public int getNageL() {
		return NageL;
	}

	public void setNageL(int nageL) {
		NageL = nageL;
	}

	public int getNageH() {
		return NageH;
	}

	public void setNageH(int nageH) {
		NageH = nageH;
	}
	
}
