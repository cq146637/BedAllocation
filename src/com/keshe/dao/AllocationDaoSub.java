package com.keshe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.keshe.model.Allocation;
import com.keshe.tool.StringUtil;

public class AllocationDaoSub {
	public ResultSet AllocationSelect(Connection conn,Allocation allo) throws Exception{
		StringBuffer sb=new StringBuffer("select * from Allocation");
		if(StringUtil.isNotEmpty(allo.getBid())){
			sb.append(" and Bid like '%"+allo.getBid()+"%'");
		}
		if(StringUtil.isNotEmpty(allo.getPid())){
			sb.append(" and Pid like '%"+allo.getPid()+"%'");
		}
		PreparedStatement pstmt = conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
}
