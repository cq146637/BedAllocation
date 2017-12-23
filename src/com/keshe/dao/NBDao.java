package com.keshe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.keshe.model.Bed;
import com.keshe.tool.StringUtil;

public class NBDao {
	public ResultSet BNSelect(Connection conn,Bed bed) throws Exception{
		StringBuffer sb=new StringBuffer("select * from BN");
		if(StringUtil.isNotEmpty(bed.getBid())){
			sb.append(" and Bid like '%"+bed.getBid()+"%'");
		}
		if(StringUtil.isNotEmpty(bed.getNid())){
			sb.append(" and Nid like '%"+bed.getNid()+"%'");
		}
		PreparedStatement pstmt = conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
}
