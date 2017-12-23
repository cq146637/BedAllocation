package com.keshe.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.omg.CORBA.FloatSeqHelper;

import com.keshe.dao.NurseDao;
import com.keshe.dao.UserDao;
import com.keshe.model.Nurse;
import com.keshe.tool.Connmethod;
import com.keshe.tool.StringUtil;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JScrollPane;

public class NurseQueryIntFrm2n {
	Connmethod util = new Connmethod();
	NurseDao nursedao = new NurseDao();
	private JTable nurseTable;
	private JTextField nurseName;
	private JTextField nurseTele;
	public JPanel panel;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public NurseQueryIntFrm2n(JPanel p) {
		panel = new JPanel();
		panel.setBounds(100, 100, 800, 500);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 24, 711, 240);
		panel.add(scrollPane);
		
		nurseTable = new JTable();
		scrollPane.setViewportView(nurseTable);
		nurseTable.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		nurseTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u59D3\u540D", "\u6027\u522B", "\u7535\u8BDD"
			}
		));
		nurseTable.getColumnModel().getColumn(2).setPreferredWidth(185);
		
		ButtonGroup group = new ButtonGroup();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u67E5\u8BE2\u4FE1\u606F\u680F\u76EE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(28, 296, 748, 165);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_1 = new JLabel("\u59D3  \u540D\uFF1A");
		label_1.setBounds(311, 46, 54, 15);
		panel_1.add(label_1);
		
		nurseName = new JTextField();
		nurseName.setBounds(360, 43, 66, 21);
		panel_1.add(nurseName);
		nurseName.setColumns(10);
		
		JLabel label_3 = new JLabel("\u6027  \u522B\uFF1A");
		label_3.setBounds(492, 46, 54, 15);
		panel_1.add(label_3);
		
		JRadioButton nurseSexM = new JRadioButton("\u7537");
		nurseSexM.setBounds(555, 41, 47, 23);
		panel_1.add(nurseSexM);
		group.add(nurseSexM);
		
		JRadioButton nurseSexF = new JRadioButton("\u5973");
		nurseSexF.setBounds(598, 41, 47, 23);
		panel_1.add(nurseSexF);
		group.add(nurseSexF);
		
		JLabel label_4 = new JLabel("\u7535  \u8BDD\uFF1A");
		label_4.setBounds(101, 49, 54, 15);
		panel_1.add(label_4);
		
		nurseTele = new JTextField();
		nurseTele.setBounds(158, 46, 91, 21);
		panel_1.add(nurseTele);
		nurseTele.setColumns(10);
		
		JButton button = new JButton("\u91CD\u7F6E");
		button.setBounds(129, 95, 93, 41);
		panel_1.add(button);
		
		JButton button_1 = new JButton("\u67E5\u8BE2");
		button_1.setBounds(350, 95, 93, 41);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("\u9000\u51FA");
		button_2.setBounds(564, 95, 93, 41);
		panel_1.add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				p.removeAll();
			}
		});
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//  查询
				String nurName = nurseName.getText();
				//年龄限制条件（下限），如果无输入则默认设0
				//获取性别
				String nurSex = "";
				if(nurseSexF.isSelected()){
					nurSex = "女";
				}
				else if(nurseSexM.isSelected()){
					nurSex = "男";
				}
				String nurTele = nurseTele.getText();
				Nurse nurse = new Nurse(nurName,nurSex,nurTele);
				fillTable(nurse);//刷新表，并显示查询内容
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//  重置
				nurseName.setText("");
				group.clearSelection();
				nurseTele.setText("");
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(28, 10, 748, 276);
		panel.add(panel_2);
		
		fillTable(new Nurse());//刷新表，并显示查询内容

	}
	private void fillTable(Nurse nurse){
		DefaultTableModel dtm = (DefaultTableModel) nurseTable.getModel();
		dtm.setRowCount(0);
		Connection conn=null;
		try{
			conn= util.createConn();
			ResultSet rs =nursedao.NurseSelect(conn,nurse);
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getString("Nname"));
				v.add(rs.getString("Nsex"));
				v.add(rs.getString("Ntele"));
				dtm.addRow(v);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			util.closeConn();
		}
	}
}
