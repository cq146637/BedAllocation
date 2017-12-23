package com.keshe.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import com.keshe.dao.PatientDao;
import com.keshe.dao.PatientDaoSub;
import com.keshe.model.Nurse;
import com.keshe.model.Patient;
import com.keshe.tool.Connmethod;

import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;

public class PatientQueryIntFrm {
	private JTextField Pid;
	private JTextField Pname;
	Connmethod util = new Connmethod();
	PatientDao patientdao = new PatientDao();
	private JTable patienttable;
	public JPanel panel;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public PatientQueryIntFrm(JPanel p) {
		panel = new JPanel();
		panel.setBounds(100, 100, 800, 500);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 23, 755, 199);
		panel.add(scrollPane);
		
		patienttable = new JTable();
		scrollPane.setViewportView(patienttable);
		patienttable.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		patienttable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u75C5\u4EBA\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u5E74\u9F84", "\u7535\u8BDD", "\u72B6\u6001", "\u4F4F\u5740", "\u75C5\u60C5\u63CF\u8FF0", "\u533B\u751F\u53F7"
			}
		));
		patienttable.getColumnModel().getColumn(1).setMaxWidth(2147483646);
		patienttable.getColumnModel().getColumn(4).setPreferredWidth(145);
		patienttable.getColumnModel().getColumn(5).setPreferredWidth(121);
		patienttable.getColumnModel().getColumn(6).setPreferredWidth(196);
		patienttable.getColumnModel().getColumn(7).setPreferredWidth(207);
		patienttable.getColumnModel().getColumn(8).setPreferredWidth(117);
		fillTable(new Patient());
		
		JLabel lblNewLabel = new JLabel("\u75C5  \u53F7\uFF1A");
		lblNewLabel.setBounds(155, 318, 54, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3  \u540D\uFF1A");
		lblNewLabel_1.setBounds(332, 368, 54, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5E74  \u9F84\uFF1A");
		lblNewLabel_2.setBounds(498, 368, 54, 15);
		panel.add(lblNewLabel_2);
		
		JLabel label = new JLabel("\u6027  \u522B\uFF1A");
		label.setBounds(155, 368, 54, 15);
		panel.add(label);
		
		ButtonGroup group = new ButtonGroup();
		JRadioButton MRadioButton = new JRadioButton("男");
		MRadioButton.setBounds(210, 364, 38, 23);
		panel.add(MRadioButton);
		JRadioButton WRadioButton = new JRadioButton("女");
		WRadioButton.setBounds(250, 364, 38, 23);
		panel.add(WRadioButton);
		group.add( MRadioButton);
		group.add( WRadioButton);
		
		Pid = new JTextField();
		Pid.setBounds(210, 315, 66, 21);
		panel.add(Pid);
		Pid.setColumns(10);
		
		Pname = new JTextField();
		Pname.setBounds(380, 365, 66, 21);
		panel.add(Pname);
		Pname.setColumns(10);
		
		JSpinner Page = new JSpinner();
		Page.setModel(new SpinnerNumberModel(0, 0, 150, 1));
		Page.setFont(new Font("宋体", Font.PLAIN, 12));
		Page.setBounds(551, 365, 52, 22);
		panel.add(Page);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(248, 179, 1, 2);
		panel.add(separator);

		
		JLabel lblNewLabel_3 = new JLabel("\u4F4F  \u5740\uFF1A");
		lblNewLabel_3.setBounds(317, 318, 54, 15);
		panel.add(lblNewLabel_3);
		
		JTextPane Paddr = new JTextPane();
		Paddr.setBounds(380, 312, 221, 21);
		panel.add(Paddr);
		
		JLabel lblNewLabel_4 = new JLabel("\u72B6  \u6001\uFF1A");
		lblNewLabel_4.setBounds(155, 271, 54, 15);
		panel.add(lblNewLabel_4);
		
		JComboBox Pstatus = new JComboBox();
		Pstatus.setModel(new DefaultComboBoxModel(new String[] {"\u672A\u5206\u914D", "\u4F4F\u9662", "\u5EB7\u590D"}));
		Pstatus.setBounds(210, 268, 66, 21);
		panel.add(Pstatus);
		
		JLabel lblNewLabel_5 = new JLabel("\u4E3B\u6CBB\u533B\u751F\uFF1A");
		lblNewLabel_5.setBounds(317, 271, 69, 15);
		panel.add(lblNewLabel_5);
		
		JTextArea Did = new JTextArea();
		Did.setBounds(380, 267, 221, 24);
		panel.add(Did);
		

		JButton button_2 = new JButton("查询");
		button_2.setBounds(155, 416, 93, 39);
		panel.add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String patid = Pid.getText();
				String patname = Pname.getText();
				String pataddr = Paddr.getText();
				String patdid = Did.getText();
				String patstatus = (String) Pstatus.getSelectedItem();
				String patage = String.valueOf(Page.getValue());
				String pattele=null;
				String patsex = "";
				if(MRadioButton.isSelected()){
					patsex = "男";
				}
				else if(WRadioButton.isSelected()){
					patsex = "女";
				}
				Patient patient = new Patient(patid, patname, patsex, Integer.parseInt(patage),pattele ,pataddr, null,
						patstatus,patdid);
				{
					fillTable(patient);
				    Pid.setText("");
					Pname.setText("");
				    Paddr.setText("");
				    Did.setText("");
				    Page.setValue(0);
				}
			}
		});
		fillTable(new Patient());
	
	
	
		JButton button_1 = new JButton("重置");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pid.setText("");
				Pname.setText("");
				Paddr.setText("");
				Page.setValue(0);
				Did.setText("");
				fillTable(new Patient());
			
			}
		});
		button_1.setBounds(332, 416, 93, 39);
		panel.add(button_1);
		
		
		JButton button = new JButton("退出");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				p.removeAll();
			}
		});
		button.setBounds(510, 416, 93, 39);
		panel.add(button);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u67E5\u8BE2\u4FE1\u606F\u680F\u76EE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 246, 780, 232);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 10, 780, 226);
		panel.add(panel_2);
		

	
	}
	private void fillTable(Patient patient){
		DefaultTableModel dtm = (DefaultTableModel) patienttable.getModel();
		dtm.setRowCount(0);
		Connection conn=null;
		try{
			conn= util.createConn();
			ResultSet rs =patientdao.PatientSelect(conn,patient);
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getString("Pid"));
				v.add(rs.getString("Pname"));
				v.add(rs.getString("Psex"));
				v.add(rs.getInt("Page"));
				v.add(rs.getString("Ptele"));
				v.add(rs.getString("Pstatus"));
				v.add(rs.getString("Paddr"));
				v.add(rs.getString("Pdescribe"));
				v.add(rs.getString("Did"));
				dtm.addRow(v);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			util.closeConn();
		}

	}
}

