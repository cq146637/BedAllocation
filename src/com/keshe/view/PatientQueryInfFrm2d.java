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
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JScrollPane;

public class PatientQueryInfFrm2d  {
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
	public PatientQueryInfFrm2d(String Id,JPanel p) {
		panel = new JPanel();
		panel.setBounds(100, 100, 800, 500);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(139, 57, 532, 171);
		panel.add(scrollPane);
		
		patienttable = new JTable();
		scrollPane.setViewportView(patienttable);
		patienttable.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		patienttable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u75C5\u4EBA\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u5E74\u9F84", "\u7535\u8BDD", "\u72B6\u6001", "\u4F4F\u5740", "\u63CF\u8FF0", "\u533B\u751F\u53F7"
			}
		));
		patienttable.getColumnModel().getColumn(0).setPreferredWidth(96);
		patienttable.getColumnModel().getColumn(1).setMaxWidth(2147483646);
		patienttable.getColumnModel().getColumn(4).setPreferredWidth(133);
		patienttable.getColumnModel().getColumn(5).setPreferredWidth(195);
		patienttable.getColumnModel().getColumn(6).setPreferredWidth(193);
		patienttable.getColumnModel().getColumn(7).setPreferredWidth(178);
		patienttable.getColumnModel().getColumn(8).setPreferredWidth(112);
		
		ButtonGroup group = new ButtonGroup();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u67E5\u8BE2\u4FE1\u606F\u680F\u76EE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(123, 253, 564, 217);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u75C5  \u53F7\uFF1A");
		lblNewLabel.setBounds(55, 30, 54, 15);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3  \u540D\uFF1A");
		lblNewLabel_1.setBounds(232, 80, 54, 15);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5E74  \u9F84\uFF1A");
		lblNewLabel_2.setBounds(398, 80, 54, 15);
		panel_1.add(lblNewLabel_2);
		
		JLabel label = new JLabel("\u6027  \u522B\uFF1A");
		label.setBounds(55, 80, 54, 15);
		panel_1.add(label);
		JRadioButton MRadioButton = new JRadioButton("男");
		MRadioButton.setBounds(110, 76, 38, 23);
		panel_1.add(MRadioButton);
		group.add( MRadioButton);
		JRadioButton WRadioButton = new JRadioButton("女");
		WRadioButton.setBounds(150, 76, 38, 23);
		panel_1.add(WRadioButton);
		group.add( WRadioButton);
		
		Pid = new JTextField();
		Pid.setBounds(110, 27, 66, 21);
		panel_1.add(Pid);
		Pid.setColumns(10);
		
		Pname = new JTextField();
		Pname.setBounds(280, 77, 66, 21);
		panel_1.add(Pname);
		Pname.setColumns(10);
		
		JSpinner Page = new JSpinner();
		Page.setBounds(451, 77, 52, 22);
		panel_1.add(Page);
		Page.setModel(new SpinnerNumberModel(0, 0, 110, 1));
		Page.setFont(new Font("宋体", Font.PLAIN, 12));
		

		JButton button_2 = new JButton("查询");
		button_2.setBounds(83, 147, 93, 39);
		panel_1.add(button_2);
		
		
		
			
			
			
			JButton button = new JButton("退出");
			button.setBounds(340, 147, 93, 39);
			panel_1.add(button);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel.setVisible(false);
					p.removeAll();
				}
			});
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String patid = Pid.getText();
				String patname = Pname.getText();
				String patage = String.valueOf(Page.getValue());
				String pattele=null;
				String patsex = "";
				if(MRadioButton.isSelected()){
					patsex = "男";
				}
				else if(WRadioButton.isSelected()){
					patsex = "女";
				}
				Patient patient = new Patient(patid, patname, patsex, Integer.parseInt(patage),pattele ,null, null,
						null,Id);
				{
					fillTable(patient);
				    Pid.setText("");
					Pname.setText("");
				    Page.setValue(0);
				}
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(123, 42, 564, 201);
		panel.add(panel_2);
		fillTable(new Patient(null,Id));

	
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

