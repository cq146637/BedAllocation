package com.keshe.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.keshe.dao.AllocationDao;
import com.keshe.dao.BedDao;
import com.keshe.dao.DoctorDao;
import com.keshe.dao.NurseDao;
import com.keshe.dao.NurseDaoSub;
import com.keshe.dao.PatientDao;
import com.keshe.dao.PatientDaoSub;
import com.keshe.dao.UserDao;
import com.keshe.model.Allocation;
import com.keshe.model.Bed;
import com.keshe.model.Nurse;
import com.keshe.model.Patient;
import com.keshe.model.User;
import com.keshe.tool.Connmethod;
import com.keshe.tool.StringUtil;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JScrollPane;

public class PatientUpdateIntFrm {
	private JTextField Pname;
	private JTextField Ptele;
	private JTextField Did;
	PatientDaoSub patientdaosub = new PatientDaoSub();
	Connmethod util = new Connmethod();
	PatientDao patientdao = new PatientDao();
	BedDao beddao = new BedDao();
	AllocationDao allodao = new AllocationDao();
	UserDao userdao = new UserDao();
	private JTextField Pid;
	private JTable patientTable;
	public JPanel panel;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public PatientUpdateIntFrm(JPanel p) {
		panel = new JPanel();
		panel.setBounds(100, 100, 800, 500);
		panel.setLayout(null);
		
		ButtonGroup group = new ButtonGroup();//使只能单选
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 21, 754, 203);
		panel.add(scrollPane);
		
