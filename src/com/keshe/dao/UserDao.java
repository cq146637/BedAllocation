package com.keshe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.keshe.model.User;
import com.keshe.tool.StringUtil;

public class UserDao {
	public int UserInsert(Connection conn,User user) throws Exception{
		String sql ="insert into User values(?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,user.getUaccount());
		pstmt.setString(2,user.getUname());
		pstmt.setString(3,user.getUpassword());
		pstmt.setString(4,user.getUtype());
		return pstmt.executeUpdate();
	}
	public int UserDelete(Connection conn,User user) throws Exception{
		String sql ="delete from User where Uaccount=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,user.getUaccount());
		return pstmt.executeUpdate();
	}
	public int UserUpdate(Connection conn,User user) throws Exception{
		String sql ="update User set Uname=?, Uaccount=?, Upassword=?, Utype=? where Uaccount=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,user.getUname());
		pstmt.setString(2,user.getUaccount());
		pstmt.setString(3,user.getUpassword());
		pstmt.setString(4,user.getUtype());
		pstmt.setString(5,user.getUaccount());
		return pstmt.executeUpdate();
	}
	public ResultSet UserSelect(Connection conn,User user) throws Exception{
		StringBuffer sb=new StringBuffer("select * from User");
		if(StringUtil.isNotEmpty(user.getUaccount())){
			sb.append(" and Uaccount like '%"+user.getUaccount()+"%'");
		}
		if(StringUtil.isNotEmpty(user.getUname())){
			sb.append(" and Uname like '%"+user.getUname()+"%'");
		}
		if(StringUtil.isNotEmpty(user.getUtype())){
			sb.append(" and Utype like '%"+user.getUtype()+"%'");
		}
		PreparedStatement pstmt = conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	public boolean UserPrimary(Connection conn,User user) throws Exception{
		boolean tr = false;
		String sql = "select * from User where Uaccount='"+user.getUaccount()+"'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			tr = true;
		}
		return tr;
	}
}
