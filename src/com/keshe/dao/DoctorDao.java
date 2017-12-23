package com.keshe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.keshe.model.Doctor;
import com.keshe.tool.StringUtil;

public class DoctorDao {
	public int DoctorInsert(Connection conn,Doctor doc) throws Exception{
		String sql ="insert into Doctor values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,doc.getDid());
		pstmt.setString(2,doc.getDname());
		pstmt.setString(3,doc.getDsex());
		pstmt.setInt(4,doc.getDage());
		pstmt.setString(5,doc.getDtele());
		pstmt.setString(6,doc.getDaddr());
		pstmt.setString(7,doc.getDstatus());
		pstmt.setString(8,doc.getDposition());
		return pstmt.executeUpdate();
	}
	public int DoctorDelete(Connection conn,Doctor doc) throws Exception{
		String sql ="delete from Doctor where Did=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,doc.getDid());
		return pstmt.executeUpdate();
	}
	public int DoctorUpdate(Connection conn,Doctor doc) throws Exception{
		String sql ="update Doctor set Did=?,Dname=?,Dsex=?,Dage=?,Dtele=?,Daddr=?,Dstatus=?,Dposition=? where Did=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,doc.getDid());
		pstmt.setString(2,doc.getDname());
		pstmt.setString(3,doc.getDsex());
		pstmt.setInt(4,doc.getDage());
		pstmt.setString(5,doc.getDtele());
		pstmt.setString(6,doc.getDaddr());
		pstmt.setString(7,doc.getDstatus());
		pstmt.setString(8,doc.getDposition());
		pstmt.setString(9,doc.getDid());
		System.out.println(pstmt);
		return pstmt.executeUpdate();
	}
	public ResultSet DoctorSelect(Connection conn,Doctor doc) throws Exception{
		StringBuffer sb=new StringBuffer("select * from Doctor");
		if(StringUtil.isNotEmpty(doc.getDid())){
			sb.append(" and Did like '%"+doc.getDid()+"%'");
		}
		if(StringUtil.isNotEmpty(doc.getDname())){
			sb.append(" and Dname like '%"+doc.getDname()+"%'");
		}
		if(StringUtil.isNotEmpty(doc.getDsex())){
			sb.append(" and Dsex like '%"+doc.getDsex()+"%'");
		}
		if(doc.getDage()!=0){
			sb.append(" and Dage = "+doc.getDage());
		}
		if(StringUtil.isNotEmpty(doc.getDtele())){
			sb.append(" and Dtele like '%"+doc.getDtele()+"%'");
		}
		if(StringUtil.isNotEmpty(doc.getDstatus())){
			sb.append(" and Dstatus like '%"+doc.getDstatus()+"%'");
		}
		if(StringUtil.isNotEmpty(doc.getDposition())){
			sb.append(" and Dposition like '%"+doc.getDposition()+"%'");
		}
		PreparedStatement pstmt = conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
		System.out.println(pstmt);
		return pstmt.executeQuery();
	}
	public boolean DoctorPrimary(Connection conn,Doctor doc) throws Exception{
		String sql = "select * from Doctor where Did = '"+doc.getDid()+"'";
		ResultSet rs = null;
		boolean bl = false;
		PreparedStatement pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()){
			bl = true;
		}
		return bl;
	} 
}
