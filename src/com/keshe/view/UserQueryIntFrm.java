package com.keshe.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.keshe.dao.UserDao;
import com.keshe.model.User;
import com.keshe.tool.Connmethod;

import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserQueryIntFrm {
	private JTable userTable;
	private JTextField userAccountTxt;
	private JTextField userNameTxt;
	Connmethod util = new Connmethod();
	UserDao userdao = new UserDao();
	private JButton button_1;
	private JTextField userType;
	public JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public UserQueryIntFrm(JPanel p) {
		panel = new JPanel();
		panel.setBounds(100, 100, 800, 500);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(81, 52, 634, 206);
		panel.add(scrollPane);
		
		userTable = new JTable();
		
		scrollPane.setViewportView(userTable);
		userTable.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		userTable.setFillsViewportHeight(true);
		userTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		userTable.setSurrendersFocusOnKeystroke(true);
		userTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5E10\u53F7", "\u59D3\u540D", "\u5BC6\u7801", "\u7C7B\u578B"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		userTable.getColumnModel().getColumn(0).setResizable(false);
		userTable.getColumnModel().getColumn(1).setResizable(false);
		userTable.getColumnModel().getColumn(2).setResizable(false);
		userTable.setColumnSelectionAllowed(true);
		userTable.setCellSelectionEnabled(true);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u67E5\u8BE2\u4FE1\u606F\u680F\u76EE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(70, 292, 658, 152);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("\u5E10  \u53F7\uFF1A");
		label.setBounds(50, 27, 54, 15);
		panel_1.add(label);
		
		userAccountTxt = new JTextField();
		userAccountTxt.setBounds(110, 24, 96, 21);
		panel_1.add(userAccountTxt);
		userAccountTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u59D3  \u540D\uFF1A");
		label_1.setBounds(251, 24, 54, 15);
		panel_1.add(label_1);
		
		userNameTxt = new JTextField();
		userNameTxt.setBounds(315, 21, 96, 21);
		panel_1.add(userNameTxt);
		userNameTxt.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.setBounds(90, 80, 93, 42);
		panel_1.add(button);
		
		button_1 = new JButton("\u9000\u51FA");
		button_1.setBounds(479, 80, 93, 42);
		panel_1.add(button_1);
		
		JLabel label_2 = new JLabel("\u7C7B  \u578B\uFF1A");
		label_2.setBounds(455, 24, 54, 15);
		panel_1.add(label_2);
		
		userType = new JTextField();
		userType.setBounds(519, 21, 86, 21);
		panel_1.add(userType);
		userType.setColumns(10);
		
		JButton button_2 = new JButton("\u91CD\u7F6E");
		button_2.setBounds(285, 80, 93, 42);
		panel_1.add(button_2);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(70, 34, 658, 239);
		panel.add(panel_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userAccountTxt.setText("");
				userNameTxt.setText("");
				userType.setText("");
				fillTable(new User());
			}
		});
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				p.removeAll();
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userAcc = userAccountTxt.getText();
				String userName = userNameTxt.getText();
				String userTy = userType.getText();
				User user = new User(userAcc,userName,userTy);
				fillTable(user);
			}
		});
		userTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				int row = userTable.getSelectedRow();
				userAccountTxt.setText((String) userTable.getValueAt(row, 0));
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
			conn= util.createConn();
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
			util.closeConn();
		}
	}
}
