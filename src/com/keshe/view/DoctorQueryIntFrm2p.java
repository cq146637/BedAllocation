package com.keshe.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.keshe.dao.DoctorDao;
import com.keshe.dao.PatientDao;
import com.keshe.model.Doctor;
import com.keshe.model.Patient;
import com.keshe.tool.Connmethod;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;

public class DoctorQueryIntFrm2p {
	private JTextField dDname;
	private JTextField dSex;
	private JTextField dAge;
	private JTextField dStatus;
	private JTextField sPosition;
	private JTextField dTele;
	public JPanel panel;
	Connmethod util = new Connmethod();
	PatientDao patdao = new PatientDao();
	DoctorDao docdao = new DoctorDao();
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public DoctorQueryIntFrm2p(String Id,JPanel p) {
		panel = new JPanel();
		panel.setBounds(100, 100, 800, 500);
		panel.setLayout(null);
		JLabel label = new JLabel("\u533B\u751F\u59D3\u540D\uFF1A");
		label.setBounds(194, 126, 78, 15);
		panel.add(label);
		
		dDname = new JTextField();
		dDname.setEditable(false);
		dDname.setBounds(282, 123, 66, 21);
		panel.add(dDname);
		dDname.setColumns(10);
		
		JLabel label_1 = new JLabel("\u533B\u751F\u6027\u522B\uFF1A");
		label_1.setBounds(194, 183, 66, 15);
		panel.add(label_1);
		
		dSex = new JTextField();
		dSex.setEditable(false);
		dSex.setBounds(282, 180, 66, 21);
		panel.add(dSex);
		dSex.setColumns(10);
		
		JLabel label_2 = new JLabel("\u533B\u751F\u5E74\u9F84\uFF1A");
		label_2.setBounds(194, 245, 66, 15);
		panel.add(label_2);
		
		dAge = new JTextField();
		dAge.setEditable(false);
		dAge.setBounds(282, 242, 66, 21);
		panel.add(dAge);
		dAge.setColumns(10);
		
		JLabel label_3 = new JLabel("\u533B\u751F\u72B6\u6001\uFF1A");
		label_3.setBounds(418, 126, 66, 15);
		panel.add(label_3);
		
		dStatus = new JTextField();
		dStatus.setEditable(false);
		dStatus.setBounds(494, 123, 66, 21);
		panel.add(dStatus);
		dStatus.setColumns(10);
		
		JLabel label_4 = new JLabel("\u533B\u751F\u804C\u4F4D\uFF1A");
		label_4.setBounds(418, 186, 66, 15);
		panel.add(label_4);
		
		sPosition = new JTextField();
		sPosition.setEditable(false);
		sPosition.setBounds(494, 180, 66, 21);
		panel.add(sPosition);
		sPosition.setColumns(10);
		
		JLabel label_5 = new JLabel("\u533B\u751F\u7535\u8BDD\uFF1A");
		label_5.setBounds(418, 245, 66, 15);
		panel.add(label_5);
		
		dTele = new JTextField();
		dTele.setEditable(false);
		dTele.setBounds(494, 242, 107, 21);
		panel.add(dTele);
		dTele.setColumns(10);
		
		JButton btnNewButton = new JButton("\u9000  \u51FA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				p.removeAll();
			}
		});
		btnNewButton.setBounds(340, 341, 93, 44);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u4E3B\u6CBB\u533B\u751F\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(124, 73, 521, 323);
		panel.add(panel_1);
		//Ìî³äÎÄ±¾¿ò
		try {
			String Did = null;
			Connection conn = util.createConn();
			Patient pat = new Patient(Id);
			ResultSet rs = patdao.PatientSelect(conn, pat);
			while(rs.next()){
				Did = rs.getString("Did");
			}
			Doctor doc = new Doctor(Did);
			rs = docdao.DoctorSelect(conn, doc);
			while(rs.next()){
				dDname.setText(rs.getString("Dname"));
				dSex.setText(rs.getString("Dsex"));
				dAge.setText(rs.getString("Dage"));
				dTele.setText(rs.getString("Dtele"));
				dStatus.setText(rs.getString("Dstatus"));
				sPosition.setText(rs.getString("Dposition"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
