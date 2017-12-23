package com.keshe.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JTextField;

import org.omg.CORBA.FloatSeqHelper;

import com.keshe.dao.AllocationDao;
import com.keshe.dao.BedDao;
import com.keshe.dao.DoctorDao;
import com.keshe.dao.NurseDao;
import com.keshe.dao.PatientDao;
import com.keshe.dao.UserDao;
import com.keshe.model.Allocation;
import com.keshe.model.Bed;
import com.keshe.model.Doctor;
import com.keshe.model.Nurse;
import com.keshe.model.Patient;
import com.keshe.model.User;
import com.keshe.tool.Connmethod;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;

public class StatisticsIntFrm {
	private JTextField userCount;
	private JTextField userS1;
	private JTextField userS2;
	private JTextField docCount;
	private JTextField docS1;
	private JTextField docS2;
	private JTextField nurCount;
	private JTextField nurS1;
	private JTextField nurS2;
	private JTextField patCount;
	private JTextField patS1;
	private JTextField patS2;
	private JTextField bedCount;
	private JTextField bedS1;
	private JTextField bedS2;
	private JTextField alloCount;
	private JTextField alloS1;
	private JTextField alloS2;
	public JPanel panel;
	AllocationDao allodao = new AllocationDao();
	BedDao beddao = new BedDao();
	DoctorDao docdao = new DoctorDao();
	NurseDao nurdao = new NurseDao();
	PatientDao patdao = new PatientDao();
	UserDao userdao = new UserDao();
	Connection conn = (new Connmethod()).createConn();
	private int dCount = 0;//医生数量
	private int nCount = 0;//护士数量
	private int pCount = 0;//病人数量
	private int uCount = 0;//用户数量
	private int bCount = 0;//病床数量
	private int bS2 = 0;//未使用病床数量
	private int pS2 = 0;//未分配病人数量
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public StatisticsIntFrm(JPanel p) {
		panel = new JPanel();
		panel.setBounds(100, 100, 800, 500);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7CFB\u7EDF\u7EDF\u8BA1\u56FE");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 25));
		lblNewLabel.setBounds(337, 10, 154, 52);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u6570\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(100, 136, 60, 15);
		panel.add(lblNewLabel_1);
		
		userCount = new JTextField();
		userCount.setFont(new Font("宋体", Font.BOLD, 12));
		userCount.setEditable(false);
		userCount.setBounds(170, 133, 60, 21);
		panel.add(userCount);
		userCount.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5DF2\u6CE8\u518C\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		label_1.setBounds(100, 179, 60, 15);
		panel.add(label_1);
		
		userS1 = new JTextField();
		userS1.setFont(new Font("宋体", Font.BOLD, 12));
		userS1.setEditable(false);
		userS1.setBounds(170, 176, 60, 21);
		panel.add(userS1);
		userS1.setColumns(10);
		
		JLabel label_2 = new JLabel("\u672A\u6CE8\u518C\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 14));
		label_2.setBounds(100, 220, 60, 15);
		panel.add(label_2);
		
		userS2 = new JTextField();
		userS2.setFont(new Font("宋体", Font.BOLD, 12));
		userS2.setEditable(false);
		userS2.setBounds(170, 217, 60, 21);
		panel.add(userS2);
		userS2.setColumns(10);
		
		JLabel label_4 = new JLabel("\u533B\u751F\u6570\uFF1A");
		label_4.setFont(new Font("宋体", Font.PLAIN, 14));
		label_4.setBounds(340, 133, 60, 15);
		panel.add(label_4);
		
		docCount = new JTextField();
		docCount.setFont(new Font("宋体", Font.BOLD, 12));
		docCount.setEditable(false);
		docCount.setColumns(10);
		docCount.setBounds(410, 133, 60, 21);
		panel.add(docCount);
		
		JLabel label_5 = new JLabel("\u4E0A  \u73ED\uFF1A");
		label_5.setFont(new Font("宋体", Font.PLAIN, 14));
		label_5.setBounds(340, 179, 60, 15);
		panel.add(label_5);
		
		docS1 = new JTextField();
		docS1.setFont(new Font("宋体", Font.BOLD, 12));
		docS1.setEditable(false);
		docS1.setColumns(10);
		docS1.setBounds(410, 179, 60, 21);
		panel.add(docS1);
		
		JLabel label_6 = new JLabel("\u51FA  \u5DEE\uFF1A");
		label_6.setFont(new Font("宋体", Font.PLAIN, 14));
		label_6.setBounds(340, 220, 60, 15);
		panel.add(label_6);
		
		docS2 = new JTextField();
		docS2.setFont(new Font("宋体", Font.BOLD, 12));
		docS2.setEditable(false);
		docS2.setColumns(10);
		docS2.setBounds(410, 220, 60, 21);
		panel.add(docS2);
		
		JLabel label_8 = new JLabel("\u62A4\u58EB\u6570\uFF1A");
		label_8.setFont(new Font("宋体", Font.PLAIN, 14));
		label_8.setBounds(579, 133, 60, 15);
		panel.add(label_8);
		
		nurCount = new JTextField();
		nurCount.setFont(new Font("宋体", Font.BOLD, 12));
		nurCount.setEditable(false);
		nurCount.setColumns(10);
		nurCount.setBounds(649, 133, 60, 21);
		panel.add(nurCount);
		
		JLabel nurdsadasdfa = new JLabel("\u4E0A  \u73ED\uFF1A");
		nurdsadasdfa.setFont(new Font("宋体", Font.PLAIN, 14));
		nurdsadasdfa.setBounds(579, 179, 60, 15);
		panel.add(nurdsadasdfa);
		
		nurS1 = new JTextField();
		nurS1.setFont(new Font("宋体", Font.BOLD, 12));
		nurS1.setEditable(false);
		nurS1.setColumns(10);
		nurS1.setBounds(649, 179, 60, 21);
		panel.add(nurS1);
		
		JLabel label_10 = new JLabel("\u51FA  \u5DEE\uFF1A");
		label_10.setFont(new Font("宋体", Font.PLAIN, 14));
		label_10.setBounds(579, 220, 60, 15);
		panel.add(label_10);
		
		nurS2 = new JTextField();
		nurS2.setFont(new Font("宋体", Font.BOLD, 12));
		nurS2.setEditable(false);
		nurS2.setColumns(10);
		nurS2.setBounds(649, 220, 60, 21);
		panel.add(nurS2);
		
		JLabel label_12 = new JLabel("\u75C5\u4EBA\u6570\uFF1A");
		label_12.setFont(new Font("宋体", Font.PLAIN, 14));
		label_12.setBounds(100, 318, 60, 15);
		panel.add(label_12);
		
		patCount = new JTextField();
		patCount.setEditable(false);
		patCount.setFont(new Font("宋体", Font.BOLD, 12));
		patCount.setColumns(10);
		patCount.setBounds(170, 318, 60, 21);
		panel.add(patCount);
		
		JLabel label_13 = new JLabel("\u4F4F  \u9662\uFF1A");
		label_13.setFont(new Font("宋体", Font.PLAIN, 14));
		label_13.setBounds(100, 364, 60, 15);
		panel.add(label_13);
		
		patS1 = new JTextField();
		patS1.setFont(new Font("宋体", Font.BOLD, 12));
		patS1.setEditable(false);
		patS1.setColumns(10);
		patS1.setBounds(170, 364, 60, 21);
		panel.add(patS1);
		
		JLabel label_14 = new JLabel("\u672A\u5206\u914D\uFF1A");
		label_14.setFont(new Font("宋体", Font.PLAIN, 14));
		label_14.setBounds(100, 405, 60, 15);
		panel.add(label_14);
		
		patS2 = new JTextField();
		patS2.setFont(new Font("宋体", Font.BOLD, 12));
		patS2.setEditable(false);
		patS2.setColumns(10);
		patS2.setBounds(170, 405, 60, 21);
		panel.add(patS2);
		
		JLabel label_20 = new JLabel("\u5206\u914D\u6570\uFF1A");
		label_20.setFont(new Font("宋体", Font.PLAIN, 14));
		label_20.setBounds(579, 318, 60, 15);
		panel.add(label_20);
		
		alloCount = new JTextField();
		alloCount.setFont(new Font("宋体", Font.BOLD, 12));
		alloCount.setEditable(false);
		alloCount.setColumns(10);
		alloCount.setBounds(649, 318, 60, 21);
		panel.add(alloCount);
		
		JLabel label_21 = new JLabel("\u5BCC\u4F59\u91CF\uFF1A");
		label_21.setFont(new Font("宋体", Font.PLAIN, 14));
		label_21.setBounds(579, 364, 60, 15);
		panel.add(label_21);
		
		alloS1 = new JTextField();
		alloS1.setFont(new Font("宋体", Font.BOLD, 12));
		alloS1.setEditable(false);
		alloS1.setColumns(10);
		alloS1.setBounds(649, 364, 60, 21);
		panel.add(alloS1);
		
		JLabel label_22 = new JLabel("\u6539\u53D8\u91CF\uFF1A");
		label_22.setFont(new Font("宋体", Font.PLAIN, 14));
		label_22.setBounds(579, 405, 60, 15);
		panel.add(label_22);
		
		
//		button_1.setBounds(463, 454, 93, 36);
//		panel.add(button_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u7528\u6237\u4FE1\u606F\u7EDF\u8BA1", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(72, 98, 183, 162);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u533B\u751F\u4FE1\u606F\u7EDF\u8BA1", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(308, 98, 183, 162);
		panel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u62A4\u58EB\u4FE1\u606F\u7EDF\u8BA1", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(551, 98, 183, 162);
		panel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u75C5\u4EBA\u4FE1\u606F\u7EDF\u8BA1", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBounds(72, 286, 183, 162);
		panel.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u75C5\u5E8A\u4FE1\u606F\u7EDF\u8BA1", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBounds(308, 283, 183, 162);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel label_16 = new JLabel("\u75C5\u5E8A\u6570\uFF1A");
		label_16.setBounds(31, 33, 60, 15);
		panel_5.add(label_16);
		label_16.setFont(new Font("宋体", Font.PLAIN, 14));
		
		bedCount = new JTextField();
		bedCount.setBounds(101, 33, 60, 21);
		panel_5.add(bedCount);
		bedCount.setFont(new Font("宋体", Font.BOLD, 12));
		bedCount.setEditable(false);
		bedCount.setColumns(10);
		bedCount.setText(""+bCount);
		
		JLabel label_17 = new JLabel("\u4F7F  \u7528\uFF1A");
		label_17.setBounds(31, 79, 60, 15);
		panel_5.add(label_17);
		label_17.setFont(new Font("宋体", Font.PLAIN, 14));
		
		bedS1 = new JTextField();
		bedS1.setBounds(101, 79, 60, 21);
		panel_5.add(bedS1);
		bedS1.setFont(new Font("宋体", Font.BOLD, 12));
		bedS1.setEditable(false);
		bedS1.setColumns(10);
		bedS1.setText("0");
		
		JLabel label_18 = new JLabel("\u7A7A  \u95F2\uFF1A");
		label_18.setBounds(31, 120, 60, 15);
		panel_5.add(label_18);
		label_18.setFont(new Font("宋体", Font.PLAIN, 14));
		
		bedS2 = new JTextField();
		bedS2.setBounds(101, 120, 60, 21);
		panel_5.add(bedS2);
		bedS2.setFont(new Font("宋体", Font.BOLD, 12));
		bedS2.setEditable(false);
		bedS2.setColumns(10);
		bedS2.setText("0");
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "\u5206\u914D\u4FE1\u606F\u7EDF\u8BA1", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_6.setBounds(551, 286, 183, 162);
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		alloS2 = new JTextField();
		alloS2.setBounds(85, 114, 88, 21);
		panel_6.add(alloS2);
		alloS2.setFont(new Font("宋体", Font.BOLD, 12));
		alloS2.setEditable(false);
		alloS2.setColumns(10);
		
		JButton button = new JButton("\u5237  \u65B0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillJpanel();
			}
		});
		button.setBounds(250, 454, 93, 36);
		panel.add(button);
		
