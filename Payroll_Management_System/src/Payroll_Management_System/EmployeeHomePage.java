package Payroll_Management_System;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;

public class EmployeeHomePage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	String uid;
	String pwd;
	private JTable table_1;
	private JTextField fname;
	private JTextField mname;
	private JTextField lname;
	private JTextField dob;
	private JTextField gender;
	private JTextField phone;
	private JTextField relation;
	private JTextField depenid;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeHomePage frame = new EmployeeHomePage();
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
	public EmployeeHomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1097, 756);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 108, 1034, 118);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		try {
			PreparedStatement ps = Database.conn.prepareStatement("select empid,org_name,concat(f_name,\" \",m_name,\" \",l_name) as fullname,joindate,gender,jobtitle,dob,phone,area,city,dept_name from employee natural join department natural join organization where empid=?;");
			ps.setInt(1,LoginPage.empid);
			ResultSet rs = ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(23, 268, 1034, 110);
		panel.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		try {
			PreparedStatement ps2 = Database.conn.prepareStatement("select dependentid, concat(f_name,\" \",m_name,\" \",l_name) as name, dob,relation,gender,phone from dependents where empid=?;");
			ps2.setInt(1,LoginPage.empid);
			ResultSet rs2 = ps2.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(rs2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setForeground(Color.BLACK);
		btnLogout.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginPage login = new LoginPage();
				login.show();
			}
		});
		btnLogout.setBounds(933, 653, 124, 33);
		panel.add(btnLogout);
		
		JButton btnUpdate = new JButton("Add");
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PreparedStatement ps = Database.conn.prepareStatement("insert into dependents(empid,f_name,m_name,l_name,dob,relation,gender,phone) values(?,?,?,?,?,?,?,?);");
					ps.setInt(1, LoginPage.empid);
					ps.setString(2, fname.getText().toString());
					ps.setString(3, mname.getText().toString());
					ps.setString(4, lname.getText().toString());
					ps.setString(5, dob.getText().toString());
					ps.setString(6, relation.getText().toString());
					ps.setString(7, gender.getText().toString());
					ps.setString(8, phone.getText().toString());
					ps.executeUpdate();
					dispose();
					EmployeeHomePage emph=new EmployeeHomePage();
					emph.show();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(381, 546, 97, 25);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					PreparedStatement ps=Database.conn.prepareStatement("delete from dependents where dependentid=?");
					ps.setInt(1, Integer.valueOf(depenid.getText().toString()));
					ps.executeUpdate();
					dispose();
					EmployeeHomePage emph=new EmployeeHomePage();
					emph.show();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		});
		btnDelete.setBounds(308, 632, 97, 25);
		panel.add(btnDelete);
		
		JLabel lblDependants = new JLabel("Dependents");
		lblDependants.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblDependants.setHorizontalAlignment(SwingConstants.CENTER);
		lblDependants.setBounds(33, 239, 145, 25);
		panel.add(lblDependants);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(Color.BLACK);
		lblFirstName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblFirstName.setBounds(33, 449, 89, 16);
		panel.add(lblFirstName);
		
		JLabel lblMiddleName = new JLabel("Middle Name");
		lblMiddleName.setForeground(Color.BLACK);
		lblMiddleName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblMiddleName.setBounds(399, 449, 87, 16);
		panel.add(lblMiddleName);
		
		JLabel lblNewLabel = new JLabel("Last Name");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(768, 449, 72, 16);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DOB");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBounds(33, 498, 56, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.BLACK);
		lblGender.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblGender.setBounds(399, 498, 56, 16);
		panel.add(lblGender);
		
		fname = new JTextField();
		fname.setBounds(134, 446, 116, 22);
		panel.add(fname);
		fname.setColumns(10);
		
		mname = new JTextField();
		mname.setBounds(551, 445, 116, 22);
		panel.add(mname);
		mname.setColumns(10);
		
		lname = new JTextField();
		lname.setBounds(921, 445, 116, 22);
		panel.add(lname);
		lname.setColumns(10);
		
		dob = new JTextField();
		dob.setBounds(134, 495, 116, 22);
		panel.add(dob);
		dob.setColumns(10);
		
		gender = new JTextField();
		gender.setBounds(551, 494, 116, 22);
		panel.add(gender);
		gender.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setForeground(Color.BLACK);
		lblPhone.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblPhone.setBounds(768, 498, 56, 16);
		panel.add(lblPhone);
		
		JLabel lblRelation = new JLabel("Relation");
		lblRelation.setForeground(Color.BLACK);
		lblRelation.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblRelation.setBounds(33, 552, 56, 16);
		panel.add(lblRelation);
		
		phone = new JTextField();
		phone.setBounds(921, 494, 116, 22);
		panel.add(phone);
		phone.setColumns(10);
		
		relation = new JTextField();
		relation.setBounds(134, 549, 116, 22);
		panel.add(relation);
		relation.setColumns(10);
		
		JLabel lblAddDependant = new JLabel("Add Dependent");
		lblAddDependant.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAddDependant.setForeground(Color.BLACK);
		lblAddDependant.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddDependant.setBounds(33, 391, 184, 25);
		panel.add(lblAddDependant);
		
		JLabel lblDependentId = new JLabel("Dependent ID");
		lblDependentId.setForeground(Color.BLACK);
		lblDependentId.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblDependentId.setBounds(23, 637, 99, 16);
		panel.add(lblDependentId);
		
		depenid = new JTextField();
		depenid.setBounds(134, 634, 116, 22);
		panel.add(depenid);
		depenid.setColumns(10);
		
		JLabel lblDelete = new JLabel("Delete");
		lblDelete.setForeground(Color.BLACK);
		lblDelete.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblDelete.setHorizontalAlignment(SwingConstants.CENTER);
		lblDelete.setBounds(64, 598, 109, 25);
		panel.add(lblDelete);
		
		/*JButton btnViewFinancials = new JButton("View Financials");
		btnViewFinancials.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnViewFinancials.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FinancialsPage fp = new FinancialsPage();
				fp.show();
			}
		});
		btnViewFinancials.setBounds(566, 546, 201, 25);
		panel.add(btnViewFinancials);*/
		
		JLabel label_1 = new JLabel((String) null);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		label_1.setBounds(12, 13, 1064, 47);
		panel.add(label_1);
		label_1.setText(LoginPage.orgname.toUpperCase());
		
		JLabel lblMyDetails = new JLabel("My Details");
		lblMyDetails.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblMyDetails.setForeground(Color.BLACK);
		lblMyDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyDetails.setBounds(22, 73, 150, 25);
		panel.add(lblMyDetails);
		
		JButton btnViewFinancials_1 = new JButton("View Financials");
		btnViewFinancials_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				FinancialsPage fpg = new FinancialsPage();
				fpg.show();
			}
		});
		btnViewFinancials_1.setForeground(Color.BLACK);
		btnViewFinancials_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnViewFinancials_1.setBounds(566, 599, 201, 24);
		panel.add(btnViewFinancials_1);
	}
}
