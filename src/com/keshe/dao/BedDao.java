package com.keshe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.keshe.model.Bed;
import com.keshe.model.User;
import com.keshe.tool.StringUtil;

public class BedDao {
	public int BedInsert(Connection conn,Bed bed) throws Exception{
		String sql ="insert into Bed values(?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,bed.getBid());
		pstmt.setString(2,bed.getNid());
		pstmt.setString(3,bed.getBstatus());
		pstmt.setString(4,bed.getChecks());
		return pstmt.executeUpdate();
	}
	public int BedDelete(Connection conn,Bed bed) throws Exception{
		String sql ="delete from Bed where Bid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,bed.getBid());
		return pstmt.executeUpdate();
	}
	public int BedUpdate(Connection conn,Bed bed) throws Exception{
		String sql ="update Bed set Bid=?,Nid=?,Bstatus=?,Checks=? where Bid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,bed.getBid());
		pstmt.setString(2,bed.getNid());
		pstmt.setString(3,bed.getBstatus());
		pstmt.setString(4,bed.getChecks());
		pstmt.setString(5,bed.getBid());
		return pstmt.executeUpdate();
	}
	public ResultSet BedSelect(Connection conn,Bed bed) throws Exception{
		StringBuffer sb=new StringBuffer("select * from Bed");
		if(StringUtil.isNotEmpty(bed.getBid())){
			sb.append(" and Bid like '%"+bed.getBid()+"%'");
		}
		if(StringUtil.isNotEmpty(bed.getNid())){
			sb.append(" and Nid like '%"+bed.getNid()+"%'");
		}
		PreparedStatement pstmt = conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	public boolean BedPrimary(Connection conn,Bed bed) throws Exception{
		boolean tr = false;
		String sql = "select * from Bed where Bid='"+bed.getBid()+"'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			tr = true;
		}
		return tr;
	}
}
