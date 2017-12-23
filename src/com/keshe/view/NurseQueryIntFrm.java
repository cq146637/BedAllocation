package com.keshe.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.omg.CORBA.FloatSeqHelper;

import com.keshe.dao.NurseDao;
import com.keshe.dao.UserDao;
import com.keshe.model.Nurse;
import com.keshe.tool.Connmethod;
import com.keshe.tool.StringUtil;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import java.awt.Color;

public class NurseQueryIntFrm {
	Connmethod util = new Connmethod();
	NurseDao nursedao = new NurseDao();
	private JTable nurseTable;
	private JTextField nurseId;
	private JTextField nurseName;
	private JTextField nurseTele;
	private JTextField nurseAddr;
	private JTextField textField_1;
	public JPanel panel;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public NurseQueryIntFrm(JPanel p) {
		panel = new JPanel();
		panel.setBounds(100, 100, 800, 500);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 42, 720, 210);
		panel.add(scrollPane);
		
		nurseTable = new JTable();
		scrollPane.setViewportView(nurseTable);
		nurseTable.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		nurseTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u62A4\u58EB\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u5E74\u9F84", "\u7535\u8BDD", "\u72B6\u6001", "\u4F4F\u5740"
			}
		));
		nurseTable.getColumnModel().getColumn(4).setPreferredWidth(185);
		nurseTable.getColumnModel().getColumn(6).setPreferredWidth(285);
		
		ButtonGroup group = new ButtonGroup();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u67E5\u8BE2\u4FE1\u606F\u680F\u76EE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(24, 280, 755, 210);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("\u62A4\u58EB\u53F7\uFF1A");
		label.setBounds(61, 37, 54, 15);
		panel_1.add(label);
		
		nurseId = new JTextField();
		nurseId.setBounds(116, 34, 66, 21);
		panel_1.add(nurseId);
		nurseId.setColumns(10);
		
		JLabel label_1 = new JLabel("\u59D3  \u540D\uFF1A");
		label_1.setBounds(222, 37, 54, 15);
		panel_1.add(label_1);
		
		nurseName = new JTextField();
		nurseName.setBounds(271, 34, 66, 21);
		panel_1.add(nurseName);
		nurseName.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5E74  \u9F84\uFF1A");
		label_2.setBounds(378, 37, 54, 15);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("\u6027  \u522B\uFF1A");
		label_3.setBounds(571, 36, 54, 15);
		panel_1.add(label_3);
		
		JRadioButton nurseSexM = new JRadioButton("\u7537");
		nurseSexM.setBounds(632, 32, 47, 23);
		panel_1.add(nurseSexM);
		group.add(nurseSexM);
		
		JRadioButton nurseSexF = new JRadioButton("\u5973");
		nurseSexF.setBounds(675, 32, 47, 23);
		panel_1.add(nurseSexF);
		group.add(nurseSexF);
		
		JLabel label_4 = new JLabel("\u7535  \u8BDD\uFF1A");
		label_4.setBounds(61, 87, 54, 15);
		panel_1.add(label_4);
		
		nurseTele = new JTextField();
		nurseTele.setBounds(118, 84, 91, 21);
		panel_1.add(nurseTele);
		nurseTele.setColumns(10);
		
		JLabel label_5 = new JLabel("\u4F4F  \u5740\uFF1A");
		label_5.setBounds(241, 87, 54, 15);
		panel_1.add(label_5);
		
		nurseAddr = new JTextField();
		nurseAddr.setBounds(305, 84, 351, 21);
		panel_1.add(nurseAddr);
		nurseAddr.setColumns(10);
		
		JButton button = new JButton("\u91CD\u7F6E");
		button.setBounds(89, 133, 93, 41);
		panel_1.add(button);
		
		JButton button_1 = new JButton("\u67E5\u8BE2");
		button_1.setBounds(310, 133, 93, 41);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("\u9000\u51FA");
		button_2.setBounds(524, 133, 93, 41);
		panel_1.add(button_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(463, 34, 16, 21);
		panel_1.add(textField_1);
		textField_1.setText("\u4E00");
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		
		JSpinner nurseAgeLow = new JSpinner();
		nurseAgeLow.setBounds(423, 34, 42, 22);
		panel_1.add(nurseAgeLow);
		nurseAgeLow.setModel(new SpinnerNumberModel(0, 0, 150, 1));
		
		JSpinner nurseAgeHigh = new JSpinner();
		nurseAgeHigh.setBounds(479, 34, 42, 22);
		panel_1.add(nurseAgeHigh);
		nurseAgeHigh.setModel(new SpinnerNumberModel(0, 0, 150, 1));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(24, 22, 755, 248);
		panel.add(panel_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				p.removeAll();
			}
		});
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//  查询
				String nurId = nurseId.getText();
				String nurName = nurseName.getText();
				String nurAgeLow = String.valueOf(nurseAgeLow.getValue());
				String nurAgeHigh = String.valueOf(nurseAgeHigh.getValue());
				//获取性别
				String nurSex = "";
				if(nurseSexF.isSelected()){
					nurSex = "女";
				}
				else if(nurseSexM.isSelected()){
					nurSex = "男";
				}
				String nurTele = nurseTele.getText();
				String nurAddr = nurseAddr.getText();
				Nurse nurse = new Nurse(nurId,nurName,nurSex,Integer.parseInt(nurAgeLow),Integer.parseInt(nurAgeHigh),nurTele,nurAddr);
				fillTable(nurse);//刷新表，并显示查询内容
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//  重置
				nurseId.setText("");
				nurseName.setText("");
				nurseAgeLow.setValue(0);
				nurseAgeHigh.setValue(0);
				group.clearSelection();
				nurseTele.setText("");
				nurseAddr.setText("");
				fillTable(new Nurse());
			}
		});
		fillTable(new Nurse());//刷新表，并显示查询内容

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
