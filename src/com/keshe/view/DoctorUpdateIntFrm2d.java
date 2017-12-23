package com.keshe.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import com.keshe.dao.DoctorDao;
import com.keshe.dao.PatientDao;
import com.keshe.model.Doctor;
import com.keshe.model.Patient;
import com.keshe.tool.Connmethod;
import com.keshe.tool.StringUtil;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class DoctorUpdateIntFrm2d {
	private JTextField doctorName;
	private JTextField doctorTele;
	Connmethod util = new Connmethod();
	DoctorDao docdao = new DoctorDao();
	public JPanel panel;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public DoctorUpdateIntFrm2d(String Id,JPanel p) {
		panel = new JPanel();
		panel.setBounds(100, 100, 800, 500);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u4FEE\u6539\u4FE1\u606F\u680F\u76EE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(189, 83, 367, 295);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("\u59D3  \u540D\uFF1A");
		label.setBounds(11, 43, 54, 15);
		panel_1.add(label);
		
		doctorName = new JTextField();
		doctorName.setColumns(10);
		doctorName.setBounds(75, 40, 66, 21);
		panel_1.add(doctorName);
		
		JLabel label_1 = new JLabel("\u6027  \u522B\uFF1A");
		label_1.setBounds(11, 101, 54, 15);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("\u5E74  \u9F84\uFF1A");
		label_2.setBounds(11, 163, 54, 15);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("\u7535  \u8BDD\uFF1A");
		label_3.setBounds(11, 228, 54, 15);
		panel_1.add(label_3);
		
		doctorTele = new JTextField();
		doctorTele.setColumns(10);
		doctorTele.setBounds(75, 225, 92, 21);
		panel_1.add(doctorTele);
		
		JLabel label_4 = new JLabel("\u4F4F  \u5740\uFF1A");
		label_4.setBounds(203, 101, 54, 15);
		panel_1.add(label_4);
		
		JTextArea doctorAddr = new JTextArea();
		doctorAddr.setLineWrap(true);
		doctorAddr.setBounds(227, 123, 130, 120);
		panel_1.add(doctorAddr);
		
		JSpinner doctorAge = new JSpinner();
		doctorAge.setModel(new SpinnerNumberModel(0, 0, 150, 1));
		doctorAge.setBounds(75, 160, 66, 22);
		panel_1.add(doctorAge);
		
		ButtonGroup group = new ButtonGroup();
		JRadioButton doctorSexM = new JRadioButton("\u7537");
		doctorSexM.setBounds(74, 97, 44, 23);
		group.add(doctorSexM);
		panel_1.add(doctorSexM);
		
		JRadioButton doctorSexF = new JRadioButton("\u5973");
		doctorSexF.setBounds(120, 97, 52, 23);
		group.add(doctorSexF);
		panel_1.add(doctorSexF);
		
		JButton btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.setBounds(333, 405, 93, 40);
		panel_1.add(btnNewButton);
		
		JLabel label_5 = new JLabel("\u72B6  \u6001\uFF1A");
		label_5.setBounds(203, 43, 54, 15);
		panel_1.add(label_5);
		
		JComboBox doctorStatus = new JComboBox();
		doctorStatus.setModel(new DefaultComboBoxModel(new String[] {"\u4E0A\u73ED", "\u51FA\u5DEE"}));
		doctorStatus.setBounds(267, 40, 54, 21);
		panel_1.add(doctorStatus);
		
		JButton btnNewButton_1 = new JButton("\u9000\u51FA");
		doctorStatus.setSelectedIndex(0);
		btnNewButton_1.setBounds(311, 407, 93, 46);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String docName = doctorName.getText();
				String docAge =  String.valueOf(doctorAge.getValue());
				String docSex = "";
				if(doctorSexF.isSelected()){
					docSex="女";
				}
				else if(doctorSexF.isSelected()){
					docSex="男";
				}
				String docStatus = (String) doctorStatus.getSelectedItem();
				String docTele = doctorTele.getText();
				String docAddr = doctorAddr.getText();
				try {
					if(StringUtil.isNotEmpty(docName)||Integer.parseInt(docAge)!=0||StringUtil.isNotEmpty(docSex)||StringUtil.isNotEmpty(docTele)||StringUtil.isNotEmpty(docAddr)){
						Doctor doc = new Doctor(Id);
						Connection conn = util.createConn();
						ResultSet rs = docdao.DoctorSelect(conn, doc);
						while(rs.next()){
							doc.setDname(docName);
							if(StringUtil.isEmpty(docName)){
								doc.setDname(rs.getString("Dname"));
							}
							doc.setDage(Integer.parseInt(docAge));
							if(Integer.parseInt(docAge)==0){
								doc.setDage(rs.getInt("Dage"));
							}
							doc.setDsex(docSex);
							if(StringUtil.isEmpty(docSex)){
								doc.setDsex(rs.getString("Dsex"));
							}
							doc.setDtele(docTele);
							if(StringUtil.isEmpty(docTele)){
								doc.setDtele(rs.getString("Dtele"));
							}
							doc.setDaddr(docAddr);
							if(StringUtil.isEmpty(docAddr)){
								doc.setDaddr(rs.getString("Daddr"));
							}
							doc.setDstatus(docStatus);
							if(StringUtil.isEmpty(docStatus)){
								doc.setDstatus(rs.getString("Dstatus"));
							}
							doc.setDposition(rs.getString("Dposition"));
						}
						if(docdao.DoctorUpdate(conn, doc)==1){
							JOptionPane.showMessageDialog(null, "修改成功！");
						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					util.closeConn();
					panel.setVisible(false);
					p.removeAll();
				}
			}
		});
	}
}
