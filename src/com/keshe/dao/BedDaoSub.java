package com.keshe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.keshe.model.Bed;
import com.keshe.tool.StringUtil;

public class BedDaoSub extends BedDao {
	public ResultSet BedSelect(Connection conn,Bed bed) throws Exception{
		StringBuffer sb=new StringBuffer("select * from Bed");
		if(StringUtil.isNotEmpty(bed.getBid())){
			sb.append(" and Bid like '%"+bed.getBid()+"%'");
		}
		PreparedStatement pstmt = conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
}
