package com.keshe.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import com.keshe.model.Allocation;
import com.keshe.model.Bed;
import com.keshe.tool.StringUtil;

public class AllocationDao {
	public int AllocationInsert(Connection conn,Allocation allo) throws Exception{
		String sql ="insert into Allocation values(?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,allo.getBid());
		pstmt.setString(2,allo.getPid());
		pstmt.setString(3,allo.getStime());
		pstmt.setString(4,allo.getEtime());
		return pstmt.executeUpdate();
	}
	public int AllocationDelete(Connection conn,Allocation allo) throws Exception{
		String sql ="delete from Allocation where Bid=? or Pid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,allo.getBid());
		pstmt.setString(2,allo.getPid());
		return pstmt.executeUpdate();
	}
	public int AllocationUpdate(Connection conn,Allocation allo) throws Exception{
		String sql ="update Allocation set Bid=?,Pid=?,Stime=?,Etime=? where Bid=? or Pid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,allo.getBid());
		pstmt.setString(2,allo.getPid());
		pstmt.setString(3,allo.getStime());
		pstmt.setString(4,allo.getEtime());
		pstmt.setString(5,allo.getBid());//只要Bid或者Pid其中一个有值就可以
		pstmt.setString(6,allo.getPid());
		return pstmt.executeUpdate();
	}
	public ResultSet AllocationSelect(Connection conn,Allocation allo) throws Exception{
		StringBuffer sb=new StringBuffer("select * from Allocation");
		if(StringUtil.isNotEmpty(allo.getBid())){
			sb.append(" and Bid like '%"+allo.getBid()+"%'");
		}
		if(StringUtil.isNotEmpty(allo.getPid())){
			sb.append(" and Pid like '%"+allo.getPid()+"%'");
		}
		if(StringUtil.isNotEmpty(allo.getStime())){
			sb.append(" and Stime>'"+allo.getStime()+"'");
		}
		if(StringUtil.isNotEmpty(allo.getEtime())){
			sb.append(" and Etime<'"+allo.getEtime()+"'");
		}
		PreparedStatement pstmt = conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	public boolean AllocationPrimary(Connection conn,Allocation allo) throws Exception{
		boolean tr = false;
		String sql = "select * from Allocation where Bid='"+allo.getBid()+"' or Pid='"+allo.getPid()+"'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			tr = true;
		}
		return tr;
	}
}
