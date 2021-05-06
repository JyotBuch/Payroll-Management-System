package Payroll_Management_System;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;

public class AdminAddEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField middle;
	private JTextField firstname;
	private JTextField lastname;
	private JTextField area;
	private JTextField city;
	private JTextField phone;
	private JTextField date;
	private JTextField gender;
	private JTextField paygradeid;
	private JTextField deptid;
	//private JTextField orgid;
	private JTextField joindate;
	private JTextField jobtitle;
	private JTextField accno;
	private JTextField bankcode;
	public Integer orgid;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminAddEmployee frame = new AdminAddEmployee();
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
	public AdminAddEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("Payroll Management System");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(12, 0, 645, 16);
		contentPane.add(label);

		JLabel lblAdminAddEmployee = new JLabel("Admin Add Employee");
		lblAdminAddEmployee.setBounds(268, 29, 123, 16);
		contentPane.add(lblAdminAddEmployee);

		middle = new JTextField();
		middle.setBounds(236, 94, 116, 22);
		contentPane.add(middle);
		middle.setColumns(10);

		JButton btnCreateUser = new JButton("Add Employee");
		btnCreateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {

					PreparedStatement ps = Database.conn.prepareCall("{call add_employee(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					ps.setString(1, firstname.getText().toString());
					ps.setString(2, middle.getText().toString() );
					ps.setString(3, lastname.getText().toString());
					ps.setString(4, area.getText().toString());
					ps.setString(5, city.getText().toString());
					ps.setString(6, phone.getText().toString());
					ps.setString(7, date.getText().toString());
					ps.setString(8, joindate.getText().toString());
					ps.setString(9, gender.getText().toString());
					ps.setInt(10, Integer.valueOf(paygradeid.getText().toString()));
					ps.setInt(11, Integer.valueOf(deptid.getText().toString()));
					ps.setString(12, jobtitle.getText().toString());
					ps.setString(13, accno.getText().toString());
					ps.setString(14,bankcode.getText().toString());
					ps.setInt(15, LoginPage.orgid);


					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						String userid = rs.getString(1);
						int position = userid.lastIndexOf("$");
						String empid = userid.substring(0, position);
						String password = "pass"+empid;
						JOptionPane.showMessageDialog(null, "Login Id: "+userid+"\nPassword: "+password);
						dispose();
						AdministratorHome admin = new AdministratorHome();
						admin.show();
					}
				}
				catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnCreateUser.setBounds(484, 411, 151, 25);
		contentPane.add(btnCreateUser);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(32, 68, 93, 16);
		contentPane.add(lblFirstName);

		JLabel lblMiddleName = new JLabel("Middle Name");
		lblMiddleName.setBounds(32, 97, 93, 16);
		contentPane.add(lblMiddleName);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(32, 126, 93, 16);
		contentPane.add(lblLastName);

		JLabel lblDateOfBirthday = new JLabel("Date of birthday(YYYY-MM-DD)");
		lblDateOfBirthday.setBounds(32, 234, 181, 16);
		contentPane.add(lblDateOfBirthday);

		JLabel lblArea = new JLabel("Area");
		lblArea.setBounds(32, 155, 56, 16);
		contentPane.add(lblArea);

		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(32, 180, 93, 16);
		contentPane.add(lblCity);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(32, 205, 93, 16);
		contentPane.add(lblPhone);

		JLabel lblJoiningDate = new JLabel("Joining Date(YYYY-MM-DD)");
		lblJoiningDate.setBounds(32, 352, 161, 16);
		contentPane.add(lblJoiningDate);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(32, 263, 75, 16);
		contentPane.add(lblGender);

		JLabel lblPaygradeId = new JLabel("Paygrade ID");
		lblPaygradeId.setBounds(32, 294, 75, 16);
		contentPane.add(lblPaygradeId);

		JLabel lblDepartmentId = new JLabel("Department ID");
		lblDepartmentId.setBounds(32, 323, 123, 16);
		contentPane.add(lblDepartmentId);

		JLabel lblJobTitle = new JLabel("Job Title");
		lblJobTitle.setBounds(32, 381, 75, 16);
		contentPane.add(lblJobTitle);

		firstname = new JTextField();
		firstname.setBounds(236, 65, 116, 22);
		contentPane.add(firstname);
		firstname.setColumns(10);

		lastname = new JTextField();
		lastname.setBounds(236, 123, 116, 22);
		contentPane.add(lastname);
		lastname.setColumns(10);

		area = new JTextField();
		area.setColumns(10);
		area.setBounds(236, 152, 116, 22);
		contentPane.add(area);

		city = new JTextField();
		city.setColumns(10);
		city.setBounds(236, 177, 116, 22);
		contentPane.add(city);

		phone = new JTextField();
		phone.setBounds(236, 202, 116, 22);
		contentPane.add(phone);
		phone.setColumns(10);

		date = new JTextField();
		date.setBounds(236, 231, 116, 22);
		contentPane.add(date);
		date.setColumns(10);

		gender = new JTextField();
		gender.setBounds(236, 260, 116, 22);
		contentPane.add(gender);
		gender.setColumns(10);

		paygradeid = new JTextField();
		paygradeid.setColumns(10);
		paygradeid.setBounds(236, 291, 116, 22);
		contentPane.add(paygradeid);

		deptid = new JTextField();
		deptid.setColumns(10);
		deptid.setBounds(236, 320, 116, 22);
		contentPane.add(deptid);

		/*orgid = new JTextField();
		orgid.setColumns(10);
		orgid.setBounds(236, 349, 116, 22);
		contentPane.add(orgid);*/

		joindate = new JTextField();
		joindate.setColumns(10);
		joindate.setBounds(236, 349, 116, 22);
		contentPane.add(joindate);

		jobtitle = new JTextField();
		jobtitle.setColumns(10);
		jobtitle.setBounds(236, 381, 116, 22);
		contentPane.add(jobtitle);

		JLabel lblAccountId = new JLabel("Account Number");
		lblAccountId.setBounds(399, 68, 116, 16);
		contentPane.add(lblAccountId);

		JLabel lblAnkCode = new JLabel("Bank Code");
		lblAnkCode.setBounds(397, 97, 85, 16);
		contentPane.add(lblAnkCode);

		accno = new JTextField();
		accno.setBounds(527, 65, 116, 22);
		contentPane.add(accno);
		accno.setColumns(10);

		bankcode = new JTextField();
		bankcode.setBounds(527, 94, 116, 22);
		contentPane.add(bankcode);
		bankcode.setColumns(10);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdministratorHome adminhome = new AdministratorHome();
				adminhome.show();
			}
		});
		btnBack.setBounds(10, 13, 97, 25);
		contentPane.add(btnBack);
	}
}
