package com.keshe.view;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.omg.CORBA.FloatSeqHelper;

import com.keshe.dao.BedDao;
import com.keshe.dao.BedDaoSub;
import com.keshe.dao.NurseDao;
import com.keshe.model.Bed;
import com.keshe.model.Nurse;
import com.keshe.tool.Connmethod;
import com.keshe.tool.StringUtil;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.ConnectException;
import java.security.acl.Group;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;

public class BedUpdateIntFrm2n {
	Connmethod util = new Connmethod();
	BedDao beddao = new BedDao();
	BedDao beddaosub = new BedDaoSub();//为了防止修改中填到关键字段，误加索引条件，导致修改元祖不唯一
	NurseDao nursedao = new NurseDao();
	private JTable bedTable;
	private JTextField bedId2;
	public JPanel panel;
	String bStatusTxt=null;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public BedUpdateIntFrm2n(String Id,JPanel p) {
		panel = new JPanel();
		panel.setBounds(100, 100, 800, 500);
		panel.setLayout(null);
		
		JLabel label_3 = new JLabel("\u65E5\u68C0\u503C\uFF1A");
		label_3.setBounds(184, 300, 54, 15);
		panel.add(label_3);
		
		JButton button = new JButton("\u67E5\u5E8A");
		
		button.setBounds(177, 371, 93, 42);
		panel.add(button);
		
		JButton button_3 = new JButton("\u91CD\u7F6E");
		
		button_3.setBounds(348, 371, 93, 42);
		panel.add(button_3);
		
		JButton button_4 = new JButton("\u9000\u51FA");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(false);
				p.removeAll();
			}
		});
		button_4.setBounds(510, 371, 93, 42);
		panel.add(button_4);
		
		ButtonGroup group = new ButtonGroup();
		JRadioButton bedCheck1 = new JRadioButton("1");
		bedCheck1.setBounds(244, 296, 40, 23);
		panel.add(bedCheck1);
		group.add(bedCheck1);
		
		JRadioButton bedCheck0 = new JRadioButton("0");
		bedCheck0.setBounds(286, 296, 48, 23);
		panel.add(bedCheck0);
		group.add(bedCheck0);
		bedCheck0.setSelected(true);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(64, 35, 674, 204);
		panel.add(scrollPane);
		
		bedTable = new JTable();
		scrollPane.setViewportView(bedTable);
		bedTable.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bedTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				int row = bedTable.getSelectedRow();
				bedId2.setText((String) bedTable.getValueAt(row, 0));
				bStatusTxt = (String) bedTable.getValueAt(row, 1);
			}
		});
		bedTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5E8A\u4F4D\u53F7", "\u72B6\u6001", "\u65E5\u68C0\u503C"
			}
		));
		
		JButton button_5 = new JButton("\u67E5\u8BE2");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bId = bedId2.getText();
				Bed bed = new Bed(bId);
				fillTable(bed);
			}
		});
		button_5.setBounds(510, 287, 93, 42);
		panel.add(button_5);
		
		JLabel label_4 = new JLabel("\u75C5\u5E8A\u53F7\uFF1A");
		label_4.setBounds(340, 300, 54, 15);
		panel.add(label_4);
		
		bedId2 = new JTextField();
		bedId2.setColumns(10);
		bedId2.setBounds(404, 297, 66, 21);
		panel.add(bedId2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(54, 24, 695, 226);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\u67E5\u8BE2\u4FE1\u606F\u680F\u76EE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(54, 257, 695, 190);
		panel.add(panel_2);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				group.clearSelection();
				bedCheck0.setSelected(true);
				bedId2.setText("");
				fillTable(new Bed(null,Id));
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 修改
				String bId = bedId2.getText();
				String bChecks = null;
				if(bedCheck0.isSelected()){
					bChecks = bedCheck0.getText();
				}
				else if(bedCheck1.isSelected()){
					bChecks = bedCheck1.getText();
				}
				Connection conn = util.createConn();
				Bed bed = new Bed(bId, Id,bStatusTxt, bChecks);
				try {
					//如果未输入负责该床位的护士，那么默认使用原来的
					if(StringUtil.isEmpty(bStatusTxt)){
						ResultSet rs = beddao.BedSelect(conn, new Bed(bId));
						while(rs.next()){
							bStatusTxt = rs.getString("Bstatus");
						}
					}
					if(beddao.BedUpdate(conn, bed)==1){
						JOptionPane.showMessageDialog(null, "查床成功！");
					}
					{
						//操作成功刷新界面
						group.clearSelection();
						bedCheck0.setSelected(true);
						bedId2.setText("");
						fillTable(new Bed(null,Id));
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
					util.closeConn();
				}
			}
		});
		fillTable(new Bed(null,Id));
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
