package com.keshe.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.keshe.model.Patient;
import com.keshe.tool.StringUtil;

public class PatientDaoSub extends PatientDao {
	public ResultSet PatientSelect(Connection conn,Patient pat) throws Exception{
		StringBuffer sb=new StringBuffer("select * from Patient");
		if(StringUtil.isNotEmpty(pat.getPid())){
			sb.append(" and Pid like '%"+pat.getPid()+"%'");
		}
		PreparedStatement pstmt = conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
}