package com.keshe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.keshe.model.Nurse;
import com.keshe.tool.StringUtil;

public class NurseDaoSub extends NurseDao {
	public ResultSet NurseSelect(Connection conn,Nurse nur) throws Exception{
		StringBuffer sb=new StringBuffer("select * from Nurse");
		if(StringUtil.isNotEmpty(nur.getNid())){
			sb.append(" and Nid like '%"+nur.getNid()+"%'");
		}
		PreparedStatement pstmt = conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
}
