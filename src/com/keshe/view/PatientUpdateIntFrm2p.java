package com.keshe.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import com.keshe.dao.PatientDao;
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

public class PatientUpdateIntFrm2p {
	private JTextField patientName;
	private JTextField patientTele;
	Connmethod util = new Connmethod();
	PatientDao patdao = new PatientDao();
	public JPanel panel;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public PatientUpdateIntFrm2p(String Id,JPanel p) {
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
		
		patientName = new JTextField();
		patientName.setColumns(10);
		patientName.setBounds(75, 40, 66, 21);
		panel_1.add(patientName);
		
		JLabel label_1 = new JLabel("\u6027  \u522B\uFF1A");
		label_1.setBounds(11, 101, 54, 15);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("\u5E74  \u9F84\uFF1A");
		label_2.setBounds(11, 163, 54, 15);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("\u7535  \u8BDD\uFF1A");
		label_3.setBounds(11, 228, 54, 15);
		panel_1.add(label_3);
		
		patientTele = new JTextField();
		patientTele.setColumns(10);
		patientTele.setBounds(75, 225, 92, 21);
		panel_1.add(patientTele);
		
		JLabel label_4 = new JLabel("\u4F4F  \u5740\uFF1A");
		label_4.setBounds(227, 43, 54, 15);
		panel_1.add(label_4);
		
		JTextArea patientAddr = new JTextArea();
		patientAddr.setLineWrap(true);
		patientAddr.setBounds(227, 92, 130, 151);
		panel_1.add(patientAddr);
		
		JSpinner patientAge = new JSpinner();
		patientAge.setModel(new SpinnerNumberModel(0, 0, 150, 1));
		patientAge.setBounds(75, 160, 66, 22);
		panel_1.add(patientAge);
		
		ButtonGroup group = new ButtonGroup();
		JRadioButton patientSexM = new JRadioButton("\u7537");
		patientSexM.setBounds(74, 97, 50, 23);
		group.add(patientSexM);
		panel_1.add(patientSexM);
		
		JRadioButton patientSexF = new JRadioButton("\u5973");
		patientSexF.setBounds(126, 97, 54, 23);
		group.add(patientSexF);
		panel_1.add(patientSexF);
		
		JButton btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.setBounds(333, 405, 93, 40);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u9000\u51FA");
		
		btnNewButton_1.setBounds(311, 407, 93, 46);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String patName = patientName.getText();
				String patAge =  String.valueOf(patientAge.getValue());
				String patSex = null;
				if(patientSexF.isSelected()){
					patSex="女";
				}
				else if(patientSexF.isSelected()){
					patSex="男";
				}
				String patTele = patientTele.getText();
				String patAddr = patientAddr.getText();
				Patient pat = new Patient(Id);
				Connection conn = util.createConn();
				ResultSet rs;
				try {
					rs = patdao.PatientSelect(conn, pat);
					while(rs.next()){
						pat.setPname(patName);
						if(StringUtil.isEmpty(patName)){
							pat.setPname(rs.getString("Pname"));
						}
						pat.setPage(Integer.parseInt(patAge));
						if(Integer.parseInt(patAge)==0){
							pat.setPage(rs.getInt("Page"));
						}
						pat.setPsex(patSex);
						if(StringUtil.isEmpty(patSex)){
							pat.setPsex(rs.getString("Psex"));
						}
						pat.setPtele(patTele);
						if(StringUtil.isEmpty(patTele)){
							pat.setPtele(rs.getString("Ptele"));
						}
						pat.setPaddr(patAddr);
						if(StringUtil.isEmpty(patAddr)){
							pat.setPaddr(rs.getString("Paddr"));
						}
						pat.setPdescribe(rs.getString("Pdescribe"));
						pat.setPstatus(rs.getString("Pstatus"));
						pat.setDid(rs.getString("Did"));
					}
					if(StringUtil.isNotEmpty(patName)||(Integer.parseInt(patAge)!=0)||StringUtil.isNotEmpty(patSex)||StringUtil.isNotEmpty(patTele)&&StringUtil.isNotEmpty(patAddr)){
						if(patdao.PatientUpdate(conn, pat)==1){
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