		patientTable = new JTable();
		scrollPane.setViewportView(patientTable);
		patientTable.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		patientTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int row = patientTable.getSelectedRow();
				Pid.setText((String) patientTable.getValueAt(row, 0));
			}
		});
		patientTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u75C5\u4EBA\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u5E74\u9F84", "\u7535\u8BDD", "\u72B6\u6001", "\u4F4F\u5740", "\u75C5\u60C5\u63CF\u8FF0", "\u533B\u751F\u53F7"
			}
		));
		patientTable.getColumnModel().getColumn(0).setPreferredWidth(101);
		patientTable.getColumnModel().getColumn(4).setPreferredWidth(158);
		patientTable.getColumnModel().getColumn(5).setPreferredWidth(102);
		patientTable.getColumnModel().getColumn(6).setPreferredWidth(192);
		patientTable.getColumnModel().getColumn(7).setPreferredWidth(191);
		patientTable.getColumnModel().getColumn(8).setPreferredWidth(92);
		fillTable(new Patient());
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u7BA1\u7406\u4FE1\u606F\u680F\u76EE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 249, 780, 241);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_2 = new JLabel("姓  名：");
		label_2.setBounds(26, 71, 54, 15);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("姓  别：");
		label_3.setBounds(304, 91, 54, 15);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("年  龄：");
		label_4.setBounds(304, 148, 54, 15);
		panel_1.add(label_4);
		
		Pid = new JTextField();
		Pid.setBounds(90, 31, 93, 21);
		panel_1.add(Pid);
		Pid.setColumns(10);
		
		Pname = new JTextField();
		Pname.setBounds(90, 68, 93, 21);
		panel_1.add(Pname);
		Pname.setColumns(10);
		
		JLabel label_5 = new JLabel("联 系 电 话：");
		label_5.setBounds(513, 70, 89, 15);
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel("住  址：");
		label_6.setBounds(26, 103, 89, 15);
		panel_1.add(label_6);
		
		JLabel lblNewLabel = new JLabel("状  态：");
		lblNewLabel.setBounds(301, 34, 67, 15);
		panel_1.add(lblNewLabel);
		
		JComboBox Pstatus = new JComboBox();
		Pstatus.setBounds(368, 31, 93, 21);
		panel_1.add(Pstatus);
		Pstatus.setModel(new DefaultComboBoxModel(new String[] {"\u672A\u5206\u914D", "\u4F4F\u9662", "\u5EB7\u590D"}));
		
		JLabel label = new JLabel("病  号：");
		label.setBounds(26, 34, 54, 15);
		panel_1.add(label);
		
		
		JLabel label_7 = new JLabel("主治医生账号：");
		label_7.setBounds(513, 31, 113, 15);
		panel_1.add(label_7);
		
		Ptele = new JTextField();
		Ptele.setBounds(602, 67, 93, 21);
		panel_1.add(Ptele);
		Ptele.setColumns(10);
		
		Did = new JTextField();
		Did.setBounds(602, 28, 93, 21);
		panel_1.add(Did);
		Did.setColumns(10);
		
		JTextArea Pdescribe = new JTextArea();
		Pdescribe.setBounds(579, 111, 172, 56);
		panel_1.add(Pdescribe);
		Pdescribe.setLineWrap(true);
		
		JTextArea Paddr = new JTextArea();
		Paddr.setBounds(91, 113, 172, 56);
		panel_1.add(Paddr);
		Paddr.setLineWrap(true);
		JRadioButton PsexM = new JRadioButton("男");
		PsexM.setBounds(372, 87, 50, 23);
		panel_1.add(PsexM);
		group.add(PsexM);
		
		JRadioButton PsexW = new JRadioButton("女");
		PsexW.setBounds(425, 87, 54, 23);
		panel_1.add(PsexW);
		group.add(PsexW);
		
		JLabel label_1 = new JLabel("病  况：");
		label_1.setBounds(513, 103, 54, 15);
		panel_1.add(label_1);
		
		JSpinner Page = new JSpinner();
		Page.setBounds(368, 145, 93, 22);
		panel_1.add(Page);
		Page.setModel(new SpinnerNumberModel(0, 0, 150, 1));
		
				
				
				
				JButton button_2 = new JButton("添  加");
				button_2.setBounds(10, 192, 93, 39);
				panel_1.add(button_2);
				
	
				JButton Update = new JButton("修  改");
				Update.setBounds(350, 192, 93, 39);
				panel_1.add(Update);
				
					
					
					
					
					JButton button = new JButton("删  除");
					button.setBounds(177, 192, 93, 39);
					panel_1.add(button);
					
					JButton button_1 = new JButton("重  置");
					button_1.setBounds(504, 192, 93, 39);
					panel_1.add(button_1);
					
					JButton button_4 = new JButton("退  出");
					button_4.setBounds(658, 192, 93, 39);
					panel_1.add(button_4);
					
					JPanel panel_2 = new JPanel();
					panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					panel_2.setBounds(10, 10, 780, 227);
					panel.add(panel_2);
					
					
					button_4.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							panel.setVisible(false);
							p.removeAll();
						}
					});//退出子界面
					button_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Pid.setText("");
							Pname.setText("");
							Page.setValue(0);
							Ptele.setText("");
							Paddr.setText("");
							Pdescribe.setText("");
							Did.setText("");
							fillTable(new Patient());
						}
					});
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							String patId = Pid.getText();
							if(StringUtil.isEmpty(patId)){
								JOptionPane.showMessageDialog(null, "病号不能为空！");
								return;
							}
							Patient patient = new Patient(patId);
							Connection conn = util.createConn();
							try {
								if(!patientdao.PatientPrimary(conn, patient)){
									JOptionPane.showMessageDialog(null, "用户不存在！");
									return;
								}
								ResultSet rs = patientdao.PatientSelect(conn, patient);
								if(patientdao.PatientDelete(conn, patient)==1){
									JOptionPane.showMessageDialog(null, "删除成功！");
									while(rs.next()){
										if(rs.getString("Pstatus").equals("住院")){
											Allocation allo = new Allocation(null,patId);
											Bed bed = new Bed();
											User user = new User(patId);
											userdao.UserDelete(conn, user);//删除用户表
											rs = allodao.AllocationSelect(conn, allo);
											while(rs.next()){//删除分配信息
												bed.setBid(rs.getString("Bid"));
												allodao.AllocationDelete(conn, allo);
											}
											rs = beddao.BedSelect(conn, bed);
											while(rs.next()){//更新床位信息
												bed.setBid(rs.getString("Bid"));
												bed.setNid(rs.getString("Nid"));
												bed.setBstatus("空闲");
												bed.setChecks(rs.getString("Checks"));
												beddao.BedUpdate(conn, bed);
											}
										}
									}
								}
								{
									//操作成功则刷新界面
									Pid.setText("");
									Pname.setText("");
									Page.setValue(0);
									Ptele.setText("");
									Paddr.setText("");
									Pdescribe.setText("");
									Did.setText("");
									fillTable(new Patient());
								}
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}finally{
								util.closeConn();
							}
						}
					});
				Update.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String patId = Pid.getText();//病号
						if(StringUtil.isEmpty(patId)){
							JOptionPane.showMessageDialog(null,"病号不能为空");
							return;
						}
						String patName = Pname.getText();//姓名
						String patTele = Ptele.getText();//联系电话
						String patStatus = (String) Pstatus.getSelectedItem();//状态
						String patDescribe = Pdescribe.getText();//病况
						String patDid = Did.getText();//主治医生ID
						String patAddr = Paddr.getText();
						String patAge = String.valueOf(Page.getValue());//年龄
						if(StringUtil.isEmpty(patAge)){
							patAge += 0;
						}
						String patSex = "";//性别
						if(PsexM.isSelected()){
							patSex = "男";
						}
						else
							patSex = "女";
						Connection conn = util.createConn();
						Patient patient = new Patient(patId, patName,patSex, Integer.parseInt(patAge), patTele, patAddr, patDescribe,
								patStatus, patDid);
						try {
							//如果使用者没有填写相应的文本框默认不改变值，即从原表获取相应的值。
							{
								
								if(patientdao.PatientPrimary(conn, patient)==false){
									JOptionPane.showMessageDialog(null, "用户不存在！");
									return;
								}
								ResultSet rs = patientdaosub.PatientSelect(conn, patient);
								while(rs.next()){
									if(StringUtil.isEmpty(patName)){
										patient.setPname(rs.getString("Pname")); 
									}
									if(patAge.equals("0")){
										patient.setPage(rs.getInt("Page"));
									}
									if(StringUtil.isEmpty(patTele)){
										patient.setPtele(rs.getString("Ptele"));
									}
									if(StringUtil.isEmpty(patAddr)){
										patient.setPaddr(rs.getString("Paddr"));
									}
									if(StringUtil.isEmpty(patDescribe)){
										patient.setPdescribe(rs.getString("Pdescribe"));
									}
									if(StringUtil.isEmpty(patSex)){
										patient.setPsex(rs.getString("Psex"));
									}
									if(StringUtil.isEmpty(patStatus)){
										patient.setPstatus(rs.getString("Pstatus"));
									}
									if(StringUtil.isEmpty(patDid)){
										patient.setDid(rs.getString("Did"));
									}
							
								}
							}
							if(patientdao.PatientUpdate(conn, patient)==1){
								JOptionPane.showMessageDialog(null, "修改成功！");
							}
							{
								//操作成功则刷新界面
								Pid.setText("");
								Pname.setText("");
								Page.setValue(0);
								Ptele.setText("");
								Paddr.setText("");
								Pdescribe.setText("");
								Pstatus.setToolTipText("");
								fillTable(new Patient());
							}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}finally{
							util.closeConn();
						}
					}
				});
				button_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String patname = Pname.getText();
						if(StringUtil.isEmpty(patname)){
							JOptionPane.showMessageDialog(null, "名字不能为空！");
							return;
						}
						String patsex = "";
						if(PsexM.isSelected()){
							patsex = "男";
						}
						else
							patsex = "女";
						String patage = String.valueOf(Page.getValue());
						if(Integer.parseInt(patage)<0||Integer.parseInt(patage)>120){
							JOptionPane.showMessageDialog(null, "年龄不合格！");
							return;
						}
						if(StringUtil.isEmpty(patage)){
							JOptionPane.showMessageDialog(null, "年龄不能为空！");
							return;
						}
						String pattele = Ptele.getText();
						if((pattele.toCharArray()).length!=11&&(pattele.toCharArray()).length!=8){
							JOptionPane.showMessageDialog(null, "电话号码不合格！");
							return;
						}
						if(StringUtil.isEmpty(pattele)){
							JOptionPane.showMessageDialog(null, "电话号码不能为空！");
							return;
						}
						String pataddr = Paddr.getText();
						String patdescribe = Pdescribe.getText();
						String patdid = Did.getText();
						String patstatus = (String) Pstatus.getSelectedItem();
						Connection conn = util.createConn();
						String patid = null;//Id不让输入，自动生成
						int id = 0,temp=0;
						try {
							ResultSet rs = patientdao.PatientSelect(conn, new Patient());
							String str = null;
							while(rs.next()){
								str = rs.getString("Pid").replaceAll("[^0-9]", "");//将非0的字符替换成空，这样剩下的都是数字
								temp = Integer.parseInt(str);
								if(temp>id){
									id = temp;//让id一直取最大的ID号
								}
							}
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					    patid = new String("P0"+String.valueOf((++id)));//最大的ID号+1即新建的Nid
						Patient patient = new Patient(patid, patname, patsex, Integer.parseInt(patage),pattele ,pataddr, patdescribe,
								patstatus,patdid);
						try {
							//如果使用者没有填写相应的文本框默认不改变值
							if(patientdao.PatientPrimary(conn, patient)==true){
								JOptionPane.showMessageDialog(null, "用户已存在！");
								return;
							}
							if(patientdao.PatientInsert(conn, patient)==1){
								JOptionPane.showMessageDialog(null, "添加成功！");
							}
							{
								//操作成功则刷新界面
								Pid.setText("");
								Pname.setText("");
								Page.setValue(0);
								Ptele.setText("");
								Paddr.setText("");
								fillTable(new Patient());
							}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}finally{
							util.closeConn();
						}
					}
				});
		fillTable(new Patient());
	}
	
	
	
	
	
	
	private void fillTable(Patient patient){
		DefaultTableModel dtm = (DefaultTableModel) patientTable.getModel();
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