		JButton button_2 = new JButton("\u9000  \u51FA");
		
		button_2.setBounds(465, 455, 93, 36);
		panel.add(button_2);
		
		JButton button_1 = new JButton("\u9000  \u51FA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(false);
			}
		});
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(false);
				p.removeAll();
			}
		});
		
		fillJpanel();
	}
	private void fillJpanel(){
		dCount = 0;//医生数量
		nCount = 0;//护士数量
		pCount = 0;//病人数量
		uCount = 0;//用户数量
		bCount = 0;//病床数量
		{
			//医生信息统计块
			Doctor doc = new Doctor();
			int dS1 = 0;//上班人数
			int dS2 = 0;//出差人数
			try {
				ResultSet rs = docdao.DoctorSelect(conn, doc);
				while(rs.next()){
					if(rs.getString("Dstatus").equals("上班")){
						dS1++;
					}
					else {
						dS2++;
					}
					dCount++;
				}
				docCount.setText(""+dCount);
				docS1.setText(""+dS1);
				docS2.setText(""+dS2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		{
			//护士信息统计
			Nurse nur = new Nurse();
			int nS1 = 0;//上班人数
			int nS2 = 0;//出差人数
			try {
				ResultSet rs = nurdao.NurseSelect(conn, nur);
				while(rs.next()){
					if(rs.getString("Nstatus").equals("上班")){
						nS1++;
					}
					else {
						nS2++;
					}
					nCount++;
				}
				nurCount.setText(""+nCount);
				nurS1.setText(""+nS1);
				nurS2.setText(""+nS2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		{
			//病人信息统计
			Patient pat = new Patient();
			int pS1 = 0;//住院人数
			pS2 = 0;//未分配人数
			try {
				ResultSet rs = patdao.PatientSelect(conn, pat);
				while(rs.next()){
					if(rs.getString("Pstatus").equals("住院")){
						pS1++;
					}
					else {
						pS2++;
					}
					pCount++;
				}
				patCount.setText(""+pCount);
				patS1.setText(""+pS1);
				patS2.setText(""+pS2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		{
			//病床信息统计
			Bed bed = new Bed();
			int bS1 = 0;//使用数
			bS2 = 0;//空闲数
			try {
				ResultSet rs = beddao.BedSelect(conn, bed);
				while(rs.next()){
					if(rs.getString("Bstatus").equals("使用")){
						bS1++;
					}
					else {
						bS2++;
					}
					bCount++;
					bedCount.setText(""+bCount);
					bedS1.setText(""+bS1);
					bedS2.setText(""+bS2);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		{
			//用户信息统计
			User user = new User();
			try {
				ResultSet rs = userdao.UserSelect(conn, user);
				while(rs.next()){
					uCount++;
				}
				userCount.setText(""+(nCount+pCount+dCount));
				userS1.setText(""+uCount);
				userS2.setText(""+(nCount+pCount+dCount-uCount));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		{
			//分配信息统计
			Allocation allo = new Allocation();
			int aCount = 0;
			try {
				ResultSet rs = allodao.AllocationSelect(conn, allo);
				while(rs.next()){
					aCount++;
				}
				if(bCount-pCount==0){
					alloS2.setText("增加病床数量");
				}
				else
					alloS2.setText("减少病床数量");
				alloCount.setText(""+aCount);
				alloS1.setText(""+(bS2-pS2));
				if(bCount-pCount<10){
					alloS2.setText("增加病床量");
				}
				else
					alloS2.setText("减少病床量");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
