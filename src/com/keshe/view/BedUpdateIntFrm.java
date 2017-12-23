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
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JScrollPane;

public class BedUpdateIntFrm {
	Connmethod util = new Connmethod();
	BedDao beddao = new BedDao();
	BedDao beddaosub = new BedDaoSub();//为了防止修改中填到关键字段，误加索引条件，导致修改元祖不唯一
	NurseDao nursedao = new NurseDao();
	private JTextField bedId;
	private JTextField nurseId;
	private JTable bedTable;
	private JTextField bedId2;
	public JPanel panel;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public BedUpdateIntFrm(JPanel p) {
		panel = new JPanel();
		panel.setBounds(100, 100, 800, 500);
		panel.setLayout(null);
		
		ButtonGroup group = new ButtonGroup();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 42, 740, 183);
		panel.add(scrollPane);
		
		bedTable = new JTable();
		scrollPane.setViewportView(bedTable);
		bedTable.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		bedTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				int row = bedTable.getSelectedRow();
				bedId.setText((String) bedTable.getValueAt(row, 0));
			}
		});
		bedTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5E8A\u4F4D\u53F7", "\u62A4\u58EB\u53F7", "\u72B6\u6001", "\u65E5\u68C0\u503C"
			}
		));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 25, 780, 215);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "   \u4FEE\u6539\u4FE1\u606F\u680F\u76EE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(10, 277, 780, 193);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton button = new JButton("\u4FEE\u6539");
		button.setBounds(70, 121, 93, 42);
		panel_2.add(button);
		
		JButton button_1 = new JButton("\u5220\u9664");
		button_1.setBounds(209, 121, 93, 42);
		panel_2.add(button_1);
		
		JButton button_2 = new JButton("\u63D2\u5165");
		button_2.setBounds(358, 121, 93, 42);
		panel_2.add(button_2);
		
		JButton button_3 = new JButton("\u91CD\u7F6E");
		button_3.setBounds(503, 121, 93, 42);
		panel_2.add(button_3);
		
		JButton button_4 = new JButton("\u9000\u51FA");
		button_4.setBounds(646, 121, 93, 42);
		panel_2.add(button_4);
		
		JButton button_5 = new JButton("\u67E5\u8BE2");
		button_5.setBounds(659, 35, 93, 42);
		panel_2.add(button_5);
		
		JLabel label_4 = new JLabel("\u75C5\u5E8A\u53F7\uFF1A");
		label_4.setBounds(482, 49, 54, 15);
		panel_2.add(label_4);
		
		bedId2 = new JTextField();
		bedId2.setBounds(560, 46, 66, 21);
		panel_2.add(bedId2);
		bedId2.setColumns(10);
		
		JLabel label = new JLabel("\u75C5\u5E8A\u53F7\uFF1A");
		label.setBounds(70, 30, 54, 15);
		panel_2.add(label);
		
		bedId = new JTextField();
		bedId.setBounds(152, 24, 66, 21);
		panel_2.add(bedId);
		bedId.setColumns(10);
		
		JLabel label_1 = new JLabel("\u62A4\u58EB\u53F7\uFF1A");
		label_1.setBounds(275, 30, 54, 15);
		panel_2.add(label_1);
		
		nurseId = new JTextField();
		nurseId.setBounds(367, 27, 66, 21);
		panel_2.add(nurseId);
		nurseId.setColumns(10);
		
		JLabel label_2 = new JLabel("\u72B6  \u6001\uFF1A");
		label_2.setBounds(70, 69, 54, 15);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("\u65E5\u68C0\u503C\uFF1A");
		label_3.setBounds(275, 69, 54, 15);
		panel_2.add(label_3);
		JRadioButton bedCheck1 = new JRadioButton("1");
		bedCheck1.setBounds(367, 65, 40, 23);
		panel_2.add(bedCheck1);
		group.add(bedCheck1);
		
		JComboBox bedStatus = new JComboBox();
		bedStatus.setBounds(152, 66, 66, 21);
		panel_2.add(bedStatus);
		bedStatus.setModel(new DefaultComboBoxModel(new String[] {"\u7A7A\u95F2", "\u4F7F\u7528"}));
		bedStatus.setSelectedIndex(0);
		
		JRadioButton bedCheck0 = new JRadioButton("0");
		bedCheck0.setBounds(403, 65, 48, 23);
		panel_2.add(bedCheck0);
		group.add(bedCheck0);
		bedCheck0.setSelected(true);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bId = bedId2.getText();
				Bed bed = new Bed(bId);
				fillTable(bed);
			}
		});
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(false);
				p.removeAll();
			}
		});
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bedId.setText("");
				nurseId.setText("");
				bedStatus.setSelectedIndex(0);
				group.clearSelection();
				bedCheck0.setSelected(true);
				bedId2.setText("");
				fillTable(new Bed());
			}
		});
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 插入
				String bId = bedId.getText();
				if(StringUtil.isEmpty(bId)){
					JOptionPane.showMessageDialog(null, "床号不能为空！");
					return;
				}
				String nurId = nurseId.getText();
				Connection conn = util.createConn();
				String bStatus = (String) bedStatus.getSelectedItem();
				String bChecks = null;
				if(bedCheck0.isSelected()){
					bChecks = bedCheck0.getText();
				}
				else if(bedCheck1.isSelected()){
					bChecks = bedCheck1.getText();
				}
				Bed bed = new Bed(bId, nurId, bStatus, bChecks);
				try {
					if(beddao.BedPrimary(conn, bed)==true){
						JOptionPane.showMessageDialog(null, "床位已存在！");
						return;
					}
					if(StringUtil.isNotEmpty(nurId)){
						Nurse nurse = new Nurse(nurId);
						if(nursedao.NursePrimary(conn, nurse)==false){
							JOptionPane.showMessageDialog(null, "护士号不存在！");
							return;
						}
					}
					if(beddao.BedInsert(conn, bed)==1){
						JOptionPane.showMessageDialog(null, "插入成功！");
					}
					{
						//操作成功刷新界面
						bedId.setText("");
						nurseId.setText("");
						bedStatus.setSelectedIndex(0);
						group.clearSelection();
						bedCheck0.setSelected(true);
						bedId2.setText("");
						fillTable(new Bed());
					}
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					util.closeConn();
				}
			}
		});
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 删除
				String bId = bedId.getText();
				if(StringUtil.isEmpty(bId)){
					JOptionPane.showMessageDialog(null, "床号不能为空！");
					return;
				}
				Connection conn = util.createConn();
				Bed bed = new Bed(bId);
				try {
					if(beddao.BedPrimary(conn, bed)==false){
						JOptionPane.showMessageDialog(null, "床位不存在！");
						return;
					}
					if(beddao.BedDelete(conn, bed)==1){
						JOptionPane.showMessageDialog(null, "删除成功！");
					}
					{
						//操作成功刷新界面
						bedId.setText("");
						nurseId.setText("");
						bedStatus.setSelectedIndex(0);
						group.clearSelection();
						bedCheck0.setSelected(true);
						bedId2.setText("");
						fillTable(new Bed());
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
					util.closeConn();
				}
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 修改
				String bId = bedId.getText();
				if(StringUtil.isEmpty(bId)){
					JOptionPane.showMessageDialog(null, "床号不能为空！");
					return;
				}
				String nurId = nurseId.getText();
				String bStatus = (String) bedStatus.getSelectedItem();
				String bChecks = null;
				if(bedCheck0.isSelected()){
					bChecks = bedCheck0.getText();
				}
				else if(bedCheck1.isSelected()){
					bChecks = bedCheck1.getText();
				}
				Connection conn = util.createConn();
				Bed bed = new Bed(bId, nurId, bStatus, bChecks);
				try {
					//如果未输入负责该床位的护士，那么默认使用原来的
					if(beddao.BedPrimary(conn, bed)==false){
						JOptionPane.showMessageDialog(null, "床位不存在！");
						return;
					}
					if(StringUtil.isNotEmpty(nurId)){
						Nurse nurse = new Nurse(nurId);
						if(nursedao.NursePrimary(conn, nurse)==false){
							JOptionPane.showMessageDialog(null, "护士号不存在！");
							return;
						}
					}
					ResultSet rs = beddaosub.BedSelect(conn, bed);
					while(rs.next()){
						if(StringUtil.isEmpty(nurId)){
							bed.setNid(rs.getString("Nid"));
						}
					}
					if(beddao.BedUpdate(conn, bed)==1){
						JOptionPane.showMessageDialog(null, "修改成功！");
					}
					{
						//操作成功刷新界面
						bedId.setText("");
						nurseId.setText("");
						bedStatus.setSelectedIndex(0);
						group.clearSelection();
						bedCheck0.setSelected(true);
						bedId2.setText("");
						fillTable(new Bed());
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
					util.closeConn();
				}
			}
		});
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
