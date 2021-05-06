package Payroll_Management_System;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class AdminEditEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField fname;
	private JTextField mname;
	private JTextField lname;
	private JTextField area;
	private JTextField city;
	private JTextField phone;
	private JTextField dob;
	private JTextField gender;
	private JTextField pgid;
	private JTextField deptid;
	private JTextField jtitle;
	public String querystart="update employee set ";
	public String querymid="";
	public String queryend="where empid=?;";
	public int count=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminEditEmployee frame = new AdminEditEmployee();
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
	public AdminEditEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1097, 756);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCheckBox chckbxFirstName = new JCheckBox("First Name");
		chckbxFirstName.setBackground(Color.GRAY);
		chckbxFirstName.setForeground(Color.BLACK);
		chckbxFirstName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxFirstName.setBounds(22, 86, 113, 25);
		contentPane.add(chckbxFirstName);
		
		JCheckBox chckbxMiddleName = new JCheckBox("Middle name");
		chckbxMiddleName.setBackground(Color.GRAY);
		chckbxMiddleName.setForeground(Color.BLACK);
		chckbxMiddleName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxMiddleName.setBounds(397, 128, 121, 25);
		contentPane.add(chckbxMiddleName);
		
		JCheckBox chckbxLastName = new JCheckBox("Last name");
		chckbxLastName.setBackground(Color.GRAY);
		chckbxLastName.setForeground(Color.BLACK);
		chckbxLastName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxLastName.setBounds(753, 86, 113, 25);
		contentPane.add(chckbxLastName);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Area");
		chckbxNewCheckBox.setBackground(Color.GRAY);
		chckbxNewCheckBox.setForeground(Color.BLACK);
		chckbxNewCheckBox.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxNewCheckBox.setBounds(22, 176, 113, 25);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxCity = new JCheckBox("City");
		chckbxCity.setBackground(Color.GRAY);
		chckbxCity.setForeground(Color.BLACK);
		chckbxCity.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxCity.setBounds(397, 219, 113, 25);
		contentPane.add(chckbxCity);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Phone");
		chckbxNewCheckBox_1.setBackground(Color.GRAY);
		chckbxNewCheckBox_1.setForeground(Color.BLACK);
		chckbxNewCheckBox_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxNewCheckBox_1.setBounds(753, 176, 113, 25);
		contentPane.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxDob = new JCheckBox("DOB");
		chckbxDob.setBackground(Color.GRAY);
		chckbxDob.setForeground(Color.BLACK);
		chckbxDob.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxDob.setBounds(22, 267, 113, 25);
		contentPane.add(chckbxDob);
		
		JCheckBox chckbxGender = new JCheckBox("Gender");
		chckbxGender.setBackground(Color.GRAY);
		chckbxGender.setForeground(Color.BLACK);
		chckbxGender.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxGender.setBounds(397, 309, 113, 25);
		contentPane.add(chckbxGender);
		
		JCheckBox chckbxPaygradeId = new JCheckBox("Paygrade ID");
		chckbxPaygradeId.setBackground(Color.GRAY);
		chckbxPaygradeId.setForeground(Color.BLACK);
		chckbxPaygradeId.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxPaygradeId.setBounds(753, 267, 113, 25);
		contentPane.add(chckbxPaygradeId);
		
		JCheckBox chckbxDepartmentId = new JCheckBox("Department ID");
		chckbxDepartmentId.setBackground(Color.GRAY);
		chckbxDepartmentId.setForeground(Color.BLACK);
		chckbxDepartmentId.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxDepartmentId.setBounds(22, 357, 138, 25);
		contentPane.add(chckbxDepartmentId);
		
		JCheckBox chckbxJobTitle = new JCheckBox("Job Title");
		chckbxJobTitle.setBackground(Color.GRAY);
		chckbxJobTitle.setForeground(Color.BLACK);
		chckbxJobTitle.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxJobTitle.setBounds(753, 357, 113, 25);
		contentPane.add(chckbxJobTitle);
		
		fname = new JTextField();
		fname.setBounds(168, 87, 116, 22);
		contentPane.add(fname);
		fname.setColumns(10);
		
		mname = new JTextField();
		mname.setBounds(541, 129, 116, 22);
		contentPane.add(mname);
		mname.setColumns(10);
		
		lname = new JTextField();
		lname.setBounds(899, 87, 116, 22);
		contentPane.add(lname);
		lname.setColumns(10);
		
		area = new JTextField();
		area.setBounds(168, 177, 116, 22);
		contentPane.add(area);
		area.setColumns(10);
		
		city = new JTextField();
		city.setBounds(541, 220, 116, 22);
		contentPane.add(city);
		city.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(899, 177, 116, 22);
		contentPane.add(phone);
		phone.setColumns(10);
		
		dob = new JTextField();
		dob.setBounds(168, 268, 116, 22);
		contentPane.add(dob);
		dob.setColumns(10);
		
		gender = new JTextField();
		gender.setBounds(546, 310, 116, 22);
		contentPane.add(gender);
		gender.setColumns(10);
		
		pgid = new JTextField();
		pgid.setBounds(899, 268, 116, 22);
		contentPane.add(pgid);
		pgid.setColumns(10);
		
		deptid = new JTextField();
		deptid.setBounds(168, 358, 116, 22);
		contentPane.add(deptid);
		deptid.setColumns(10);
		
		jtitle = new JTextField();
		jtitle.setBounds(899, 358, 116, 22);
		contentPane.add(jtitle);
		jtitle.setColumns(10);
		
		JButton btnEditEmployee = new JButton("Edit Employee");
		btnEditEmployee.setForeground(Color.BLACK);
		btnEditEmployee.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnEditEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 try {
					if (chckbxFirstName.isSelected()) {
						String querynew1 = "f_name=" + "'" + fname.getText().toString() + "' ";
						if (count == 0)
							querymid = querynew1;
						else
							querymid += "," + querynew1;
						count++;
					}
					if (chckbxMiddleName.isSelected()) {
						String querynew2 = "m_name=" + "'" + mname.getText().toString() + "' ";
						if (count == 0)
							querymid = querynew2;
						else
							querymid += "," + querynew2;
						count++;
					}
					if (chckbxLastName.isSelected()) {
						String querynew3 = "l_name=" + "'" + lname.getText().toString() + "' ";
						if (count == 0)
							querymid = querynew3;
						else
							querymid += "," + querynew3;
						count++;
					}
					if (chckbxNewCheckBox.isSelected()) {
						String querynew4 = "area=" + "'" + area.getText().toString() + "'" + " ";
						if (count == 0)
							querymid = querynew4;
						else
							querymid += " , " + querynew4;
						count++;
					}
					if (chckbxJobTitle.isSelected()) {
						String querynew6 = "jobtitle=" + "'" + jtitle.getText().toString() + "'" + " ";
						if (count == 0)
							querymid = querynew6;
						else
							querymid += " , " + querynew6;
						count++;
					}
					if (chckbxPaygradeId.isSelected()) {
						String querynew11 = "paygradeid=" + pgid.getText().toString() + " ";
						if (count == 0)
							querymid = querynew11;
						else
							querymid += " , " + querynew11;
						count++;
					}
					if (chckbxCity.isSelected()) {
						String querynew5 = "city= '" + city.getText().toString() + "' ";
						if (count == 0)
							querymid = querynew5;
						else
							querymid += " , " + querynew5;
						count++;
					}
					if (chckbxNewCheckBox_1.isSelected()) {
						String querynew7 = "phone='" + phone.getText().toString() + "' ";
						if (count == 0)
							querymid = querynew7;
						else
							querymid += " , " + querynew7;
						count++;
					}
					if (chckbxDob.isSelected()) {
						String querynew8 = "dob='" + dob.getText().toString() + "' ";
						if (count == 0)
							querymid = querynew8;
						else
							querymid += " , " + querynew8;
						count++;
					}
					if (chckbxDepartmentId.isSelected()) {
						String querynew9 = "deptid=" + deptid.getText().toString() + " ";
						if (count == 0)
							querymid = querynew9;
						else
							querymid += " , " + querynew9;
						count++;
					}
					if (chckbxGender.isSelected()) {
						String querynew10 = "gender='" + gender.getText().toString() + "' ";
						if (count == 0)
							querymid = querynew10;
						else
							querymid += " , " + querynew10;
						count++;
					}
					PreparedStatement ps = Database.conn.prepareStatement(querystart + querymid + queryend);
					count = 0;
					//System.out.println(ps);
					ps.setInt(1, AdminViewEmployee.enteredempid);
					//System.out.println(ps);
					//ResultSet rs =
					ps.executeUpdate();
					//table.setModel(DbUtils.resultSetToTableModel(rs));
					
					// System.out.println(ps);
					dispose();
					AdminViewEmployee pg = new AdminViewEmployee();
					pg.show();
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnEditEmployee.setBounds(455, 492, 175, 38);
		contentPane.add(btnEditEmployee);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminViewEmployee a = new AdminViewEmployee();
				a.show();
			}
		});
		btnBack.setBounds(933, 671, 97, 25);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel((String) null);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Times New Roman", Font.BOLD, 25));
		label.setBounds(22, 13, 1064, 47);
		contentPane.add(label);
		
		label.setText(LoginPage.orgname);
	}
}
