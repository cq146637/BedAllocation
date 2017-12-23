package com.keshe.view;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.Panel;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.keshe.dao.DoctorDao;
import com.keshe.dao.NurseDao;
import com.keshe.dao.PatientDao;
import com.keshe.dao.UserDao;
import com.keshe.dao.UserDaoSub;
import com.keshe.model.Doctor;
import com.keshe.model.Nurse;
import com.keshe.model.Patient;
import com.keshe.model.User;
import com.keshe.tool.Connmethod;
import com.keshe.tool.StringUtil;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class UserUpdateIntFrm{
	/**
	 * 
	 */
	Connmethod  connmethod = new Connmethod();
	UserDao userdao = new UserDao();
	UserDao userdaosub = new UserDaoSub();
	DoctorDao doctordao = new DoctorDao();
	PatientDao patientdao = new PatientDao();
	NurseDao nursedao = new NurseDao();
	private JTextField userAccountTxt;
	private JTextField userNameTxt_1;
	private JTable userTable;
	private JTextField userAccount2;
	private JTextField userPasswordTxt;
	public Panel panel;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public UserUpdateIntFrm(JPanel p) {
		panel = new Panel();
		panel.setBackground(UIManager.getColor("EditorPane.background"));
		panel.setBounds(160, 60, 800, 500);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u5E10  \u53F7\uFF1A");
		label.setBounds(85, 295, 54, 15);
		panel.add(label);
		
		userAccountTxt = new JTextField();
		userAccountTxt.setBounds(149, 292, 116, 21);
		panel.add(userAccountTxt);
		userAccountTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u59D3  \u540D\uFF1A");
		label_1.setBounds(85, 353, 54, 15);
		panel.add(label_1);
		
		userNameTxt_1 = new JTextField();
		userNameTxt_1.setBounds(149, 350, 116, 21);
		panel.add(userNameTxt_1);
		userNameTxt_1.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5BC6  \u7801\uFF1A");
		label_2.setBounds(311, 292, 54, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("\u7C7B  \u578B \uFF1A");
		label_3.setBounds(311, 356, 54, 15);
		panel.add(label_3);
		
		JComboBox userTypeTxt = new JComboBox();
		userTypeTxt.setBounds(375, 353, 116, 21);
		userTypeTxt.setModel(new DefaultComboBoxModel(new String[] {"\u533B\u751F", "\u75C5\u4EBA", "\u62A4\u58EB", "\u7BA1\u7406\u5458"}));
		panel.add(userTypeTxt);
		userTypeTxt.getSelectedIndex();
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.setBounds(53, 401, 93, 39);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userAcc = userAccountTxt.getText();
				if(StringUtil.isEmpty(userAcc)){
					JOptionPane.showMessageDialog(null, "帐号不能为空！");
					return;
				}
				String userName = userNameTxt_1.getText();
				String userPass = String.valueOf(userPasswordTxt.getText());
				String userType = (String) userTypeTxt.getSelectedItem();
				Connection conn = connmethod.createConn();
				User user = new User(userAcc);
				try {
						//如果使用者没有填写相应的文本框默认不改变值
						{
							if(userdao.UserPrimary(conn, user)==false){
								JOptionPane.showMessageDialog(null, "用户不存在！");
								return;
							}
							ResultSet rs = userdaosub.UserSelect(conn, user);
							while(rs.next()){
								user.setUname(userName);
								if(StringUtil.isEmpty(userName)){
									user.setUname(rs.getString("Uname"));
								}
								user.setUpassword(userPass);
								if(StringUtil.isEmpty(userPass)){
									user.setUpassword(rs.getString("Upassword"));
								}
								user.setUtype(userType);
								if(StringUtil.isEmpty(userType)){
									user.setUtype(rs.getString("Utype"));
								}
							}
						}
					if(userdao.UserUpdate(conn, user)==1){
						JOptionPane.showMessageDialog(null, "修改成功！");
					}
					{//操作成功则刷新界面
						userAccountTxt.setText("");
						userNameTxt_1.setText("");
						userPasswordTxt.setText("");
						userAccount2.setText("");
						fillTable(new User());
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
					connmethod.closeConn();
				}
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setBounds(484, 401, 93, 39);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userAccountTxt.setText("");
				userNameTxt_1.setText("");
				userPasswordTxt.setText("");
				userAccount2.setText("");
				fillTable(new User());
			}
		});
		panel.add(btnNewButton_1);
		
		JButton button = new JButton("\u9000\u51FA");
		button.setBounds(628, 401, 93, 39);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				p.removeAll();
			}
		});
		panel.add(button);
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userAcc = userAccountTxt.getText();
				if(StringUtil.isEmpty(userAcc)){
					JOptionPane.showMessageDialog(null, "帐号不能为空！");
					return;
				}
				User user = new User(userAcc);
				Connection conn = connmethod.createConn();
				try {
					if(!userdao.UserPrimary(conn, user)){
						JOptionPane.showMessageDialog(null, "帐号不存在！");
						return;
					}
					if(userdao.UserDelete(conn, user)==1){
						JOptionPane.showMessageDialog(null, "删除成功！");
					}
					{//操作成功则刷新界面
						userAccountTxt.setText("");
						userNameTxt_1.setText("");
						userPasswordTxt.setText("");
						userAccount2.setText("");
						fillTable(new User());
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
					connmethod.closeConn();
				}
			}
		});
		btnNewButton_2.setBounds(196, 401, 93, 39);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u63D2\u5165");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userAcc = userAccountTxt.getText();
				if(StringUtil.isEmpty(userAcc)){
					JOptionPane.showMessageDialog(null, "帐号不能为空！");
					return;
				}
				String userName = userNameTxt_1.getText();
				if(StringUtil.isEmpty(userName)){
					JOptionPane.showMessageDialog(null, "姓名不能为空！");
					return;
				}
				String userPass = String.valueOf(userPasswordTxt.getText());
				if(StringUtil.isEmpty(userPass)){
					JOptionPane.showMessageDialog(null, "密码不能为空！");
					return;
				}
				String userType = (String) userTypeTxt.getSelectedItem();
				User user = new User(userAcc,userName,userPass,userType);
				Connection conn = connmethod.createConn();
					try {
						if(userdao.UserPrimary(conn, user)){
							JOptionPane.showMessageDialog(null, "帐号已经存在！");
							return;
						}
						if(userType=="管理员"||userType=="医生"){
				        	  Doctor doc=new Doctor(userAcc,userName);
				        	  ResultSet rs = doctordao.DoctorSelect(conn,doc);
				        	  if(!rs.next()){		        		
				        			  JOptionPane.showMessageDialog(null, "该身份或姓名不符合请重新注册！");
										return;
				        		  }
				        	  }
						if(userType=="护士"){
				        	  Nurse nur=new Nurse(userAcc,userName);
				        	  ResultSet rs1=nursedao.NurseSelect(conn,nur);
				        	  if(!rs1.next()){
				        		  JOptionPane.showMessageDialog(null, "该身份或姓名不符合请重新注册！");
									return;
				        	  }
			        	 }
						if(userType=="病人"){
				        	Patient pat=new Patient(userAcc,userName,null);
							ResultSet rs2=patientdao.PatientSelect(conn,pat);
							if(!rs2.next()){			        		  			 
				        			  JOptionPane.showMessageDialog(null, "该身份不符合请重新注册！");
										return;
				        		  }
						}
						if(userdao.UserInsert(conn, user)==1){
							JOptionPane.showMessageDialog(null, "插入成功！");
						}
						{//操作成功则刷新界面
							userAccountTxt.setText("");
							userNameTxt_1.setText("");
							userPasswordTxt.setText("");
							userAccount2.setText("");
							fillTable(new User());
						}
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}finally{
						connmethod.closeConn();
					}
				}
		});
		btnNewButton_3.setBounds(338, 401, 93, 39);
		panel.add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 23, 680, 212);
		panel.add(scrollPane);
		
		userTable = new JTable();
		scrollPane.setViewportView(userTable);
		userTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				int row = userTable.getSelectedRow();
				userAccountTxt.setText((String) userTable.getValueAt(row, 0));
			}
		});
		userTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5E10\u53F7", "\u59D3\u540D", "\u5BC6\u7801", "\u7C7B\u578B"
			}
		));
		userTable.setSurrendersFocusOnKeystroke(true);
		userTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		userTable.setFillsViewportHeight(true);
		userTable.setColumnSelectionAllowed(true);
		userTable.setCellSelectionEnabled(true);
		userTable.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel label_4 = new JLabel("\u5E10  \u53F7\uFF1A");
		label_4.setBounds(553, 289, 54, 15);
		panel.add(label_4);
		
		userAccount2 = new JTextField();
		userAccount2.setColumns(10);
		userAccount2.setBounds(617, 286, 116, 21);
		panel.add(userAccount2);
		
		JButton button_1 = new JButton("\u67E5\u8BE2");
		
		button_1.setBounds(640, 335, 93, 39);
		panel.add(button_1);
		
		userPasswordTxt = new JTextField();
		userPasswordTxt.setColumns(10);
		userPasswordTxt.setBounds(375, 289, 116, 21);
		panel.add(userPasswordTxt);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u7BA1\u7406\u4FE1\u606F\u680F\u76EE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(43, 260, 475, 129);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\u7B80\u5355\u67E5\u8BE2\u680F\u76EE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(530, 257, 213, 137);
		panel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(43, 10, 700, 237);
		panel.add(panel_3);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String userId = userAccount2.getText();
				User user = new User(userId);
				fillTable(user);
			}
		});
		fillTable(new User());
		
	}
	private void fillTable(User user)
	{
		DefaultTableModel dtm = (DefaultTableModel) userTable.getModel();
		dtm.setRowCount(0);
		Connection conn=null;
		try{
			conn= connmethod.createConn();
			ResultSet rs =userdao.UserSelect(conn,user);
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getString("Uaccount"));
				v.add(rs.getString("Uname"));
				v.add(rs.getString("Upassword"));
				v.add(rs.getString("Utype"));
				dtm.addRow(v);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connmethod.closeConn();
		}
	}
}
