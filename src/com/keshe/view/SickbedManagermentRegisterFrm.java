package com.keshe.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.keshe.dao.DoctorDao;
import com.keshe.dao.NurseDao;
import com.keshe.dao.PatientDao;
import com.keshe.dao.UserDaoSub;
import com.keshe.model.Doctor;
import com.keshe.model.Nurse;
import com.keshe.model.Patient;
import com.keshe.model.User;
import com.keshe.tool.Connmethod;
import com.keshe.tool.StringUtil;
import com.mysql.jdbc.Connection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.ImageIcon;

public class SickbedManagermentRegisterFrm{
	Connmethod connmethod=new Connmethod();
	UserDaoSub userDaosub=new UserDaoSub();
	DoctorDao doctorDao=new DoctorDao();
	PatientDao patientDao=new PatientDao();
	NurseDao nurseDao=new NurseDao();
	private JTextField accountTxt2;
	private JTextField nameTxt2;
	private JPasswordField passwordTxt2;
	public JPanel panel;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public SickbedManagermentRegisterFrm(JPanel login) {
		panel = new JPanel();
		//改变系统默认字体
		//居中
		panel.setBounds(0, 0, 395, 410);
		panel.setLayout(null);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SickbedManagermentRegisterFrm.class.getResource("/resource/\u533B\u9662\u75C5\u623F\u7BA1\u740610.png")));
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 10, 374, 115);
		panel.add(lblNewLabel);
		
		accountTxt2 = new JTextField();
		accountTxt2.setBounds(123, 131, 93, 21);
		panel.add(accountTxt2);
		accountTxt2.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(SickbedManagermentRegisterFrm.class.getResource("/resource/\u7528\u6237\u540D\u80CC\u666F3.png")));
		lblNewLabel_1.setBounds(20, 115, 270, 53);
		panel.add(lblNewLabel_1);
		
		passwordTxt2 = new JPasswordField();
		passwordTxt2.setBounds(123, 178, 93, 21);
		panel.add(passwordTxt2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(SickbedManagermentRegisterFrm.class.getResource("/resource/\u5BC6\u7801\u80CC\u666F2.png")));
		lblNewLabel_2.setBounds(20, 162, 270, 53);
		panel.add(lblNewLabel_2);
		
		JComboBox typeTxt2 = new JComboBox();
		typeTxt2.setModel(new DefaultComboBoxModel(new String[] {"\u7BA1\u7406\u5458", "\u533B\u751F", "\u62A4\u58EB", "\u75C5\u4EBA"}));
		typeTxt2.setBounds(123, 269, 93, 21);
		panel.add(typeTxt2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(SickbedManagermentRegisterFrm.class.getResource("/resource/\u8EAB\u4EFD\u80CC\u666F\u672A\u6807\u9898-.png")));
		lblNewLabel_3.setBounds(20, 256, 270, 48);
		panel.add(lblNewLabel_3);
		
		nameTxt2 = new JTextField();
		nameTxt2.setBounds(123, 225, 93, 21);
		panel.add(nameTxt2);
		nameTxt2.setColumns(10);
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(SickbedManagermentRegisterFrm.class.getResource("/resource/\u59D3\u540D.png")));
		lblNewLabel_4.setBounds(20, 210, 256, 48);
		panel.add(lblNewLabel_4);
		//注册
		JButton register = new JButton("");
		register.setIcon(new ImageIcon(SickbedManagermentRegisterFrm.class.getResource("/resource/\u6CE8\u518C.png")));
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Uaccount=accountTxt2.getText();
				String Upassword=new String(passwordTxt2.getPassword());
				String   Utype=(String) typeTxt2.getSelectedItem();
				String Uname=nameTxt2.getText();
				if(StringUtil.isEmpty(Uaccount)){
					JOptionPane.showMessageDialog(null, "帐号不能为空！");
					return;
				}
				if(StringUtil.isEmpty(Uname)){
					JOptionPane.showMessageDialog(null, "姓名不能为空！");
					return;
				}
				if(StringUtil.isEmpty(Upassword)){
					JOptionPane.showMessageDialog(null, "密码不能为空！");
					return;
				}
				 User user= new User (Uaccount,Uname,Upassword,Utype);
		          Connection conn =connmethod.createConn();
		          try{
		        	  if(userDaosub.UserPrimary(conn,user)){
							JOptionPane.showMessageDialog(null, "帐号已经存在！");
							return;
		        	  }
		        	  if(Utype=="管理员"||Utype=="医生"){
		        	  Doctor doc=new Doctor(Uaccount,Uname);
		        	  ResultSet rs = doctorDao.DoctorSelect(conn,doc);
		        	  if(!rs.next()){		        		
		        			  JOptionPane.showMessageDialog(null, "该身份或姓名不符合请重新注册！");
								return;
		        		  }
		        	  }
		        	  if(Utype=="护士"){
			        	  Nurse nur=new Nurse(Uaccount,Uname) ;
			        	  ResultSet rs1=nurseDao.NurseSelect(conn,nur);
			        	  if(!rs1.next()){
			        		  JOptionPane.showMessageDialog(null, "该身份或姓名不符合请重新注册！");
								return;
			        	  }
		        	  }
		        	  if(Utype=="病人"){
			        	  Patient pat=new Patient(Uaccount,Uname,null);
						ResultSet rs2=patientDao.PatientSelect(conn,pat);
						if(!rs2.next()){			        		  			 
			        			  JOptionPane.showMessageDialog(null, "该身份不符合请重新注册！");
									return;
			        		  }
						}
		        	  
		        	 if(userDaosub.UserInsert(conn,user)==1){
						JOptionPane.showMessageDialog(null, "注册成功！");
						login.setVisible(true);
						panel.setVisible(false);
		        	 }
		     
		        	  
		          } catch(Exception e1){
		        	  e1.printStackTrace();
		        	  JOptionPane.showMessageDialog(null, "注册失败！");
		        	  
		          }	
		          finally{
						connmethod.closeConn();
					}
		          
			}
		});
		register.setBounds(168, 324, 98, 39);
		panel.add(register);
		
		JButton quit = new JButton("");
		quit.setIcon(new ImageIcon(SickbedManagermentRegisterFrm.class.getResource("/resource/\u91CD\u7F6E.png")));
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountTxt2.setText("");
	        	  nameTxt2.setText("");
	        	  passwordTxt2.setText("");
			}
		});
		quit.setBounds(20, 324, 98, 39);
		panel.add(quit);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SickbedManagermentRegisterFrm.class.getResource("/resource/\u80CC\u666F3.png")));
		label.setBounds(0, 0, 395, 410);
		panel.add(label);
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblNewLabel, lblNewLabel_1, lblNewLabel_2, accountTxt2, lblNewLabel_3, lblNewLabel_4, nameTxt2, passwordTxt2, typeTxt2, register, quit}));
	}
}
