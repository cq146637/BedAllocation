package com.keshe.view;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.keshe.dao.BedDao;
import com.keshe.dao.DoctorDao;
import com.keshe.dao.NurseDao;
import com.keshe.dao.PatientDao;
import com.keshe.model.Bed;
import com.keshe.model.Doctor;
import com.keshe.model.Nurse;
import com.keshe.model.Patient;
import com.keshe.tool.Connmethod;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Window;

import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;



public class ManagermentFrm extends JFrame {

	private static JPanel contentPane;
	private JTextField Name;
	private JTextField Age;
	private JTextField Sex;
	private JTextField Status;
	private JTextField Tele;
	private Connmethod util = new Connmethod();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ManagerFrm3 frame = new ManagerFrm3("","");
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ManagermentFrm(String Id,String Type) {
		setBackground(SystemColor.text);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1380, 725);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u7CFB\u7EDF\u8BBE\u7F6E");
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItem_32 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		menuItem_32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rs = JOptionPane.showConfirmDialog(null, "是否退出系统！");
				if(rs == 0)
					dispose();
			}
		});
		
		mnNewMenu.add(menuItem_32);
		
		JMenu mnNewMenu_1 = new JMenu("\u5E2E\u52A9");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem menuItem_33 = new JMenuItem("\u7CFB\u7EDF\u7B80\u4ECB");
		menuItem_33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "本系统面向医院人员使用，分为管理员、医生、护士、病子系统");
			}
		});
		
		mnNewMenu_1.add(menuItem_33);
		
		JMenu mnNewMenu_2 = new JMenu("\u5173\u4E8E\u6211\u4EEC");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmQq = new JMenuItem("QQ");
		mntmQq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "QQ:1426999640");
			}
		});
		mnNewMenu_2.add(mntmQq);
		
		JMenuItem menuItem_36 = new JMenuItem("\u90AE\u7BB1");
		menuItem_36.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "jiduoduo@163.com！");
			}
		});
		mnNewMenu_2.add(menuItem_36);
		
		JMenuItem menuItem_37 = new JMenuItem("\u4F4F\u5740");
		menuItem_37.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "中北大学计算机与控制学院网络工程！");
			}
		});
		mnNewMenu_2.add(menuItem_37);
		
		JMenu menu_12 = new JMenu("\u5B50\u7CFB\u7EDF");
		menuBar.add(menu_12);
		
		JMenuItem menuItem_8 = new JMenuItem("\u7BA1\u7406\u5458\u7CFB\u7EDF");
		
		
		menu_12.add(menuItem_8);
		
		JMenuItem menuItem_1 = new JMenuItem("\u533B\u751F\u5B50\u7CFB\u7EDF");
		
		menu_12.add(menuItem_1);
		
		JMenuItem nurseSystem = new JMenuItem("\u62A4\u58EB\u5B50\u7CFB\u7EDF");
		

		menu_12.add(nurseSystem);
		
		JMenuItem menuItem_7 = new JMenuItem("\u75C5\u4EBA\u5B50\u7CFB\u7EDF");
		
		menu_12.add(menuItem_7);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1364, 32);
		panel.setVisible(true);//管理员登录显示：true
		contentPane.add(panel);
		panel.setLayout(null);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(0, 0, 1364, 32);
		panel.add(menuBar_1);
		
		JMenu menu_6 = new JMenu("\u7CFB\u7EDF\u7EDF\u8BA1\u4FE1\u606F");
		menu_6.setIcon(new ImageIcon(ManagermentFrm.class.getResource("/resource/\u83DC\u5355\u680F\u4FEE\u9970.png")));
		menuBar_1.add(menu_6);
		
		JMenuItem menuItem_23 = new JMenuItem("\u5C55\u793A\u7EDF\u8BA1\u4FE1\u606F");
		menuItem_23.setIcon(new ImageIcon(ManagermentFrm.class.getResource("/resource/\u7EDF\u8BA11.jpg")));
		
		menu_6.add(menuItem_23);
		
		JMenu menu = new JMenu("\u7528\u6237\u4FE1\u606F\u7BA1\u7406");
		menu.setIcon(new ImageIcon(ManagermentFrm.class.getResource("/resource/\u83DC\u5355\u680F\u4FEE\u9970.png")));
		menuBar_1.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u7528\u6237\u4FE1\u606F\u7BA1\u7406");
		menuItem.setIcon(new ImageIcon(ManagermentFrm.class.getResource("/resource/\u7528\u6237\u7BA1\u74061.jpg")));
	
		menu.add(menuItem);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u7528\u6237\u4FE1\u606F\u67E5\u8BE2");
		mntmNewMenuItem.setIcon(new ImageIcon(ManagermentFrm.class.getResource("/resource/\u7528\u6237\u67E5\u8BE25.jpg")));
		
		menu.add(mntmNewMenuItem);
		
		JMenu menu_1 = new JMenu("\u533B\u751F\u4FE1\u606F\u7BA1\u7406");
		menu_1.setIcon(new ImageIcon(ManagermentFrm.class.getResource("/resource/\u83DC\u5355\u680F\u4FEE\u9970.png")));
		menuBar_1.add(menu_1);
		
		JMenuItem menuItem_5 = new JMenuItem("\u533B\u751F\u4FE1\u606F\u7BA1\u7406");
		menuItem_5.setIcon(new ImageIcon(ManagermentFrm.class.getResource("/resource/\u533B\u751F\u7BA1\u74061.jpg")));
		
		menu_1.add(menuItem_5);
		
		JMenuItem menuItem_6 = new JMenuItem("\u533B\u751F\u4FE1\u606F\u67E5\u8BE2");
		menuItem_6.setIcon(new ImageIcon(ManagermentFrm.class.getResource("/resource/\u533B\u751F\u67E5\u8BE2-2.jpg")));
		
		menu_1.add(menuItem_6);
		
		JMenu menu_2 = new JMenu("\u62A4\u58EB\u4FE1\u606F\u7BA1\u7406");
		menu_2.setIcon(new ImageIcon(ManagermentFrm.class.getResource("/resource/\u83DC\u5355\u680F\u4FEE\u9970.png")));
		menuBar_1.add(menu_2);
		
		JMenuItem menuItem_9 = new JMenuItem("\u62A4\u58EB\u4FE1\u606F\u7BA1\u7406");
		menuItem_9.setIcon(new ImageIcon(ManagermentFrm.class.getResource("/resource/\u62A4\u58EB\u7BA1\u74063.jpg")));
		
		menu_2.add(menuItem_9);
		
		JMenuItem menuItem_10 = new JMenuItem("\u62A4\u58EB\u4FE1\u606F\u67E5\u8BE2");
		menuItem_10.setIcon(new ImageIcon(ManagermentFrm.class.getResource("/resource/\u62A4\u58EB\u67E5\u8BE21.jpg")));

		menu_2.add(menuItem_10);
		
		JMenu menu_3 = new JMenu("\u75C5\u4EBA\u4FE1\u606F\u7BA1\u7406");
		menu_3.setIcon(new ImageIcon(ManagermentFrm.class.getResource("/resource/\u83DC\u5355\u680F\u4FEE\u9970.png")));
		menuBar_1.add(menu_3);
		
		JMenuItem menuItem_13 = new JMenuItem("\u75C5\u4EBA\u4FE1\u606F\u7BA1\u7406");
		
		menuItem_13.setIcon(new ImageIcon(ManagermentFrm.class.getResource("/resource/\u75C5\u4EBA\u7BA1\u74062.jpg")));
		menu_3.add(menuItem_13);
		
		JMenuItem menuItem_14 = new JMenuItem("\u75C5\u4EBA\u4FE1\u606F\u67E5\u8BE2");
		
		menuItem_14.setIcon(new ImageIcon(ManagermentFrm.class.getResource("/resource/\u75C5\u4EBA\u67E5\u8BE21.jpg")));
		menu_3.add(menuItem_14);
		
		JMenu menu_4 = new JMenu("\u75C5\u5E8A\u4FE1\u606F\u7BA1\u7406");
		menu_4.setIcon(new ImageIcon(ManagermentFrm.class.getResource("/resource/\u83DC\u5355\u680F\u4FEE\u9970.png")));
		menuBar_1.add(menu_4);
		
		JMenuItem menuItem_17 = new JMenuItem("\u75C5\u5E8A\u4FE1\u606F\u7BA1\u7406");
		menuItem_17.setIcon(new ImageIcon(ManagermentFrm.class.getResource("/resource/\u75C5\u5E8A\u7BA1\u74061.jpg")));
		
		menu_4.add(menuItem_17);
		
		JMenuItem menuItem_18 = new JMenuItem("\u75C5\u5E8A\u4FE1\u606F\u67E5\u8BE2");
		menuItem_18.setIcon(new ImageIcon(ManagermentFrm.class.getResource("/resource/\u75C5\u5E8A\u67E5\u8BE22.jpg")));
		
		menu_4.add(menuItem_18);
		
		JMenu menu_5 = new JMenu("\u5206\u914D\u4FE1\u606F\u7BA1\u7406");
		menu_5.setIcon(new ImageIcon(ManagermentFrm.class.getResource("/resource/\u83DC\u5355\u680F\u4FEE\u9970.png")));
		menuBar_1.add(menu_5);
		
		JMenuItem menuItem_21 = new JMenuItem("\u5206\u914D\u4FE1\u606F\u7BA1\u7406");
		menuItem_21.setIcon(new ImageIcon(ManagermentFrm.class.getResource("/resource/\u5E8A\u4F4D\u5206\u914D2.jpg")));
		
		menu_5.add(menuItem_21);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1364, 32);
		panel_1.setVisible(false);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JMenuBar menuBar_2 = new JMenuBar();
		menuBar_2.setBounds(0, 0, 1364, 32);
		panel_1.add(menuBar_2);
		
		JMenu menu_8 = new JMenu("\u4E3B\u6CBB\u533B\u751F");
		menu_8.setIcon(new ImageIcon(ManagermentFrm.class.getResource("/resource/\u83DC\u5355\u680F\u4FEE\u9970.png")));
		
		menuBar_2.add(menu_8);
		
		JMenuItem menuItem_25 = new JMenuItem("\u57FA\u672C\u4FE1\u606F\u67E5\u770B");
		menuItem_25.setIcon(new ImageIcon(ManagermentFrm.class.getResource("/resource/\u75C5\u4EBA\u67E5\u8BE21.jpg")));
		
		menu_8.add(menuItem_25);
		
		JMenu mnNewMenu_3 = new JMenu("\u4E2A\u4EBA\u4FE1\u606F");
		mnNewMenu_3.setIcon(new ImageIcon(ManagermentFrm.class.getResource("/resource/\u83DC\u5355\u680F\u4FEE\u9970.png")));
		menuBar_2.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u4E2A\u4EBA\u4FE1\u606F\u4FEE\u6539");
		mntmNewMenuItem_2.setIcon(new ImageIcon(ManagermentFrm.class.getResource("/resource/\u75C5\u4EBA\u7BA1\u74062.jpg")));

		mnNewMenu_3.add(mntmNewMenuItem_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 1364, 32);
		panel_2.setVisible(false);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JMenuBar menuBar_3 = new JMenuBar();
		menuBar_3.setBounds(0, 0, 1364, 32);
		panel_2.add(menuBar_3);
		
		JMenu menu_9 = new JMenu("\u533B\u751F\u4FE1\u606F");
		menu_9.setIcon(new ImageIcon(ManagermentFrm.class.getResource("/resource/\u83DC\u5355\u680F\u4FEE\u9970.png")));
		menuBar_3.add(menu_9);
		
		JMenuItem menuItem_24 = new JMenuItem("\u533B\u751F\u4FE1\u606F\u67E5\u8BE2");
		menuItem_24.setIcon(new ImageIcon(ManagermentFrm.class.getResource("/resource/\u533B\u751F\u67E5\u8BE2-2.jpg")));
		
		menu_9.add(menuItem_24);
		
		JMenuItem menuItem_31 = new JMenuItem("\u4E2A\u4EBA\u4FE1\u606F\u4FEE\u6539");
		menuItem_31.setIcon(new ImageIcon(ManagermentFrm.class.getResource("/resource/\u533B\u751F\u7BA1\u74061.jpg")));
		
		menu_9.add(menuItem_31);
		
		JMenu menu_7 = new JMenu("\u75C5\u4EBA\u4FE1\u606F");
		menu_7.setIcon(new ImageIcon(ManagermentFrm.class.getResource("/resource/\u83DC\u5355\u680F\u4FEE\u9970.png")));
		menuBar_3.add(menu_7);
		
		JMenuItem menuItem_26 = new JMenuItem("\u8D1F\u8D23\u75C5\u4EBA\u4FE1\u606F");
		menuItem_26.setIcon(new ImageIcon(ManagermentFrm.class.getResource("/resource/\u75C5\u4EBA\u67E5\u8BE21.jpg")));
		
		menu_7.add(menuItem_26);
		
		JMenuItem menuItem_27 = new JMenuItem("\u75C5\u4EBA\u4FE1\u606F\u4FEE\u6539");
		menuItem_27.setIcon(new ImageIcon(ManagermentFrm.class.getResource("/resource/\u75C5\u4EBA\u7BA1\u74062.jpg")));
		
		menu_7.add(menuItem_27);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 1364, 32);
		panel_3.setVisible(false);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JMenuBar menuBar_4 = new JMenuBar();
		menuBar_4.setBounds(0, 0, 1364, 32);
		panel_3.add(menuBar_4);
		
		JMenu menu_10 = new JMenu("\u62A4\u58EB\u4FE1\u606F");
		menu_10.setIcon(new ImageIcon(ManagermentFrm.class.getResource("/resource/\u83DC\u5355\u680F\u4FEE\u9970.png")));
		menuBar_4.add(menu_10);
		
		JMenuItem menuItem_28 = new JMenuItem("\u62A4\u58EB\u4FE1\u606F\u67E5\u8BE2");
		menuItem_28.setIcon(new ImageIcon(ManagermentFrm.class.getResource("/resource/\u62A4\u58EB\u67E5\u8BE21.jpg")));
		
		menu_10.add(menuItem_28);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u4E2A\u4EBA\u4FE1\u606F\u4FEE\u6539");
		mntmNewMenuItem_1.setIcon(new ImageIcon(ManagermentFrm.class.getResource("/resource/\u62A4\u58EB\u7BA1\u74063.jpg")));
		
		menu_10.add(mntmNewMenuItem_1);
		
		JMenu menu_11 = new JMenu("\u5E8A\u4F4D\u4FE1\u606F");
		menu_11.setIcon(new ImageIcon(ManagermentFrm.class.getResource("/resource/\u83DC\u5355\u680F\u4FEE\u9970.png")));
		menuBar_4.add(menu_11);
		
		JMenuItem menuItem_29 = new JMenuItem("\u5E8A\u4F4D\u67E5\u8BE2\u5DE1\u68C0");
		menuItem_29.setIcon(new ImageIcon(ManagermentFrm.class.getResource("/resource/\u75C5\u5E8A\u7BA1\u74061.jpg")));
		
		menu_11.add(menuItem_29);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBackground(SystemColor.text);
		panel_4.setBounds(0, 31, 251, 655);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel label = new JLabel("\u59D3  \u540D\uFF1A");
		label.setFont(new Font("华文彩云", Font.PLAIN, 14));
		label.setBounds(23, 171, 54, 15);
		panel_4.add(label);
		
		Name = new JTextField();
		Name.setEditable(false);
		Name.setBounds(87, 168, 66, 21);
		panel_4.add(Name);
		Name.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5E74  \u9F84\uFF1A");
		label_1.setFont(new Font("华文彩云", Font.PLAIN, 14));
		label_1.setBounds(23, 229, 54, 15);
		panel_4.add(label_1);
		
		Age = new JTextField();
		Age.setEditable(false);
		Age.setBounds(87, 226, 66, 21);
		panel_4.add(Age);
		Age.setColumns(10);
		
		JLabel label_2 = new JLabel("\u6027  \u522B\uFF1A");
		label_2.setFont(new Font("华文彩云", Font.PLAIN, 14));
		label_2.setBounds(23, 289, 54, 15);
		panel_4.add(label_2);
		
		Sex = new JTextField();
		Sex.setEditable(false);
		Sex.setBounds(87, 286, 66, 21);
		panel_4.add(Sex);
		Sex.setColumns(10);
		
		JLabel label_3 = new JLabel("\u72B6  \u6001\uFF1A");
		label_3.setFont(new Font("华文彩云", Font.PLAIN, 14));
		label_3.setBounds(23, 350, 54, 15);
		panel_4.add(label_3);
		
		Status = new JTextField();
		Status.setEditable(false);
		Status.setBounds(87, 347, 66, 21);
		panel_4.add(Status);
		Status.setColumns(10);
		
		JLabel label_4 = new JLabel("\u7535  \u8BDD\uFF1A");
		label_4.setFont(new Font("华文彩云", Font.PLAIN, 14));
		label_4.setBounds(23, 408, 54, 15);
		panel_4.add(label_4);
		
		Tele = new JTextField();
		Tele.setEditable(false);
		Tele.setBounds(87, 405, 143, 21);
		panel_4.add(Tele);
		Tele.setColumns(10);
		
		JLabel label_5 = new JLabel("\u5730  \u5740\uFF1A");
		label_5.setFont(new Font("华文彩云", Font.PLAIN, 14));
		label_5.setBounds(23, 479, 54, 15);
		panel_4.add(label_5);
		
		JTextArea Address = new JTextArea();
		Address.setBackground(Color.WHITE);
		Address.setForeground(Color.BLACK);
		Address.setLineWrap(true);
		Address.setEditable(false);
		Address.setBounds(87, 459, 143, 74);
		panel_4.add(Address);
		
		JLabel patlb = new JLabel("\u75C5  \u60C5\uFF1A");
		patlb.setFont(new Font("华文彩云", Font.PLAIN, 14));
		patlb.setBounds(23, 562, 54, 15);
		panel_4.add(patlb);
		
		JTextArea Describe = new JTextArea();
		Describe.setEditable(false);
		Describe.setLineWrap(true);
		Describe.setBounds(87, 543, 143, 74);
		panel_4.add(Describe);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(ManagermentFrm.class.getResource("/resource/\u7528\u6237\u4FE1\u606F.png")));
		label_6.setBounds(87, 69, 145, 59);
		panel_4.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(ManagermentFrm.class.getResource("/resource/\u4E3B\u9875\u56FE\u6807.png")));
		label_7.setBounds(10, 69, 85, 53);
		panel_4.add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(ManagermentFrm.class.getResource("/resource/\u80CC\u666F\u5BF9\u63A51.png")));
		label_8.setBounds(0, 0, 250, 655);
		panel_4.add(label_8);

