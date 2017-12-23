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
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;

public class NurseUpdateIntFrm2n {
	Connmethod util = new Connmethod();
	NurseDao nursedao = new NurseDao();
	NurseDao nursedaosub = new NurseDaoSub();
	private JTextField nurseName;
	private JTextField nurseTele;
	public JPanel panel;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public NurseUpdateIntFrm2n(String Id,JPanel p) {
		panel = new JPanel();
		panel.setBounds(100, 100, 800, 500);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u59D3  \u540D\uFF1A");
		label.setBounds(191, 70, 54, 15);
		panel.add(label);
		
		nurseName = new JTextField();
		nurseName.setBounds(255, 67, 91, 21);
		panel.add(nurseName);
		nurseName.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6027  \u522B\uFF1A");
		label_1.setBounds(191, 144, 54, 15);
		panel.add(label_1);
		
		ButtonGroup group = new ButtonGroup();
		
		
		JRadioButton nurseSexM = new JRadioButton("\u7537");
		nurseSexM.setBounds(251, 140, 48, 23);
		group.add(nurseSexM);
		panel.add(nurseSexM);
		
		JRadioButton nurseSexF = new JRadioButton("\u5973");
		nurseSexF.setBounds(299, 140, 59, 23);
		group.add(nurseSexF);
		panel.add(nurseSexF);
		nurseSexF.setSelected(true);
		
		JLabel label_2 = new JLabel("\u5E74  \u9F84\uFF1A");
		label_2.setBounds(191, 235, 54, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("\u7535  \u8BDD\uFF1A");
		label_3.setBounds(382, 147, 54, 15);
		panel.add(label_3);
		
		nurseTele = new JTextField();
		nurseTele.setBounds(446, 144, 91, 21);
		panel.add(nurseTele);
		nurseTele.setColumns(11);
		
		JLabel label_4 = new JLabel("\u72B6  \u6001\uFF1A");
		label_4.setBounds(382, 71, 54, 15);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("\u4F4F  \u5740\uFF1A");
		label_5.setBounds(382, 213, 54, 15);
		panel.add(label_5);
		
		JTextArea nurseAddr = new JTextArea();
		nurseAddr.setBackground(Color.WHITE);
		nurseAddr.setLineWrap(true);
		nurseAddr.setBounds(446, 209, 139, 95);
		panel.add(nurseAddr);
		
		JButton button = new JButton("\u4FEE\u6539");
	
		button.setBounds(125, 329, 93, 41);
		panel.add(button);
		
		JButton button_3 = new JButton("\u91CD\u7F6E");
		button_3.setBounds(334, 330, 93, 39);
		panel.add(button_3);
		
		JButton button_4 = new JButton("\u9000\u51FA");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				p.removeAll();
			}
		});
		button_4.setBounds(537, 330, 93, 39);
		panel.add(button_4);
		
		JComboBox nurseStatus = new JComboBox();
		nurseStatus.setModel(new DefaultComboBoxModel(new String[] {"\u4E0A\u73ED", "\u51FA\u5DEE"}));
		nurseStatus.setBounds(446, 70, 91, 21);
		panel.add(nurseStatus);
		nurseStatus.setSelectedIndex(0);
		
		JSpinner nurseAge = new JSpinner();
		nurseAge.setModel(new SpinnerNumberModel(0, 0, 150, 1));
		nurseAge.setBounds(255, 232, 91, 22);
		panel.add(nurseAge);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u4FEE\u6539\u4FE1\u606F\u680F\u76EE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(98, 44, 573, 275);
		panel.add(panel_1);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//  修改
				String nurId = Id;
				String nurName = nurseName.getText();
				String nurSex = "";
				if(nurseSexF.isSelected()){
					nurSex = "女";
				}
				else
					nurSex = "男";
				String nurAge = (String) nurseAge.getValue();
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
						nurseName.setText("");
						nurseAge.setValue(0);
						nurseTele.setText("");
						nurseAddr.setText("");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
					util.closeConn();
				}
			}
		});
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nurseName.setText("");
				nurseAge.setValue(0);
				nurseTele.setText("");
				nurseAddr.setText("");
			}
		});
	}
}
