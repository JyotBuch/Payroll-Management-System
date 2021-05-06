package Payroll_Management_System;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Font;
import java.awt.Color;

class Database {

	public static Connection conn;

	static Connection connectDatabase(String uid, String pwd) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/payrollmanagementdb", "root", "jyot123");
			return conn;
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Connection Error");
			return null;
		}
	}
}


public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField userlogin;
	private JPasswordField userpassword;
	private JTextField orgID;
	public static int orgid;
	public static int empid;
	public static String orgname;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1097, 756);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel useremployeeidtxt = new JLabel("Employee ID");
		useremployeeidtxt.setForeground(Color.BLACK);
		useremployeeidtxt.setHorizontalAlignment(SwingConstants.CENTER);
		useremployeeidtxt.setFont(new Font("Times New Roman", Font.BOLD, 18));
		useremployeeidtxt.setBounds(277, 343, 148, 22);
		contentPane.add(useremployeeidtxt);
		useremployeeidtxt.setVisible(false);

		JLabel userpasswordtxt = new JLabel("Password");
		userpasswordtxt.setForeground(Color.BLACK);
		userpasswordtxt.setHorizontalAlignment(SwingConstants.CENTER);
		userpasswordtxt.setFont(new Font("Times New Roman", Font.BOLD, 18));
		userpasswordtxt.setBounds(277, 436, 148, 22);
		contentPane.add(userpasswordtxt);
		userpasswordtxt.setVisible(false);

		userlogin = new JTextField();
		userlogin.setFont(new Font("Times New Roman", Font.BOLD, 18));
		userlogin.setToolTipText("Enter login id here");
		userlogin.setBounds(659, 344, 185, 31);
		contentPane.add(userlogin);
		userlogin.setColumns(10);
		userlogin.setVisible(false);

		userpassword = new JPasswordField();
		userpassword.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		userpassword.setToolTipText("Enter Password here");
		userpassword.setBounds(659, 432, 185, 31);
		contentPane.add(userpassword);
		userpassword.setVisible(false);

		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnLogin.setVisible(false);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("BEFORE GETTEXT");
				String uid = userlogin.getText().toString();
				String pwd = userpassword.getText().toString();
				//System.out.println("AFTER GETTEXT");
				String a="admin";
				try {	
					//System.out.println("IN TRY");
					Connection conn = Database.connectDatabase(uid, pwd);
					//System.out.println("MAYBE CONNECTION");
					orgid=Integer.valueOf(orgID.getText().toString());
					if((uid.substring(uid.length()-1, uid.length()).equals(String.valueOf(orgid))))
					{
						//System.out.println("MAYBE IF CHECK 1");
						//System.out.println("Hello");
						PreparedStatement ps= conn.prepareStatement("select * from user where userid=? and password=sha1(?)");
						ps.setString(1, uid);
						ps.setString(2, pwd);
						ResultSet rs=ps.executeQuery();
						//System.out.println("hello");
						//System.out.println(uid+" "+pwd);
						//ResultSet rs2=ps.e
						//System.out.println("Hello 1");
						//System.out.println(rs.getString(1));

						if(rs.next())
						{
							//System.out.println(rs.getString(3));
							if(rs.getString(3).equals(a))
							{
								JOptionPane.showMessageDialog(null, "Logging in as Admin for organization "+orgid);
								dispose();
								AdministratorHome adminh = new AdministratorHome();

								adminh.setVisible(true);
							}

							else if(rs.getString(3).equals("employee"))
							{
								int position = uid.lastIndexOf("$");
								empid = Integer.valueOf(uid.substring(0, position));
								JOptionPane.showMessageDialog(null, "Logging in as Employee for organization "+orgid);
								EmployeeHomePage emp = new EmployeeHomePage();
								emp.setVisible(true);
								dispose();
							}
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid UserID");

					}

				}

				catch (Exception e1) {
					//System.out.println(e1);
					JOptionPane.showMessageDialog(null, "Login Failed! Error: "+e1);
				}

			}
		});
		btnLogin.setBounds(476, 507, 155, 39);
		contentPane.add(btnLogin);

		JLabel lblEnterOrganization = new JLabel("Organization");
		lblEnterOrganization.setForeground(Color.BLACK);
		lblEnterOrganization.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterOrganization.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblEnterOrganization.setBounds(277, 199, 148, 31);
		contentPane.add(lblEnterOrganization);

		orgID = new JTextField();
		orgID.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		orgID.setBounds(659, 204, 185, 31);
		contentPane.add(orgID);
		orgID.setColumns(10);

		JButton btnEnter = new JButton("Enter");
		btnEnter.setBackground(Color.WHITE);
		btnEnter.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					orgid=Integer.valueOf(orgID.getText().toString());
					Connection conn = Database.connectDatabase("root", "jyot123");
					PreparedStatement ps = conn.prepareStatement("select * from organization where orgid=?");
					ps.setInt(1, orgid);
					ResultSet rs= ps.executeQuery()	;
					if(rs.next())
					{
						userpasswordtxt.setVisible(true);
						useremployeeidtxt.setVisible(true);
						userlogin.setVisible(true);
						userpassword.setVisible(true);
						btnLogin.setVisible(true);
						btnEnter.setVisible(false);
						orgname=rs.getString(2);
					}
					conn.close();

				} catch (Exception e) {
					//System.out.println(e);
					JOptionPane.showMessageDialog(null, "Error Signing in! Wrong Organization\nGetting Error: "+e);

				}
			}
		});
		
		
		
		btnEnter.setBounds(476, 278, 162, 39);
		contentPane.add(btnEnter);
		
		JLabel lblPayrollManagementSystem = new JLabel("Payroll Management System");
		lblPayrollManagementSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblPayrollManagementSystem.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblPayrollManagementSystem.setBounds(12, 13, 1055, 31);
		contentPane.add(lblPayrollManagementSystem);
	}
}
