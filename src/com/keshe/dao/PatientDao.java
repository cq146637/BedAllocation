package com.keshe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.keshe.model.Nurse;
import com.keshe.model.Patient;
import com.keshe.tool.StringUtil;

public class PatientDao {
	public int PatientInsert(Connection conn,Patient pat) throws Exception{
		String sql ="insert into Patient values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,pat.getPid());
		pstmt.setString(2,pat.getPname());
		pstmt.setString(3,pat.getPsex());
		pstmt.setInt(4,pat.getPage());
		pstmt.setString(5,pat.getPtele());
		pstmt.setString(6,pat.getPaddr());
		pstmt.setString(7,pat.getPdescribe());
		pstmt.setString(8,pat.getPstatus());
		pstmt.setString(9,pat.getDid());
		return pstmt.executeUpdate();
	}
	public int PatientDelete(Connection conn,Patient pat) throws Exception{
		String sql ="delete from Patient where Pid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,pat.getPid());
		return pstmt.executeUpdate();
	}
	public int PatientUpdate(Connection conn,Patient pat) throws Exception{
		String sql ="update Patient set Pid=?,Pname=?,Psex=?,Page=?,Ptele=?,Paddr=?,Pdescribe=?,Pstatus=?,Did=? where Pid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,pat.getPid());
		pstmt.setString(2,pat.getPname());
		pstmt.setString(3,pat.getPsex());
		pstmt.setInt(4,pat.getPage());
		pstmt.setString(5,pat.getPtele());
		pstmt.setString(6,pat.getPaddr());
		pstmt.setString(7,pat.getPdescribe());
		pstmt.setString(8,pat.getPstatus());
		pstmt.setString(9,pat.getDid());
		pstmt.setString(10,pat.getPid());
		return pstmt.executeUpdate();
	}
	public ResultSet PatientSelect(Connection conn,Patient pat) throws Exception{
		StringBuffer sb=new StringBuffer("select * from Patient");
		if(StringUtil.isNotEmpty(pat.getPid())){
			sb.append(" and Pid like '%"+pat.getPid()+"%'");
		}
		if(StringUtil.isNotEmpty(pat.getDid())){
			sb.append(" and Did like '%"+pat.getDid()+"%'");
		}
		if(StringUtil.isNotEmpty(pat.getPaddr())){
			sb.append(" and Paddr like '%"+pat.getPaddr()+"%'");
		}
		if(StringUtil.isNotEmpty(pat.getPdescribe())){
			sb.append(" and Pdescribe like '%"+pat.getPdescribe()+"%'");
		}
		if(StringUtil.isNotEmpty(pat.getPname())){
			sb.append(" and Pname like '%"+pat.getPname()+"%'");
		}
		if(pat.getPage()!=0){
			sb.append(" and Page="+pat.getPage());
		}
		if(StringUtil.isNotEmpty(pat.getPsex())){
			sb.append(" and Psex like '%"+pat.getPsex()+"%'");
		}
		if(StringUtil.isNotEmpty(pat.getPstatus())){
			sb.append(" and Pstatus like '%"+pat.getPstatus()+"%'");
		}
		if(StringUtil.isNotEmpty(pat.getPtele())){
			sb.append(" and Ptele like '%"+pat.getPtele()+"%'");
		}
		PreparedStatement pstmt = conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	public boolean PatientPrimary(Connection conn,Patient pat) throws Exception{
		boolean tr = false;
		String sql = "select * from Patient where Pid='"+pat.getPid()+"'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			tr = true;
		}
		return tr;
	}
}
