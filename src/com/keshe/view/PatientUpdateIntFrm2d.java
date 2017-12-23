package com.keshe.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.keshe.dao.NurseDao;
import com.keshe.dao.NurseDaoSub;
import com.keshe.dao.PatientDao;
import com.keshe.dao.PatientDaoSub;
import com.keshe.model.Nurse;
import com.keshe.model.Patient;
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
import javax.swing.JScrollPane;

public class PatientUpdateIntFrm2d {
	public JPanel panel;
	PatientDaoSub patientdaosub = new PatientDaoSub();
	Connmethod util = new Connmethod();
	PatientDao patientdao = new PatientDao();
	private JTextField Pid;
	private JTable patientTable;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public PatientUpdateIntFrm2d(String Id,JPanel p) {
		panel = new JPanel();
		panel.setBounds(100, 100, 800, 500);
		panel.setLayout(null);
		
		ButtonGroup group = new ButtonGroup();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(105, 21, 626, 238);
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
		patientTable.getColumnModel().getColumn(0).setPreferredWidth(98);
		patientTable.getColumnModel().getColumn(4).setPreferredWidth(139);
		patientTable.getColumnModel().getColumn(5).setPreferredWidth(103);
		patientTable.getColumnModel().getColumn(6).setPreferredWidth(200);
		patientTable.getColumnModel().getColumn(7).setPreferredWidth(225);
		patientTable.getColumnModel().getColumn(8).setPreferredWidth(99);
		fillTable(new Patient());
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u4FEE\u6539\u4FE1\u606F\u680F\u76EE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(94, 282, 646, 187);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		Pid = new JTextField();
		Pid.setBounds(170, 43, 93, 21);
		panel_1.add(Pid);
		Pid.setColumns(10);
		
		JLabel label = new JLabel("病  号：");
		label.setBounds(106, 46, 54, 15);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("病  况：");
		label_1.setBounds(310, 49, 54, 15);
		panel_1.add(label_1);
		
		JTextArea Pdescribe = new JTextArea();
		Pdescribe.setBounds(362, 45, 173, 70);
		panel_1.add(Pdescribe);
		
		JButton button_4 = new JButton("退  出");
		button_4.setBounds(442, 125, 93, 39);
		panel_1.add(button_4);
		
	
		JButton Update = new JButton("修  改");
		Update.setBounds(106, 125, 93, 39);
		panel_1.add(Update);
		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String patId = Pid.getText();//病号
				if(StringUtil.isEmpty(patId)){
					JOptionPane.showMessageDialog(null,"病号不能为空");
					return;
				}
				String patName = null;
				String patTele = null;
				String patStatus = null;
				String patDescribe = Pdescribe.getText();//病况
				String patAddr = null;
				String patAge = "0";
				String patSex = "";//性别
				Connection conn = util.createConn();
				Patient patient = new Patient(patId);
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
							if(Integer.parseInt(patAge)==0){
								patient.setPage(rs.getInt("Page"));
							}
							if(StringUtil.isEmpty(patTele)){
								patient.setPtele(rs.getString("Ptele"));
							}
							if(StringUtil.isEmpty(patAddr)){
								patient.setPaddr(rs.getString("Paddr"));
							}
							patient.setPdescribe(patDescribe);
							if(StringUtil.isEmpty(patDescribe)){
								patient.setPdescribe(rs.getString("Pdescribe"));
							}
							if(StringUtil.isEmpty(patSex)){
								patient.setPsex(rs.getString("Psex"));
							}
							if(StringUtil.isEmpty(patStatus)){
								patient.setPstatus(rs.getString("Pstatus"));
							}
					
						}
					}
					if(patientdao.PatientUpdate(conn, patient)==1){
						JOptionPane.showMessageDialog(null, "修改成功！");
					}
					{
						//操作成功则刷新界面
						Pid.setText("");
						Pdescribe.setText("");
						fillTable(new Patient(null,Id));
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
					util.closeConn();
				}
			}
		});
		
		
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				p.removeAll();
			}
		});//退出子界面
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(94, 10, 646, 262);
		panel.add(panel_2);
		fillTable(new Patient(null,Id));
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

