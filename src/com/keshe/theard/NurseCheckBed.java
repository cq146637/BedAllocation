package com.keshe.theard;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.keshe.dao.BedDao;
import com.keshe.model.Bed;
import com.keshe.tool.Connmethod;

public class NurseCheckBed implements Runnable{
	String Nid;//当前护士号
	int Count;//当前护士巡查病床数量
	BedDao beddao = new BedDao();
	Connmethod util = new Connmethod();
	public NurseCheckBed(String Id){
		Nid = Id;
	}
	public void run(){
		while(true){
			try {
				Thread.sleep(3000000);//每过5分钟刷新一次查房记录，模拟每日巡检
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
				JOptionPane.showMessageDialog(null, "今天您要巡查的病床有["+Count+"]");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				util.closeConn();
			}
			
		}
	}
}
