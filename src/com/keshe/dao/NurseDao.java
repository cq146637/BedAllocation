package com.keshe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.keshe.model.Nurse;
import com.keshe.model.User;
import com.keshe.tool.StringUtil;

public class NurseDao {
	public int NurseInsert(Connection conn,Nurse nur) throws Exception{
		String sql ="insert into Nurse values(?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,nur.getNid());
		pstmt.setString(2,nur.getNname());
		pstmt.setString(3,nur.getNsex());
		pstmt.setInt(4,nur.getNage());
		pstmt.setString(5,nur.getNtele());
		pstmt.setString(6,nur.getNaddr());
		pstmt.setString(7,nur.getNstatus());
		return pstmt.executeUpdate();
	}
	public int NurseDelete(Connection conn,Nurse nur) throws Exception{
		String sql ="delete from Nurse where Nid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,nur.getNid());
		return pstmt.executeUpdate();
	}
	public int NurseUpdate(Connection conn,Nurse nur) throws Exception{
		String sql ="update Nurse set Nid=?,Nname=?,Nsex=?,Nage=?,Ntele=?,Naddr=?,Nstatus=? where Nid=?";
		PreparedStatement pstmt;
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,nur.getNid());
		pstmt.setString(2,nur.getNname());
		pstmt.setString(3,nur.getNsex());
		pstmt.setInt(4,nur.getNage());
		pstmt.setString(5,nur.getNtele());
		pstmt.setString(6,nur.getNaddr());
		pstmt.setString(7,nur.getNstatus());
		pstmt.setString(8,nur.getNid());
		return pstmt.executeUpdate();
	}
	public ResultSet NurseSelect(Connection conn,Nurse nur) throws Exception{
		StringBuffer sb=new StringBuffer("select * from Nurse");
		if(StringUtil.isNotEmpty(nur.getNid())){
			sb.append(" and Nid like '%"+nur.getNid()+"%'");
		}
		if(StringUtil.isNotEmpty(nur.getNname())){
			sb.append(" and Nname like '%"+nur.getNname()+"%'");
		}
		if(StringUtil.isNotEmpty(nur.getNsex())){
			sb.append(" and Nsex like '%"+nur.getNsex()+"%'");
		}
		if(nur.getNageL()!=0){
			sb.append(" and Nage>"+nur.getNageL());
		}
		if(nur.getNageH()!=0){
			sb.append(" and Nage<"+nur.getNageH());
		}
		if(StringUtil.isNotEmpty(nur.getNtele())){
			sb.append(" and Ntele like '%"+nur.getNtele()+"%'");
		}
		if(StringUtil.isNotEmpty(nur.getNaddr())){
			sb.append(" and Naddr like '%"+nur.getNaddr()+"%'");
		}
		PreparedStatement pstmt = conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	public boolean NursePrimary(Connection conn,Nurse nur) throws Exception{
		boolean tr = false;
		String sql = "select * from Nurse where Nid='"+nur.getNid()+"'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			tr = true;
		}
		return tr;
	}
}
