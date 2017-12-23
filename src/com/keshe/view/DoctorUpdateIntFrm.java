package com.keshe.view;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.keshe.dao.DoctorDao;
import com.keshe.dao.PatientDao;
import com.keshe.dao.UserDao;
import com.keshe.model.Doctor;
import com.keshe.model.Patient;
import com.keshe.model.User;
import com.keshe.tool.Connmethod;
import com.keshe.tool.StringUtil;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.print.Doc;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.DropMode;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;

public class DoctorUpdateIntFrm  extends JPanel {
	private JTextField DidTxt;
	private JTextField DnameTxt;
	private JTextField DteleTxt;
	private JTextField DpositionTxt;
	private Connmethod comd = new Connmethod();
	private JTable table;
	private final JTable DoctorTable = new JTable();
	DoctorDao doctorDao = new DoctorDao();
	UserDao userdao = new UserDao();
	public JPanel panel;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public DoctorUpdateIntFrm(JPanel p) {
		panel = new JPanel();
		panel.setBounds(100, 100, 800, 500);
		panel.setLayout(null);
		
		JLabel lable = new JLabel("\u533B\u751F\u53F7\uFF1A");
		lable.setBounds(80, 283, 72, 30);
		panel.add(lable);
		
		JLabel label_1 = new JLabel("\u59D3  \u540D\uFF1A");
		label_1.setBounds(264, 283, 72, 30);
		panel.add(label_1);
		
		DidTxt = new JTextField();
		DidTxt.setColumns(10);
		DidTxt.setBounds(123, 293, 117, 21);
		panel.add(DidTxt);
		
		DnameTxt = new JTextField();
		DnameTxt.setColumns(10);
		DnameTxt.setBounds(307, 292, 117, 21);
		panel.add(DnameTxt);
		
		JButton button = new JButton("\u4FEE\u6539");
		button.setBounds(80, 409, 93, 42);
		panel.add(button);
		
		JButton button_1 = new JButton("\u5220\u9664");
		button_1.setBounds(216, 409, 93, 42);
		panel.add(button_1);
		
		JButton button_2 = new JButton("\u63D2\u5165");
		button_2.setBounds(352, 409, 93, 42);
		panel.add(button_2);
		
		JButton button_3 = new JButton("\u91CD\u7F6E");
		button_3.setBounds(488, 409, 93, 42);
		panel.add(button_3);
		
		JButton button_4 = new JButton("\u9000\u51FA");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				p.removeAll();
			}
		});
		button_4.setBounds(623, 409, 93, 42);
		panel.add(button_4);
		
		JLabel label_2 = new JLabel("\u6027  \u522B\uFF1A");
		label_2.setBounds(444, 283, 72, 30);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("\u5E74  \u9F84\uFF1A");
		label_3.setBounds(80, 323, 61, 30);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("\u7535  \u8BDD\uFF1A");
		label_4.setBounds(80, 363, 72, 30);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("\u5730  \u5740\uFF1A");
		label_5.setBounds(443, 323, 61, 30);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("\u72B6  \u6001\uFF1A");
		label_6.setBounds(264, 323, 72, 30);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("\u804C  \u4F4D\uFF1A");
		label_7.setBounds(264, 363, 72, 30);
		panel.add(label_7);
		
		DteleTxt = new JTextField();
		DteleTxt.setColumns(10);
		DteleTxt.setBounds(123, 369, 117, 21);
		panel.add(DteleTxt);
		
		DpositionTxt = new JTextField();
		DpositionTxt.setColumns(10);
		DpositionTxt.setBounds(310, 372, 117, 21);
		panel.add(DpositionTxt);
		
		JRadioButton rbWomen = new JRadioButton("\u5973");
		rbWomen.setSelected(true);
		rbWomen.setBounds(507, 285, 50, 27);
		panel.add(rbWomen);
		
		JRadioButton rbMen = new JRadioButton("\u7537");
		rbMen.setBounds(563, 285, 50, 27);
		panel.add(rbMen);
		
		JTextArea DaddrTxt = new JTextArea();
		DaddrTxt.setLineWrap(true);
		DaddrTxt.setBounds(496, 323, 117, 68);
		panel.add(DaddrTxt);
		
		JComboBox cbDstatus = new JComboBox();
		cbDstatus.setModel(new DefaultComboBoxModel(new String[] {"\u4E0A\u73ED", "\u51FA\u5DEE"}));
		cbDstatus.setBounds(310, 332, 117, 21);
		panel.add(cbDstatus);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 23, 758, 205);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Did", "Dname", "Dsex", "Dage", "Dtele", "Daddr", "Dstatus", "Dposition"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setPreferredWidth(52);
		table.getColumnModel().getColumn(2).setPreferredWidth(34);
		table.getColumnModel().getColumn(3).setPreferredWidth(36);
		table.getColumnModel().getColumn(4).setPreferredWidth(96);
		table.getColumnModel().getColumn(5).setPreferredWidth(154);
		table.getColumnModel().getColumn(6).setPreferredWidth(37);
		
		JButton button_5 = new JButton("\u67E5\u8BE2");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		button_5.setBounds(623, 351, 93, 42);
		panel.add(button_5);
		
		JSpinner DageTxt = new JSpinner();
		DageTxt.setModel(new SpinnerNumberModel(0, 0, 150, 1));
		DageTxt.setBounds(123, 329, 117, 21);
		panel.add(DageTxt);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u67E5\u8BE2\u4FE1\u606F\u680F\u76EE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 255, 780, 219);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 10, 780, 231);
		panel.add(panel_2);

		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DidTxt.setText("");
				DnameTxt.setText("");
				DageTxt.setValue(0);
				DteleTxt.setText("");
				DpositionTxt.setText("");
				DaddrTxt.setText("");
				rbWomen.setSelected(true);
				rbMen.setSelected(false);
				fillTable(new Doctor());
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//修改
				String Did = DidTxt.getText();			
				String Dname = DnameTxt.getText();
				String Dage = String.valueOf(DageTxt.getValue());
				String Dtele = DteleTxt.getText();
				String Daddr = DaddrTxt.getText();
				String Dposition = DpositionTxt.getText();
				if(StringUtil.isEmpty(Did)){
					JOptionPane.showMessageDialog(null, "号码不能为空!");
					return;
				}		
				if(StringUtil.isEmpty(Dname)){
					JOptionPane.showMessageDialog(null, "姓名不能为空!");
					return;
				}		
				if(StringUtil.isEmpty(Dage)){
					JOptionPane.showMessageDialog(null, "年龄不能为空!");
					return;
				}
				if(StringUtil.isEmpty(Dtele)){
					JOptionPane.showMessageDialog(null, "电话不能为空!");
					return;
				}
				if(StringUtil.isEmpty(Dposition)){
					JOptionPane.showMessageDialog(null, "职位不能为空!");
					return;
				}
				String Dsex = null;
				if(rbWomen.isSelected()){
					Dsex = "女";
				}else if(rbMen.isSelected()){
					Dsex = "男";
				}
				String Dstatus = (String)cbDstatus.getSelectedItem();
				DoctorDao doctorDao = new DoctorDao();
				Connection conn = comd.createConn();
				Doctor doc = new Doctor(Did, Dname, Dsex, Integer.parseInt(Dage), Dtele, Daddr, Dstatus, Dposition);
				try {
					if((doctorDao.DoctorPrimary(conn, doc))==false){
						JOptionPane.showMessageDialog(null, "该账号不存在，不能修改!");
					}
					
						int num = doctorDao.DoctorUpdate(conn, doc);
						if(num==1){
							JOptionPane.showMessageDialog(null, "修改成功!");
							fillTable(new Doctor());
						}else{
							JOptionPane.showMessageDialog(null, "修改失败!");}
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "修改失败!");
					System.out.println("222222");
				}
			
			}
		});
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//插入
				String Dname = DnameTxt.getText();
				String Dage = String.valueOf(DageTxt.getValue());
				String Dtele = DteleTxt.getText();
				String Daddr = DaddrTxt.getText();
				String Dposition = DpositionTxt.getText();
				if(StringUtil.isEmpty(Dname)){
					JOptionPane.showMessageDialog(null, "姓名不能为空!");
					return;
				}		
				if(StringUtil.isEmpty(Dage)){
					JOptionPane.showMessageDialog(null, "年龄不能为空!");
					return;
				}
				if(StringUtil.isEmpty(Dtele)){
					JOptionPane.showMessageDialog(null, "电话不能为空");
					return;
				}
				if(StringUtil.isEmpty(Dposition)){
					JOptionPane.showMessageDialog(null, "职位不能为空");
					return;
				}
				/*
				 * 获取性别
				 */
				String Dsex = null;
				if(rbWomen.isSelected()){
					Dsex = "女";
				}else if(rbMen.isSelected()){
					Dsex = "男";
				}
				String Dstatus = (String) cbDstatus.getSelectedItem();
				Connection conn = comd.createConn();	
				DoctorDao doctorDao = new DoctorDao();	
				//String Did = DidTxt.getText();
				
				String Did = null;				
				
				int i = 0;
				int m = 0;
				try {
					Doctor doctor1 = new Doctor();
					ResultSet rs = doctorDao.DoctorSelect(conn, doctor1);
					while(rs.next()){
						Did = rs.getString("Did");
						m = Integer.parseInt(Did.replaceAll("[^0-9]", ""));
						
						if(m>i){
							i = m;
						}
					}
					i = i+1;
					if(i<10){Did = "D0" + i;}
					if(i>9){Did = "D" + i;}
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				
				Doctor doctor = new Doctor(Did,Dname,Dsex,Integer.parseInt(Dage),Dtele,Daddr,Dstatus,Dposition);				
				try {
					int n = doctorDao.DoctorInsert(conn, doctor);
					if(n==1){ 
						JOptionPane.showMessageDialog(null, "添加成功");
						fillTable(new Doctor());
					}else{
						JOptionPane.showMessageDialog(null, "添加失败");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "添加失败");
				}
			}
		});
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//删除
				String Did = DidTxt.getText();
				DoctorDao doctorDao = new DoctorDao();
				Doctor doc = new Doctor(Did);
				Connection conn = comd.createConn();
				
				try {
					if((doctorDao.DoctorPrimary(conn, doc))==false){
						JOptionPane.showMessageDialog(null, "该账号不存在，不能删除!");
						return;
					}
					
						int num = doctorDao.DoctorDelete(conn, doc);
						if(num==1){
							JOptionPane.showMessageDialog(null, "删除成功!");
							fillTable(new Doctor());
							Patient patient = new Patient("",Did);
							User user = new User(Did);//删除用户表
							userdao.UserDelete(conn, user);
							PatientDao patientDao = new PatientDao();
							ResultSet rs = patientDao.PatientSelect(conn, patient);
							while(rs.next()){//更新病人信息
								Patient patient2 = new Patient();
								patient2.setPid(rs.getString("Pid"));
								patient2.setPname(rs.getString("Pname"));
								patient2.setPage(rs.getInt("Page"));
								patient2.setPsex(rs.getString("Psex"));
								patient2.setPtele(rs.getString("Ptele"));
								patient2.setPaddr(rs.getString("Paddr"));
								patient2.setPstatus(rs.getString("Pstatus"));	
								patient2.setPdescribe(rs.getString("Pdescribe"));
								patient2.setDid(null);
								patientDao.PatientUpdate(conn, patient2);
								
							}
						}else{
							JOptionPane.showMessageDialog(null, "删除失败!");}
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "删除失败!");
				
				}
				
			}
		});
		fillTable(new Doctor());
	}
	private void fillTable(Doctor doctor){
		DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
		defaultTableModel.setRowCount(0);
		Connection  conn=null;
		try {
			conn = comd.createConn();
			ResultSet rs = doctorDao.DoctorSelect(conn, doctor);
			while(rs.next()){
				Vector vector = new Vector();//defaultTableModel.addr
				vector.add(rs.getString("Did"));
				vector.add(rs.getString("Dname"));
				vector.add(rs.getString("DSex"));
				vector.add(rs.getString("Dage"));
				vector.add(rs.getString("Dtele"));
				vector.add(rs.getString("Daddr"));
				vector.add(rs.getString("Dstatus"));
				vector.add(rs.getString("Dposition"));
				defaultTableModel.addRow(vector);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			comd.closeConn();
		}
	} 
}