//		JPanel panel_5 = new HomePanel();
//		panel_5.setBounds(250, 31, 1114, 650);
//		contentPane.add(panel_5);
		JPanel panel_6 = new PicPanel();
		panel_6.setBackground(SystemColor.textHighlight);
		panel_6.setBounds(250, 31, 1114, 655);
		panel_6.setVisible(true);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		{//个人信息展示
			if(Type == "管理员"||Type == "医生"){
				Connection conn = util.createConn();
				DoctorDao docdao = new DoctorDao();
				Doctor doc = new Doctor(Id);
				try {
					ResultSet rs = docdao.DoctorSelect(conn, doc);
					while(rs.next()){
						Name.setText(rs.getString("Dname"));
						Age.setText(rs.getString("Dage"));
						Sex.setText(rs.getString("Dsex"));
						Status.setText(rs.getString("Dstatus"));
						Tele.setText(rs.getString("Dtele"));
						Address.setText(rs.getString("Daddr"));
					}
					patlb.setVisible(false);
					Describe.setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if(Type == "护士"){
				Connection conn = util.createConn();
				NurseDao nurdao = new NurseDao();
				BedDao beddao = new BedDao();
				Nurse nur = new Nurse(Id);
				Bed bed = new Bed(null,Id);
				try {
					ResultSet rs = nurdao.NurseSelect(conn, nur);
					while(rs.next()){
						Name.setText(rs.getString("Nname"));
						Age.setText(rs.getString("Nage"));
						Sex.setText(rs.getString("Nsex"));
						Status.setText(rs.getString("Nstatus"));
						Tele.setText(rs.getString("Ntele"));
						Address.setText(rs.getString("Naddr"));
					}
					rs = beddao.BedSelect(conn, bed);
					int Count = 0;//弹窗提示护士需要巡检的床位数量
					while(rs.next()){
						Count++;
					}
					JOptionPane.showMessageDialog(null, "您今日需要巡查["+Count+"]张病床！");
					patlb.setVisible(false);
					Describe.setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if(Type == "病人"){
				Connection conn = util.createConn();
				PatientDao patdao = new PatientDao();
				Patient pat = new Patient(Id);
				try {
					ResultSet rs = patdao.PatientSelect(conn, pat);
					while(rs.next()){
						Name.setText(rs.getString("Pname"));
						Age.setText(rs.getString("Page"));
						Sex.setText(rs.getString("Psex"));
						Status.setText(rs.getString("Pstatus"));
						Tele.setText(rs.getString("Ptele"));
						Address.setText(rs.getString("Paddr"));
						Describe.setText(rs.getString("Pdescribe"));
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
			}
		});
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(true);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
			}
		});
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(false);
				panel_2.setVisible(true);
				panel_3.setVisible(false);
			}
		});
		nurseSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(true);
			}
		});
		if(Type == "管理员"){
			panel.setVisible(true);
			panel_1.setVisible(false);
			panel_2.setVisible(false);
			panel_3.setVisible(false);
		}
		else if(Type == "护士"){
			panel.setVisible(false);
			panel_1.setVisible(false);
			panel_2.setVisible(false);
			panel_3.setVisible(true);
		}
		else if(Type == "医生"){
			panel.setVisible(false);
			panel_1.setVisible(false);
			panel_2.setVisible(true);
			panel_3.setVisible(false);
		}
		else if(Type == "病人"){
			panel.setVisible(false);
			panel_1.setVisible(true);
			panel_2.setVisible(false);
			panel_3.setVisible(false);
		}
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(panel_6.getComponentCount()==1){
					return;
				}
				UserUpdateIntFrm user = new UserUpdateIntFrm(panel_6);
				user.panel.setBounds(160, 60, 800, 500);
				user.panel.setVisible(true);
				panel_6.add(user.panel);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(panel_6.getComponentCount()==1){
					return;
				}
				UserQueryIntFrm user = new UserQueryIntFrm(panel_6);
				user.panel.setBounds(160, 60, 800, 500);
				user.panel.setVisible(true);
				panel_6.add(user.panel);
				contentPane.revalidate(); 
				contentPane.repaint();
			}
		});
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(panel_6.getComponentCount()==1){
					return;
				}
				NurseUpdateIntFrm nurse = new NurseUpdateIntFrm(panel_6);
				nurse.panel.setBounds(160, 60, 800, 500);
				nurse.panel.setVisible(true);
				panel_6.add(nurse.panel);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		menuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(panel_6.getComponentCount()==1){
					return;
				}
				NurseQueryIntFrm nurse = new NurseQueryIntFrm(panel_6);
				nurse.panel.setBounds(160, 60, 800, 500);
				nurse.panel.setVisible(true);
				panel_6.add(nurse.panel);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		menuItem_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(panel_6.getComponentCount()==1){
					return;
				}
				BedUpdateIntFrm bed = new BedUpdateIntFrm(panel_6);
				bed.panel.setBounds(160, 60, 800, 500);
				bed.panel.setVisible(true);
				panel_6.add(bed.panel);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		menuItem_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(panel_6.getComponentCount()==1){
					return;
				}
				BedQueryIntFrm bed = new BedQueryIntFrm(panel_6);
				bed.panel.setBounds(160, 60, 800, 500);
				bed.panel.setVisible(true);
				panel_6.add(bed.panel);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		menuItem_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(panel_6.getComponentCount()==1){
					return;
				}
				AllocationUpdateIntFrm allo = new AllocationUpdateIntFrm(panel_6);
				allo.panel.setBounds(160, 60, 800, 500);
				allo.panel.setVisible(true);
				panel_6.add(allo.panel);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		menuItem_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(panel_6.getComponentCount()==1){
					return;
				}
				StatisticsIntFrm allo = new StatisticsIntFrm(panel_6);
				allo.panel.setBounds(160, 60, 800, 500);
				allo.panel.setVisible(true);
				panel_6.add(allo.panel);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		menuItem_28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(panel_6.getComponentCount()==1){
					return;
				}
				NurseQueryIntFrm2n nurse = new NurseQueryIntFrm2n(panel_6);
				nurse.panel.setBounds(160, 60, 800, 500);
				nurse.panel.setVisible(true);
				panel_6.add(nurse.panel);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(panel_6.getComponentCount()==1){
					return;
				}
				NurseUpdateIntFrm2n nurse = new NurseUpdateIntFrm2n(Id,panel_6);
				nurse.panel.setBounds(160, 60, 800, 500);
				nurse.panel.setVisible(true);
				panel_6.add(nurse.panel);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		menuItem_29.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(panel_6.getComponentCount()==1){
					return;
				}
				BedUpdateIntFrm2n bed = new BedUpdateIntFrm2n(Id,panel_6);
				bed.panel.setBounds(160, 60, 800, 500);
				bed.panel.setVisible(true);
				panel_6.add(bed.panel);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(panel_6.getComponentCount()==1){
					return;
				}
				DoctorUpdateIntFrm bed = new DoctorUpdateIntFrm(panel_6);
				bed.panel.setBounds(160, 60, 800, 500);
				bed.panel.setVisible(true);
				panel_6.add(bed.panel);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(panel_6.getComponentCount()==1){
					return;
				}
				DoctorQueryIntFrm bed = new DoctorQueryIntFrm(panel_6);
				bed.panel.setBounds(160, 60, 800, 500);
				bed.panel.setVisible(true);
				panel_6.add(bed.panel);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		menuItem_25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(panel_6.getComponentCount()==1){
					return;
				}
				DoctorQueryIntFrm2p pat = new DoctorQueryIntFrm2p(Id,panel_6);
				pat.panel.setBounds(160, 60, 800, 500);
				pat.panel.setVisible(true);
				panel_6.add(pat.panel);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(panel_6.getComponentCount()==1){
					return;
				}
				PatientUpdateIntFrm2p pat = new PatientUpdateIntFrm2p(Id,panel_6);
				pat.panel.setBounds(160, 60, 800, 500);
				pat.panel.setVisible(true);
				panel_6.add(pat.panel);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		menuItem_24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(panel_6.getComponentCount()==1){
					return;
				}
				DoctorQueryIntFrm bed = new DoctorQueryIntFrm(panel_6);
				bed.panel.setBounds(160, 60, 800, 500);
				bed.panel.setVisible(true);
				panel_6.add(bed.panel);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		menuItem_31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(panel_6.getComponentCount()==1){
					return;
				}
				DoctorUpdateIntFrm2d bed = new DoctorUpdateIntFrm2d(Id,panel_6);
				bed.panel.setBounds(160, 60, 800, 500);
				bed.panel.setVisible(true);
				panel_6.add(bed.panel);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		menuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(panel_6.getComponentCount()==1){
					return;
				}
				PatientUpdateIntFrm pat = new PatientUpdateIntFrm(panel_6);
				pat.panel.setBounds(160, 60, 800, 500);
				pat.panel.setVisible(true);
				panel_6.add(pat.panel);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		menuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(panel_6.getComponentCount()==1){
					return;
				}
				PatientQueryIntFrm pat = new PatientQueryIntFrm(panel_6);
				pat.panel.setBounds(160, 60, 800, 500);
				pat.panel.setVisible(true);
				panel_6.add(pat.panel);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		menuItem_26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(panel_6.getComponentCount()==1){
					return;
				}
				PatientQueryInfFrm2d pat = new PatientQueryInfFrm2d(Id,panel_6);
				pat.panel.setBounds(160, 60, 800, 500);
				pat.panel.setVisible(true);
				panel_6.add(pat.panel);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		menuItem_27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(panel_6.getComponentCount()==1){
					return;
				}
				PatientUpdateIntFrm2d pat = new PatientUpdateIntFrm2d(Id,panel_6);
				pat.panel.setBounds(160, 60, 800, 500);
				pat.panel.setVisible(true);
				panel_6.add(pat.panel);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
	}
}
