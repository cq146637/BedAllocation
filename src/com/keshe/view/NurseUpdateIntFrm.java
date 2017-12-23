package com.keshe.view;

import java.awt.Component;
import java.awt.EventQueue;
import java.security.acl.Group;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.keshe.dao.NurseDao;
import com.keshe.dao.NurseDaoSub;
import com.keshe.dao.PatientDao;
import com.keshe.dao.UserDao;
import com.keshe.model.Nurse;
import com.keshe.model.Patient;
import com.keshe.model.User;
import com.keshe.tool.Connmethod;
import com.keshe.tool.StringUtil;
import com.mysql.fabric.xmlrpc.base.Array;

import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JScrollPane;

public class NurseUpdateIntFrm {
	Connmethod util = new Connmethod();
	NurseDao nursedao = new NurseDao();
	NurseDao nursedaosub = new NurseDaoSub();
	UserDao userdao = new UserDao();
	private JTextField nurseName;
	private JTextField nurseTele;
	private JTextField nurseId;
	private JTable nurseTable;
	private JTextField nurseId2;
	public JPanel panel;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public NurseUpdateIntFrm(JPanel p) {
		panel = new JPanel();
		panel.setBounds(100, 100, 800, 500);
		panel.setLayout(null);
		
		ButtonGroup group = new ButtonGroup();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 44, 733, 183);
		panel.add(scrollPane);
		
