package com.keshe.view;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.WrappedPlainView;

import com.keshe.dao.AllocationDao;
import com.keshe.dao.AllocationDaoSub;
import com.keshe.dao.BedDao;
import com.keshe.dao.PatientDao;
import com.keshe.dao.UserDao;
import com.keshe.model.Allocation;
import com.keshe.model.Bed;
import com.keshe.model.Patient;
import com.keshe.model.User;
import com.keshe.tool.Connmethod;
import com.keshe.tool.StringUtil;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTree;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.file.AccessDeniedException;
import java.security.interfaces.RSAKey;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Calendar;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.SpinnerNumberModel;

public class AllocationUpdateIntFrm {
	private JTextField bedId;
	private JTextField patientId;
	private JTable allocationTable;
	private JTextField textField_1;
	Connmethod util = new Connmethod();
	AllocationDao allodao = new AllocationDao();
	AllocationDaoSub allodaosub = new AllocationDaoSub();
	BedDao beddao = new BedDao();
	PatientDao patdao = new PatientDao();
	private JTable patTable;
	private JTable bTable;
	private JTextField textField;
	public JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JTextField textField_2;
	private JTextField textField_3;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public AllocationUpdateIntFrm(JPanel p) {
		panel = new JPanel();
		panel.setBounds(100, 100, 800, 500);
		panel.setLayout(null);
		
		JButton button = new JButton("\u4FEE\u6539");
		
		button.setBounds(62, 404, 93, 39);
		panel.add(button);
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		
		button_1.setBounds(486, 404, 93, 39);
		panel.add(button_1);
		
		JButton button_2 = new JButton("\u9000\u51FA");
		
		button_2.setBounds(631, 404, 93, 39);
		panel.add(button_2);
		
		JButton button_3 = new JButton("\u5220\u9664");
		
		button_3.setBounds(205, 404, 93, 39);
		panel.add(button_3);
		
		JButton button_4 = new JButton("\u63D2\u5165");
		
		button_4.setBounds(347, 404, 93, 39);
		panel.add(button_4);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u67E5\u8BE2\u4FE1\u606F\u680F\u76EE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 318, 780, 153);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		patientId = new JTextField();
		patientId.setBounds(100, 58, 76, 21);
		panel_1.add(patientId);
		patientId.setColumns(10);
		
		JLabel label_1 = new JLabel("\u75C5\u4EBA\u53F7\uFF1A");
		label_1.setBounds(36, 61, 54, 15);
		panel_1.add(label_1);
		
		JLabel label = new JLabel("\u5E8A\u4F4D\u53F7\uFF1A");
		label.setBounds(36, 26, 54, 15);
		panel_1.add(label);
		
		bedId = new JTextField();
		bedId.setBounds(100, 27, 76, 21);
		panel_1.add(bedId);
		bedId.setColumns(10);
		
		JButton button_5 = new JButton("\u67E5\u8BE2");
		button_5.setBounds(622, 21, 93, 39);
		panel_1.add(button_5);
		
		textField_1 = new JTextField();
		textField_1.setBounds(320, 45, 13, 2);
		panel_1.add(textField_1);
		textField_1.setBackground(Color.BLACK);
		textField_1.setEnabled(false);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		
		JLabel label_4 = new JLabel("\u8D77\uFF1A");
		label_4.setBounds(240, 37, 30, 15);
		panel_1.add(label_4);
		
		textField = new JTextField();
		textField.setBounds(368, 45, 13, 2);
		panel_1.add(textField);
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(Color.BLACK);
		
		JSpinner StimeY = new JSpinner();
		StimeY.setModel(new SpinnerNumberModel(0, 0, 9999, 1));
		StimeY.setBounds(270, 35, 50, 22);
		panel_1.add(StimeY);
		
		JSpinner StimeM = new JSpinner();
		StimeM.setModel(new SpinnerNumberModel(0, 0, 12, 1));
		StimeM.setBounds(333, 35, 35, 22);
		panel_1.add(StimeM);
		
		JSpinner StimeD = new JSpinner();
		StimeD.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		StimeD.setBounds(380, 35, 35, 22);
		panel_1.add(StimeD);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBackground(Color.BLACK);
		textField_2.setBounds(517, 45, 13, 2);
		panel_1.add(textField_2);
		
		JLabel label_2 = new JLabel("\u6B62\uFF1A");
		label_2.setBounds(437, 37, 30, 15);
		panel_1.add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBackground(Color.BLACK);
		textField_3.setBounds(565, 45, 13, 2);
		panel_1.add(textField_3);
		
