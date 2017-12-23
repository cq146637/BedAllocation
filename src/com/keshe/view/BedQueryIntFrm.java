package com.keshe.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import com.keshe.dao.BedDao;
import com.keshe.model.Bed;
import com.keshe.model.Nurse;
import com.keshe.tool.Connmethod;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;

public class BedQueryIntFrm {
	private JTable bedTable;
	private JTextField bedId;
	private JLabel label_1;
	private JTextField nurseId;
	private JButton button_2;
	Connmethod util = new Connmethod();
	BedDao beddao = new BedDao();
	Nurse nurse = new Nurse();
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
	public BedQueryIntFrm(JPanel p) {
		panel = new JPanel();
		panel.setBounds(100, 100, 800, 500);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 26, 745, 309);
		panel.add(scrollPane);
		
		bedTable = new JTable();
		scrollPane.setViewportView(bedTable);
		bedTable.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		bedTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5E8A\u4F4D\u53F7", "\u62A4\u58EB\u53F7", "\u72B6\u6001", "\u65E5\u68C0\u503C"
			}
		));
		bedTable.getColumnModel().getColumn(0).setPreferredWidth(94);
		bedTable.getColumnModel().getColumn(1).setPreferredWidth(102);
		bedTable.getColumnModel().getColumn(2).setPreferredWidth(103);
		bedTable.getColumnModel().getColumn(3).setPreferredWidth(96);
		
		JLabel label = new JLabel("\u5E8A\u4F4D\u53F7\uFF1A");
		label.setBounds(58, 411, 54, 15);
		panel.add(label);
		
		bedId = new JTextField();
		bedId.setColumns(10);
		bedId.setBounds(122, 408, 96, 21);
		panel.add(bedId);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bId = bedId.getText();
				String nurId = nurseId.getText();
				Bed bed = new Bed(bId,nurId);
				fillTable(bed);
			}
		});
		button.setBounds(428, 401, 93, 42);
		panel.add(button);
		
		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				p.removeAll();
			}
		});
		button_1.setBounds(658, 399, 93, 42);
		panel.add(button_1);
		
		label_1 = new JLabel("\u62A4\u58EB\u53F7\uFF1A");
		label_1.setBounds(247, 411, 54, 15);
		panel.add(label_1);
		
		nurseId = new JTextField();
		nurseId.setBounds(311, 408, 96, 21);
		panel.add(nurseId);
		nurseId.setColumns(10);
		
		button_2 = new JButton("\u91CD\u7F6E");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bedId.setText("");
				nurseId.setText("");
				fillTable(new Bed());
			}
		});
		button_2.setBounds(543, 399, 93, 42);
		panel.add(button_2);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 10, 780, 351);
		panel.add(panel_1);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\u67E5\u8BE2\u4FE1\u606F\u680F\u76EE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 379, 780, 91);
		panel.add(panel_2);
		fillTable(new Bed());
	}
	private void fillTable(Bed bed){
		DefaultTableModel dtm = (DefaultTableModel) bedTable.getModel();
		dtm.setRowCount(0);
		Connection conn=null;
		try{
			conn= util.createConn();
			ResultSet rs =beddao.BedSelect(conn,bed);
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getString("Bid"));
				v.add(rs.getString("Nid"));
				v.add(rs.getString("Bstatus"));
				v.add(rs.getString("Checks"));
				dtm.addRow(v);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			util.closeConn();
		}
	}
}
