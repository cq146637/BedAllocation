package com.keshe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.keshe.model.User;
import com.keshe.tool.StringUtil;

public class UserDaoSub extends UserDao {
	public ResultSet UserSelect(Connection conn,User user) throws Exception{
		StringBuffer sb=new StringBuffer("select * from User");
		if(StringUtil.isNotEmpty(user.getUaccount())){
			sb.append(" and Uaccount like '%"+user.getUaccount()+"%'");
		}
		if(StringUtil.isNotEmpty(user.getUpassword())){
			sb.append(" and Upassword like '%"+user.getUpassword()+"%'");
		}
		if(StringUtil.isNotEmpty(user.getUtype())){
			sb.append(" and Utype like '%"+user.getUtype()+"%'");
		}
		PreparedStatement pstmt = conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
}