		JSpinner EtimeY = new JSpinner();
		EtimeY.setModel(new SpinnerNumberModel(0, 0, 9999, 1));
		EtimeY.setBounds(467, 35, 50, 22);
		panel_1.add(EtimeY);
		
		JSpinner EtimeM = new JSpinner();
		EtimeM.setModel(new SpinnerNumberModel(0, 0, 12, 1));
		EtimeM.setBounds(530, 35, 35, 22);
		panel_1.add(EtimeM);
		
		JSpinner EtimeD = new JSpinner();
		EtimeD.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		EtimeD.setBounds(577, 35, 35, 22);
		panel_1.add(EtimeD);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 10, 780, 298);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(9, 10, 342, 278);
		panel_2.add(scrollPane);
		allocationTable = new JTable();
		scrollPane.setViewportView(allocationTable);
		allocationTable.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		allocationTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u75C5\u4EBA\u53F7", "\u75C5\u5E8A\u53F7", "\u5165\u4F4F\u65F6\u95F4", "\u5230\u671F\u65F6\u95F4"
			}
		));
		allocationTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				int row = allocationTable.getSelectedRow();
				bedId.setText((String) allocationTable.getValueAt(row, 0));
				patientId.setText((String) allocationTable.getValueAt(row, 1));
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(358, 10, 252, 278);
		panel_2.add(scrollPane_1);
		
		patTable = new JTable();
		scrollPane_1.setViewportView(patTable);
		patTable.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		patTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				int row = patTable.getSelectedRow();
				patientId.setText((String) patTable.getValueAt(row, 1));
			}
		});
		patTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u59D3\u540D", "\u75C5\u4EBA\u53F7", "\u75C5\u60C5\u63CF\u8FF0", "\u72B6\u6001"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		patTable.getColumnModel().getColumn(0).setPreferredWidth(83);
		patTable.getColumnModel().getColumn(1).setPreferredWidth(105);
		patTable.getColumnModel().getColumn(2).setPreferredWidth(291);
		patTable.getColumnModel().getColumn(3).setPreferredWidth(101);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(616, 10, 154, 278);
		panel_2.add(scrollPane_2);
		
		bTable = new JTable();
		scrollPane_2.setViewportView(bTable);
		bTable.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		bTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int row = bTable.getSelectedRow();
				bedId.setText((String) bTable.getValueAt(row, 0));
			}
		});
		bTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u75C5\u5E8A\u53F7", "\u4F7F\u7528\u72B6\u6001"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bedId.setText("");
				patientId.setText("");
				StimeD.setValue(0);
				StimeM.setValue(0);
				StimeY.setValue(0);
				EtimeD.setValue(0);
				EtimeM.setValue(0);
				EtimeY.setValue(0);
				fillTable(new Allocation());
				fillTable1(new Patient());
				fillTable2(new Bed());
			}
		});
		
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 插入
				String bId = bedId.getText();
				String patId = patientId.getText();
				if(StringUtil.isEmpty(bId)||StringUtil.isEmpty(patId)){
					JOptionPane.showMessageDialog(null, "床位号和病人号不能为空！");
					return;
				}
				String sTime = null;
				String eTime = null;
				String sTimeY = String.valueOf(StimeY.getValue());
				String sTimeM = String.valueOf(StimeM.getValue());//月份要做限制
				String sTimeD = String.valueOf(StimeD.getValue());//天数也要做限制
				String eTimeY = String.valueOf(EtimeY.getValue());
				String eTimeM = String.valueOf(EtimeM.getValue());
				String eTimeD = String.valueOf(EtimeD.getValue());
				{
					//日期处理
					if(Integer.parseInt(sTimeY)==0){
						JOptionPane.showMessageDialog(null, "入住年份不能为空！");
						return;
					}
					if(Integer.parseInt(sTimeM)==0){
						JOptionPane.showMessageDialog(null, "入住月份不能为空！");
						return;
					}
					if(Integer.parseInt(sTimeD)==0){
						JOptionPane.showMessageDialog(null, "入住天数不能为空！");
						return;
					}
					if(Integer.parseInt(sTimeY)<999){
						JOptionPane.showMessageDialog(null, "入住年份不符合要求！");
						return;
					}
					if(Integer.parseInt(sTimeM)<10){
						sTimeM = "0"+sTimeM;
					}
					if(Integer.parseInt(sTimeD)<10){
						sTimeD = "0"+sTimeD;
					}
					sTime = sTimeY + "-" + sTimeM + "-" + sTimeD;
					if(Integer.parseInt(eTimeY)==0){
						JOptionPane.showMessageDialog(null, "到期年份不能为空！");
						return;
					}
					if(Integer.parseInt(eTimeM)==0){
						JOptionPane.showMessageDialog(null, "到期月份不能为空！");
						return;
					}
					if(Integer.parseInt(eTimeD)==0){
						JOptionPane.showMessageDialog(null, "到期天数不能为空！");
						return;
					}
					if(Integer.parseInt(eTimeY)<999){
						JOptionPane.showMessageDialog(null, "到期年份不符合要求！");
						return;
					}
					if(Integer.parseInt(eTimeM)<10){
						eTimeM = "0"+eTimeM;
					}
					if(Integer.parseInt(eTimeD)<10){
						eTimeD = "0"+eTimeD;
					}
					eTime = eTimeY + "-" + eTimeM + "-" + eTimeD;
				}
				Allocation allo = new Allocation(bId,patId,sTime,eTime);
				Connection conn = util.createConn();
				try {
					if(allodao.AllocationPrimary(conn, allo)==true){
						JOptionPane.showMessageDialog(null, "分配记录已经存在！");
						return;
					}
					//修改当前病床的状态
					Patient pat = new Patient(patId);
					ResultSet rs = patdao.PatientSelect(conn, pat);
					while(rs.next()){
						if(rs.getString("Pstatus").equals("住院")){
							JOptionPane.showMessageDialog(null, "该病人已经分配！");
							return;
						}
						else{
							pat.setDid(rs.getString("Did"));
							pat.setPaddr(rs.getString("Paddr"));
							pat.setPage(rs.getInt("Page"));
							pat.setPdescribe(rs.getString("Pdescribe"));
							pat.setPid(rs.getString("Pid"));
							pat.setPname(rs.getString("Pname"));
							pat.setPsex(rs.getString("Psex"));
							pat.setPstatus("住院");
							pat.setPtele(rs.getString("Ptele"));
							patdao.PatientUpdate(conn, pat);
						}
					}
					Bed bed = new Bed(bId);
					rs = beddao.BedSelect(conn, bed);
					while(rs.next()){
						if(rs.getString("Bstatus").equals("使用")){
							JOptionPane.showMessageDialog(null, "该床位已经分配！");
							return;
						}
						else{
							bed.setBid(rs.getString("Bid"));
							bed.setBstatus("使用");
							bed.setChecks(rs.getString("Checks"));
							bed.setNid(rs.getString("Nid"));
							beddao.BedUpdate(conn, bed);
						}
					}
					if(allodao.AllocationInsert(conn, allo)==1){
						JOptionPane.showMessageDialog(null, "插入成功！");
					}
					{
						//操作成功则刷新界面
						bedId.setText("");
						patientId.setText("");
						StimeD.setValue(0);
						StimeM.setValue(0);
						StimeY.setValue(0);
						EtimeD.setValue(0);
						EtimeM.setValue(0);
						EtimeY.setValue(0);
						fillTable(new Allocation());
						fillTable1(new Patient());
						fillTable2(new Bed());
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(false);
				p.removeAll();
			}
		});
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bId = bedId.getText();
				String patId = patientId.getText();
				if(StringUtil.isEmpty(bId)||StringUtil.isEmpty(patId)){
					JOptionPane.showMessageDialog(null, "床位号和病人号不能为空！");
					return;
				}
				Allocation allo = new Allocation(bId,patId);
				Connection conn = util.createConn();
				try {
					if(allodao.AllocationDelete(conn, allo)==1){
						JOptionPane.showMessageDialog(null, "删除成功！");
						//需要把删除元组的床状态置为空闲
						beddao.BedUpdate(conn, new Bed(bId,patId,"空闲","0"));
						Patient pat = new Patient(patId);
						ResultSet rs = patdao.PatientSelect(conn, pat);
						while(rs.next()){
							pat.setDid(rs.getString("Did"));
							pat.setPaddr(rs.getString("Paddr"));
							pat.setPage(rs.getInt("Page"));
							pat.setPdescribe(rs.getString("Pdescribe"));
							pat.setPid(rs.getString("Pid"));
							pat.setPname(rs.getString("Pname"));
							pat.setPsex(rs.getString("Psex"));
							pat.setPstatus("未分配");
							pat.setPtele(rs.getString("Ptele"));
							patdao.PatientUpdate(conn, pat);
						}
					}
					{//操作成功刷新界面
						bedId.setText("");
						patientId.setText("");
						StimeD.setValue(0);
						StimeM.setValue(0);
						StimeY.setValue(0);
						EtimeD.setValue(0);
						EtimeM.setValue(0);
						EtimeY.setValue(0);
						fillTable(new Allocation());
						fillTable1(new Patient());
						fillTable2(new Bed());
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
				String patId = patientId.getText();
				if(StringUtil.isEmpty(bId)||StringUtil.isEmpty(patId)){
					JOptionPane.showMessageDialog(null, "床位号和病人号不能为空！");
					return;
				}
				String sTime = null;
				String eTime = null;
				String sTimeY = String.valueOf(StimeY.getValue());
				String sTimeM = String.valueOf(StimeM.getValue());//月份要做限制
				String sTimeD = String.valueOf(StimeD.getValue());//天数也要做限制
				String eTimeY = String.valueOf(EtimeY.getValue());
				String eTimeM = String.valueOf(EtimeM.getValue());
				String eTimeD = String.valueOf(EtimeD.getValue());
				{
					//到期日期处理
					if(Integer.parseInt(eTimeY)!=0){
						if(Integer.parseInt(eTimeM)==0){
							JOptionPane.showMessageDialog(null, "到期月份不能为空！");
							return;
						}
						if(Integer.parseInt(eTimeD)==0){
							JOptionPane.showMessageDialog(null, "到期天数不能为空！");
							return;
						}
						if(Integer.parseInt(eTimeY)<999){
							JOptionPane.showMessageDialog(null, "到期年份不符合要求！");
							return;
						}
						if(Integer.parseInt(eTimeM)<10){
							eTimeM = "0"+eTimeM;
						}
						if(Integer.parseInt(eTimeD)<10){
							eTimeD = "0"+eTimeD;
						}
						eTime = eTimeY + "-" + eTimeM + "-" + eTimeD;
					}
				}
				Allocation allo = new Allocation(bId,patId,sTime,eTime);
				Connection conn = util.createConn();
				try {
					if(allodao.AllocationPrimary(conn, allo)==false){
						JOptionPane.showMessageDialog(null, "分配记录不存在！");
						return;
					}
					ResultSet rs = null;
					//判断所要修改的床位是否正使用
					if(StringUtil.isNotEmpty(bId)){
						Bed bed = new Bed(bId);
						rs = beddao.BedSelect(conn, bed);
						while(rs.next()){
							if(rs.getString("Bstatus").equals("使用")){
								JOptionPane.showMessageDialog(null, "该床位正在被使用！");
								return;
							}
							else{
								bed.setBid(rs.getString("Bid"));
								bed.setBstatus("使用");
								bed.setChecks(rs.getString("Checks"));
								bed.setNid(rs.getString("Nid"));
								beddao.BedUpdate(conn, bed);
							}
						}
					}
					if(StringUtil.isNotEmpty(patId)){
						Patient pat = new Patient(patId);
						rs = patdao.PatientSelect(conn, pat);
						while(rs.next()){
							if(rs.getString("Pstatus").equals("住院")){
								JOptionPane.showMessageDialog(null, "该病人已经分配！");
								return;
							}
							else{
								pat.setDid(rs.getString("Did"));
								pat.setPaddr(rs.getString("Paddr"));
								pat.setPage(rs.getInt("Page"));
								pat.setPdescribe(rs.getString("Pdescribe"));
								pat.setPid(rs.getString("Pid"));
								pat.setPname(rs.getString("Pname"));
								pat.setPsex(rs.getString("Psex"));
								pat.setPstatus("住院");
								pat.setPtele(rs.getString("Ptele"));
								patdao.PatientUpdate(conn, pat);
							}
						}
					}
					rs = allodaosub.AllocationSelect(conn, allo);
					while(rs.next()){
						if(StringUtil.isEmpty(bId)){
							allo.setBid(rs.getString("Bid"));
						}
						if(StringUtil.isEmpty(patId)){
							allo.setPid(rs.getString("Pid"));
						}
						if(StringUtil.isEmpty(sTime)){
							allo.setStime(rs.getString("Stime"));
						}
						if(StringUtil.isEmpty(eTime)){
							allo.setEtime(rs.getString("Etime"));
						}
					}
					if(allodao.AllocationUpdate(conn, allo)==1){
						JOptionPane.showMessageDialog(null, "修改成功！");
					}
					{
						//操作成功则刷新界面
						bedId.setText("");
						patientId.setText("");
						StimeD.setValue(0);
						StimeM.setValue(0);
						StimeY.setValue(0);
						EtimeD.setValue(0);
						EtimeM.setValue(0);
						EtimeY.setValue(0);
						fillTable(new Allocation());
						fillTable1(new Patient());
						fillTable2(new Bed());
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//  查询
				String bId = bedId.getText();
				String patId = patientId.getText();
				String sTime = null;
				String eTime = null;
				{
					//日期处理
					String sTimeY = String.valueOf(StimeY.getValue());
					String sTimeM = String.valueOf(StimeM.getValue());//月份要做限制
					String sTimeD = String.valueOf(StimeD.getValue());//天数也要做限制
					String eTimeY = String.valueOf(EtimeY.getValue());
					String eTimeM = String.valueOf(EtimeM.getValue());
					String eTimeD = String.valueOf(EtimeD.getValue());
					if(Integer.parseInt(sTimeY)!=0){
						if(Integer.parseInt(sTimeM)==0){
							JOptionPane.showMessageDialog(null, "入住月份不能为空！");
							return;
						}
						if(Integer.parseInt(sTimeD)==0){
							JOptionPane.showMessageDialog(null, "入住天数不能为空！");
							return;
						}
						if(Integer.parseInt(sTimeY)<999){
							JOptionPane.showMessageDialog(null, "入住年份不符合要求！");
							return;
						}
						if(Integer.parseInt(sTimeM)<10){
							sTimeM = "0"+sTimeM;
						}
						if(Integer.parseInt(sTimeD)<10){
							sTimeD = "0"+sTimeD;
						}
						sTime = sTimeY + "-" + sTimeM + "-" + sTimeD;
					}
					if(Integer.parseInt(eTimeY)!=0){
						if(Integer.parseInt(eTimeM)==0){
							JOptionPane.showMessageDialog(null, "到期月份不能为空！");
							return;
						}
						if(Integer.parseInt(eTimeD)==0){
							JOptionPane.showMessageDialog(null, "到期天数不能为空！");
							return;
						}
						if(Integer.parseInt(eTimeY)<999){
							JOptionPane.showMessageDialog(null, "到期年份不符合要求！");
							return;
						}
						if(Integer.parseInt(eTimeM)<10){
							eTimeM = "0"+eTimeM;
						}
						if(Integer.parseInt(eTimeD)<10){
							eTimeD = "0"+eTimeD;
						}
						eTime = eTimeY + "-" + eTimeM + "-" + eTimeD;
					}
				}
				Allocation allo = new Allocation(bId,patId,sTime,eTime);
				fillTable(allo);
				fillTable1(new Patient());
				fillTable2(new Bed());
			}
		});
		fillTable(new Allocation());
		fillTable1(new Patient());
		fillTable2(new Bed());
	}
	private void fillTable(Allocation allo)
	{
		DefaultTableModel dtm = (DefaultTableModel) allocationTable.getModel();
		dtm.setRowCount(0);
		Connection conn=null;
		try{
			conn= util.createConn();
			ResultSet rs =allodao.AllocationSelect(conn, allo);
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getString("Bid"));
				v.add(rs.getString("Pid"));
				v.add(rs.getString("Stime"));
				v.add(rs.getString("Etime"));
				dtm.addRow(v);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			util.closeConn();
		}
	}
	private void fillTable1(Patient pat)
	{
		DefaultTableModel dtm = (DefaultTableModel) patTable.getModel();
		dtm.setRowCount(0);
		Connection conn=null;
		try{
			conn= util.createConn();
			ResultSet rs =patdao.PatientSelect(conn, pat);
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getString("Pname"));
				v.add(rs.getString("Pid"));
				v.add(rs.getString("Pdescribe"));
				v.add(rs.getString("Pstatus"));
				dtm.addRow(v);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			util.closeConn();
		}
	}
	private void fillTable2(Bed bed)
	{
		DefaultTableModel dtm = (DefaultTableModel) bTable.getModel();
		dtm.setRowCount(0);
		Connection conn=null;
		try{
			conn= util.createConn();
			ResultSet rs =beddao.BedSelect(conn, bed);
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getString("Bid"));
				v.add(rs.getString("Bstatus"));
				dtm.addRow(v);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			util.closeConn();
		}
	}
}