		nurseTable = new JTable();
		scrollPane.setViewportView(nurseTable);
		nurseTable.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		nurseTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int row = nurseTable.getSelectedRow();
				nurseId.setText((String) nurseTable.getValueAt(row, 0));
			}
		});
		nurseTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u62A4\u58EB\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u5E74\u9F84", "\u7535\u8BDD", "\u72B6\u6001", "\u4F4F\u5740"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		nurseTable.getColumnModel().getColumn(0).setResizable(false);
		nurseTable.getColumnModel().getColumn(4).setPreferredWidth(91);
		nurseTable.getColumnModel().getColumn(6).setPreferredWidth(154);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "  \u7BA1\u7406\u4FE1\u606F\u680F\u76EE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(26, 253, 764, 225);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("\u59D3  \u540D\uFF1A");
		label.setBounds(27, 42, 54, 15);
		panel_1.add(label);
		
		nurseName = new JTextField();
		nurseName.setBounds(91, 39, 91, 21);
		panel_1.add(nurseName);
		nurseName.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6027  \u522B\uFF1A");
		label_1.setBounds(27, 82, 54, 15);
		panel_1.add(label_1);
		
		
		JRadioButton nurseSexM = new JRadioButton("\u7537");
		nurseSexM.setBounds(87, 78, 46, 23);
		panel_1.add(nurseSexM);
		group.add(nurseSexM);
		
		JRadioButton nurseSexF = new JRadioButton("\u5973");
		nurseSexF.setBounds(135, 78, 47, 23);
		panel_1.add(nurseSexF);
		group.add(nurseSexF);
		nurseSexF.setSelected(true);
		
		JLabel label_2 = new JLabel("\u5E74  \u9F84\uFF1A");
		label_2.setBounds(27, 125, 54, 15);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("\u7535  \u8BDD\uFF1A");
		label_3.setBounds(218, 128, 54, 15);
		panel_1.add(label_3);
		
		nurseTele = new JTextField();
		nurseTele.setBounds(282, 125, 91, 21);
		panel_1.add(nurseTele);
		nurseTele.setColumns(11);
		
		JLabel label_4 = new JLabel("\u72B6  \u6001\uFF1A");
		label_4.setBounds(218, 83, 54, 15);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("\u4F4F  \u5740\uFF1A");
		label_5.setBounds(397, 48, 54, 15);
		panel_1.add(label_5);
		
		JTextArea nurseAddr = new JTextArea();
		nurseAddr.setBounds(435, 75, 139, 71);
		panel_1.add(nurseAddr);
		nurseAddr.setLineWrap(true);
		
		JLabel lblid = new JLabel("\u62A4\u58EBID\uFF1A");
		lblid.setBounds(218, 45, 54, 15);
		panel_1.add(lblid);
		
		nurseId = new JTextField();
		nurseId.setBounds(282, 42, 91, 21);
		panel_1.add(nurseId);
		nurseId.setColumns(10);
		
		JButton button = new JButton("\u4FEE\u6539");
		button.setBounds(27, 158, 93, 39);
		panel_1.add(button);
		
		JButton button_1 = new JButton("\u5220\u9664");
		button_1.setBounds(175, 158, 93, 39);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("\u63D2\u5165");
		button_2.setBounds(322, 158, 93, 39);
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("\u91CD\u7F6E");
		button_3.setBounds(469, 158, 93, 39);
		panel_1.add(button_3);
		
		JButton button_4 = new JButton("\u9000\u51FA");
		button_4.setBounds(611, 160, 93, 39);
		panel_1.add(button_4);
		
		JComboBox nurseStatus = new JComboBox();
		nurseStatus.setBounds(282, 82, 91, 21);
		panel_1.add(nurseStatus);
		nurseStatus.setModel(new DefaultComboBoxModel(new String[] {"\u4E0A\u73ED", "\u51FA\u5DEE"}));
		nurseStatus.setSelectedIndex(0);
		
		JLabel label_6 = new JLabel("\u62A4\u58EBID\uFF1A");
		label_6.setBounds(549, 48, 54, 15);
		panel_1.add(label_6);
		
		nurseId2 = new JTextField();
		nurseId2.setBounds(613, 45, 91, 21);
		panel_1.add(nurseId2);
		nurseId2.setColumns(10);
		
		JButton button_5 = new JButton("\u67E5\u8BE2");
		button_5.setBounds(611, 107, 93, 39);
		panel_1.add(button_5);
		
		JSpinner nurseAge = new JSpinner();
		nurseAge.setBounds(91, 122, 91, 22);
		panel_1.add(nurseAge);
		nurseAge.setModel(new SpinnerNumberModel(0, 0, 150, 1));
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//  查询
					String nurId2 = nurseId2.getText();
					Nurse nurse = new Nurse(nurId2);
					fillTable(nurse);
			}
		});
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				p.removeAll();
			}
		});
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nurseId.setText("");
				nurseName.setText("");
				nurseAge.setValue(0);
				nurseTele.setText("");
				nurseAddr.setText("");
				nurseId2.setText("");
				fillTable(new Nurse());
			}
		});
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nurName = nurseName.getText();
				if(StringUtil.isEmpty(nurName)){
					JOptionPane.showMessageDialog(null, "名字不能为空！");
					return;
				}
				String nurSex = "";
				if(nurseSexF.isSelected()){
					nurSex = "女";
				}
				else
					nurSex = "男";
				String nurAge = (String) nurseAge.getValue();
				String nurTele = nurseTele.getText();
				if((nurTele.toCharArray()).length!=11){
					JOptionPane.showMessageDialog(null, "电话号码不合格！");
					return;
				}
				if(StringUtil.isEmpty(nurTele)){
					JOptionPane.showMessageDialog(null, "电话号码不能为空！");
					return;
				}
				String nurAddr = nurseAddr.getText();
				String nurStatus = (String) nurseStatus.getSelectedItem();
				Connection conn = util.createConn();
				String nurId = null;//Id不让输入，自动生成
				int id = 0,temp=0;
				try {
					ResultSet rs = nursedao.NurseSelect(conn, new Nurse());
					String str = null;
					while(rs.next()){
						str = rs.getString("Nid").replaceAll("[^0-9]", "");//将非0的字符替换成空，这样剩下的都是数字
						temp = Integer.parseInt(str);
						if(temp>id){
							id = temp;//让id一直取最大的ID号
						}
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				nurId = new String("N0"+String.valueOf((++id)));//最大的ID号+1即新建的Nid
				Nurse nurse = new Nurse(nurId,nurName,nurSex,Integer.parseInt(nurAge),nurTele,nurAddr,nurStatus);
				try {
					//如果使用者没有填写相应的文本框默认不改变值
					if(nursedao.NursePrimary(conn, nurse)==true){
						JOptionPane.showMessageDialog(null, "用户已存在！");
						return;
					}
					if(nursedao.NurseInsert(conn, nurse)==1){
						JOptionPane.showMessageDialog(null, "添加成功！");
					}
					{
						//操作成功则刷新界面
						nurseId.setText("");
						nurseName.setText("");
						nurseAge.setValue(0);
						nurseTele.setText("");
						nurseAddr.setText("");
						nurseId2.setText("");
						fillTable(new Nurse());
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
					util.closeConn();
				}
			}
		});
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nurId = nurseId.getText();
				if(StringUtil.isEmpty(nurId)){
					JOptionPane.showMessageDialog(null, "护士ID不能为空！");
					return;
				}
				Nurse nurse = new Nurse(nurId);
				Connection conn = util.createConn();
				try {
					if(!nursedao.NursePrimary(conn, nurse)){
						JOptionPane.showMessageDialog(null, "用户不存在！");
						return;
					}
					if(nursedao.NurseDelete(conn, nurse)==1){
						JOptionPane.showMessageDialog(null, "删除成功！");
						User user = new User(nurId);//删除用户表信息
						userdao.UserDelete(conn, user);
					}
					{
						//操作成功则刷新界面
						nurseId.setText("");
						nurseName.setText("");
						nurseAge.setValue(0);
						nurseTele.setText("");
						nurseAddr.setText("");
						nurseId2.setText("");
						fillTable(new Nurse());
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
					util.closeConn();
				}
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//  修改
				String nurId = nurseId.getText();
				if(StringUtil.isEmpty(nurId)){
					JOptionPane.showMessageDialog(null, "护士ID不能为空！");
					return;
				}
				String nurName = nurseName.getText();
				String nurSex = "";
				if(nurseSexF.isSelected()){
					nurSex = "女";
				}
				else
					nurSex = "男";
				String nurAge = String.valueOf(nurseAge.getValue());
				//如果无输入则为0，如果继续为NULL后面会有一些坑，为了避免简单解决，所以设0
				if(StringUtil.isEmpty(nurAge)){
					nurAge += 0;
				}
				String nurTele = nurseTele.getText();
				String nurAddr = nurseAddr.getText();
				String nurStatus = (String) nurseStatus.getSelectedItem();
				Connection conn = util.createConn();
				Nurse nurse = new Nurse(nurId,nurName,nurSex,Integer.parseInt(nurAge),nurTele,nurAddr,nurStatus);
				try {
					//如果使用者没有填写相应的文本框默认不改变值，即从原表获取相应的值。
					{
						if(nursedao.NursePrimary(conn, nurse)==false){
							JOptionPane.showMessageDialog(null, "用户不存在！");
							return;
						}
						ResultSet rs = nursedaosub.NurseSelect(conn, nurse);
						while(rs.next()){
							if(StringUtil.isEmpty(nurName)){
								nurse.setNname(rs.getString("Nname")); 
							}
							if(nurAge.equals("0")){
								nurse.setNage(rs.getInt("Nage"));
							}
							if(StringUtil.isEmpty(nurTele)){
								nurse.setNtele(rs.getString("Ntele"));
							}
							if(StringUtil.isEmpty(nurAddr)){
								nurse.setNaddr(rs.getString("Naddr"));
							}
						}
					}
					if(nursedao.NurseUpdate(conn, nurse)==1){
						JOptionPane.showMessageDialog(null, "修改成功！");
					}
					{
						//操作成功则刷新界面
						nurseId.setText("");
						nurseName.setText("");
						nurseAge.setValue(0);
						nurseTele.setText("");
						nurseAddr.setText("");
						nurseId2.setText("");
						fillTable(new Nurse());
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
					util.closeConn();
				}
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(26, 26, 764, 216);
		panel.add(panel_2);
		fillTable(new Nurse());
	}
	private void fillTable(Nurse nurse){
		DefaultTableModel dtm = (DefaultTableModel) nurseTable.getModel();
		dtm.setRowCount(0);
		Connection conn=null;
		try{
			conn= util.createConn();
			ResultSet rs =nursedao.NurseSelect(conn,nurse);
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getString("Nid"));
				v.add(rs.getString("Nname"));
				v.add(rs.getString("Nsex"));
				v.add(rs.getInt("Nage"));
				v.add(rs.getString("Ntele"));
				v.add(rs.getString("Nstatus"));
				v.add(rs.getString("Naddr"));
				dtm.addRow(v);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			util.closeConn();
		}
	}
}
