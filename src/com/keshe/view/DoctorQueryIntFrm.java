package com.keshe.view;

import java.awt.EventQueue;
import java.awt.Panel;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.management.loading.PrivateClassLoader;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.keshe.dao.DoctorDao;
import com.keshe.model.Doctor;
import com.keshe.tool.Connmethod;

import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;

public class DoctorQueryIntFrm {
	private JTextField DidTxt;
	private JTextField DnameTxt;
	private final JTable DoctorTable = new JTable();
	Connmethod comd = new Connmethod();
	DoctorDao doctorDao = new DoctorDao();
	public JPanel panel;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public DoctorQueryIntFrm(JPanel p) {
		panel = new JPanel();
		panel.setBounds(100, 100, 800, 500);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 51, 675, 291);
		panel.add(scrollPane);
		scrollPane.setViewportView(DoctorTable);
		DoctorTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u533B\u751F\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u5E74\u9F84", "\u7535\u8BDD", "\u4F4F\u5740", "\u72B6\u6001", "\u804C\u4F4D"
			}
		));
		DoctorTable.getColumnModel().getColumn(4).setPreferredWidth(159);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(40, 35, 723, 329);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\u67E5\u8BE2\u4FE1\u606F\u680F\u76EE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(42, 383, 721, 96);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("\u8D26\u53F7\uFF1A");
		label.setBounds(25, 45, 72, 18);
		panel_2.add(label);
		
		DidTxt = new JTextField();
		DidTxt.setBounds(71, 42, 86, 24);
		panel_2.add(DidTxt);
		DidTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u59D3\u540D\uFF1A");
		label_1.setBounds(195, 45, 72, 18);
		panel_2.add(label_1);
		
		DnameTxt = new JTextField();
		DnameTxt.setBounds(241, 42, 86, 24);
		panel_2.add(DnameTxt);
		DnameTxt.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.setBounds(391, 41, 113, 27);
		panel_2.add(button);
		
		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.setBounds(542, 41, 113, 27);
		panel_2.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				p.removeAll();
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//≤È—Ø
				String Did = DidTxt.getText();
				String Dname = DnameTxt.getText();
				Doctor doctor = new Doctor();
				doctor.setDid(Did);
				doctor.setDname(Dname);
				fillTable(doctor);
			}
		});
		fillTable(new Doctor());
	}	
	
		private void fillTable(Doctor doctor){
			DefaultTableModel defaultTableModel = (DefaultTableModel) DoctorTable.getModel();
			defaultTableModel.setRowCount(0);
			try {
				Connection  conn = comd.createConn();
				ResultSet rs = doctorDao.DoctorSelect(conn, doctor);
				while(rs.next()){
					Vector vector = new Vector();//defaultTableModel.addr
					vector.add(rs.getString("Did"));
					vector.add(rs.getString("Dname"));
					vector.add(rs.getString("DSex"));
					vector.add(rs.getString("Dage"));
					vector.add(rs.getString("Dtele"));
					vector.add(rs.getString("Daddr"));
					vector.add(rs.getString("Dstatus"));
					vector.add(rs.getString("Dposition"));
					defaultTableModel.addRow(vector);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				comd.closeConn();
			}
			
		}
}
