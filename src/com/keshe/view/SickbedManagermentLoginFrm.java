package com.keshe.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.SubstanceScrollPaneUI;
import org.jvnet.substance.button.StandardButtonShaper;
import org.jvnet.substance.skin.*;
import org.jvnet.substance.theme.SubstanceAquaTheme;
import org.jvnet.substance.watermark.SubstanceMagneticFieldWatermark;

import com.keshe.dao.UserDao;
import com.keshe.dao.UserDaoSub;
import com.keshe.model.User;
import com.keshe.tool.Connmethod;
import com.keshe.tool.StringUtil;
import com.mysql.jdbc.Connection;
import javax.swing.ImageIcon;
import java.awt.SystemColor;



public class SickbedManagermentLoginFrm extends JFrame {
    Connmethod connmethod=new Connmethod();
    UserDaoSub  userDaosub=new UserDaoSub();
	private JPanel contentPane;
	private JTextField accountTxt;
	private JPasswordField passwordTxt;
	public JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 JFrame.setDefaultLookAndFeelDecorated(true);
					 JDialog.setDefaultLookAndFeelDecorated(true);
					 UIManager.setLookAndFeel(new
							 SubstanceNebulaBrickWallLookAndFeel());
					 SubstanceLookAndFeel.setSkin(new GreenMagicSkin());
					 SubstanceLookAndFeel.setCurrentTheme(new SubstanceAquaTheme());
					 SubstanceLookAndFeel.setCurrentButtonShaper(new
							 StandardButtonShaper()); 
					 SubstanceLookAndFeel.setCurrentWatermark(new
							 SubstanceMagneticFieldWatermark()); 
					SickbedManagermentLoginFrm frame = new SickbedManagermentLoginFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SickbedManagermentLoginFrm() {
		setTitle("\u767B\u5F55\u754C\u9762");
		setResizable(false);
		//改变系统默认字体
				getContentPane().setFont(new Font("微软雅黑", Font.PLAIN, 20));
				Font font=new Font("Dialog",Font.PLAIN,12);
				java.util.Enumeration keys=UIManager.getDefaults().keys();
				while(keys.hasMoreElements()){
					Object key=keys.nextElement();
					Object value=UIManager.get( key);
					if(value instanceof javax.swing.plaf.FontUIResource){
						UIManager.put(key, font);
					}
				}
		//居中
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 390, 410);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel login = new JPanel();
		login.setBackground(SystemColor.control);
		login.setBounds(0, 0, 385, 382);
		contentPane.add(login);
		login.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SickbedManagermentLoginFrm.class.getResource("/resource/\u533B\u9662\u75C5\u623F\u7BA1\u740610.png")));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		label.setBounds(10, 10, 365, 98);
		login.add(label);
		
		accountTxt = new JTextField();
		accountTxt.setColumns(10);
		accountTxt.setBounds(125, 147, 108, 21);
		login.add(accountTxt);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(SickbedManagermentLoginFrm.class.getResource("/resource/\u7528\u6237\u540D\u80CC\u666F3.png")));
		label_1.setBackground(Color.CYAN);
		label_1.setBounds(22, 135, 261, 52);
		login.add(label_1);
		
		passwordTxt = new JPasswordField();
		passwordTxt.setBounds(125, 197, 108, 21);
		login.add(passwordTxt);
		
		JLabel label_2 = new JLabel("\u5BC6  \u7801");
		label_2.setIcon(new ImageIcon(SickbedManagermentLoginFrm.class.getResource("/resource/\u5BC6\u7801\u80CC\u666F2.png")));
		label_2.setBounds(22, 186, 246, 46);
		login.add(label_2);
		
		JComboBox typeTxt = new JComboBox();
		typeTxt.setModel(new DefaultComboBoxModel(new String[] {"\u7BA1\u7406\u5458", "\u533B\u751F", "\u62A4\u58EB", "\u75C5\u4EBA"}));
		typeTxt.setBounds(125, 245, 108, 21);
		login.add(typeTxt);
		
		JLabel label_3 = new JLabel("\u8EAB  \u4EFD");
		label_3.setIcon(new ImageIcon(SickbedManagermentLoginFrm.class.getResource("/resource/\u8EAB\u4EFD\u80CC\u666F\u672A\u6807\u9898-.png")));
		label_3.setBounds(22, 228, 261, 55);
		login.add(label_3);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(SickbedManagermentLoginFrm.class.getResource("/resource/\u767B\u96463.png")));
		
		
		button.setBounds(31, 293, 93, 39);
		login.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(SickbedManagermentLoginFrm.class.getResource("/resource/\u6CE8\u518C.png")));
		
	
		button_1.setBounds(171, 293, 93, 39);
		login.add(button_1);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(SickbedManagermentLoginFrm.class.getResource("/resource/\u80CC\u666F3.png")));
		label_4.setBounds(0, 0, 385, 382);
		login.add(label_4);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SickbedManagermentRegisterFrm reg = new SickbedManagermentRegisterFrm(login);
				reg.panel.setBounds(0, 0, 800, 500);
				reg.panel.setVisible(true);
				login.setVisible(false);
				contentPane.add(reg.panel);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Uaccount=accountTxt.getText();
				String Upassword=new String(passwordTxt.getPassword());
				String   Utype=(String) typeTxt.getSelectedItem();
				if(StringUtil.isEmpty(Uaccount)){
					JOptionPane.showMessageDialog(null, "用户名不能为空！");
					return;}
				if(Uaccount.contains("%")||Uaccount.contains("_")){
					return;
				}
				if(Uaccount.length()>8D||Uaccount.length()<3){
					return;
				}
				if(StringUtil.isEmpty(Upassword)){
					JOptionPane.showMessageDialog(null, "密码不能为空！");
					return;
				}
		          User user= new User (Uaccount,Upassword,Utype);
		          Connection conn =connmethod.createConn();
				try{
					ResultSet rs=userDaosub.UserSelect(conn, user);
					while(rs.next()){
						JOptionPane.showMessageDialog(null, "登录成功");
						frame = new ManagermentFrm(Uaccount,Utype);
						setVisible(false);
						frame.setVisible(true);
						return;
						}
						JOptionPane.showMessageDialog(null, "登录失败");
						 accountTxt.setText("");
						 passwordTxt.setText("");
				}
				catch (Exception e1){
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "登陆失败");
				}finally{
					connmethod.closeConn();
				}
				}
		});
	
	}
}
