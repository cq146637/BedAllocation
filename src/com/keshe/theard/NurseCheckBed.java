package com.keshe.theard;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.keshe.dao.BedDao;
import com.keshe.model.Bed;
import com.keshe.tool.Connmethod;

public class NurseCheckBed implements Runnable{
	String Nid;//��ǰ��ʿ��
	int Count;//��ǰ��ʿѲ�鲡������
	BedDao beddao = new BedDao();
	Connmethod util = new Connmethod();
	public NurseCheckBed(String Id){
		Nid = Id;
	}
	public void run(){
		while(true){
			try {
				Thread.sleep(3000000);//ÿ��5����ˢ��һ�β鷿��¼��ģ��ÿ��Ѳ��
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Count = 0;
			Connection conn = util.createConn();
			Bed bed = new Bed(null,Nid);
			try {
				ResultSet rs = beddao.BedSelect(conn, bed);
				while(rs.next()){
					bed.setBid(rs.getString("Bid"));
					bed.setBstatus(rs.getString("Bstatus"));
					bed.setNid(rs.getString("Nid"));
					bed.setChecks("0");
					beddao.BedUpdate(conn, bed);
					Count++;
				}
				JOptionPane.showMessageDialog(null, "������ҪѲ��Ĳ�����["+Count+"]");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				util.closeConn();
			}
			
		}
	}
}
