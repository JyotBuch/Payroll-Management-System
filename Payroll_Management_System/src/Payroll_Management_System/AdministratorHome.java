package Payroll_Management_System;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

public class AdministratorHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministratorHome frame = new AdministratorHome();
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
	public AdministratorHome() {
		/*setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1087, 745);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);*/
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1097, 756);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add Employee");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AdminAddEmployee addemp = new AdminAddEmployee();
				addemp.show();
			}
		});
		btnNewButton.setBounds(105, 214, 176, 34);
		contentPane.add(btnNewButton);
		
		JButton btnDeleteViewExemployees = new JButton("View Ex-employees");
		btnDeleteViewExemployees.setForeground(Color.BLACK);
		btnDeleteViewExemployees.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnDeleteViewExemployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ViewExEmployees vex=new ViewExEmployees();
				vex.show();
			}
		});
		btnDeleteViewExemployees.setBounds(637, 365, 203, 34);
		contentPane.add(btnDeleteViewExemployees);
		
		JButton btnEditPaygrade = new JButton("Paygrade");
		btnEditPaygrade.setForeground(Color.BLACK);
		btnEditPaygrade.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnEditPaygrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PaygradePage pgpg=new PaygradePage();
				pgpg.show();
			}
		});
		btnEditPaygrade.setBounds(439, 214, 176, 34);
		contentPane.add(btnEditPaygrade);
		
		JButton btnPaySalary = new JButton("Pay Salary");
		btnPaySalary.setForeground(Color.BLACK);
		btnPaySalary.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnPaySalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PaySalary ps = new PaySalary();
				ps.show();
			}
		});
		btnPaySalary.setBounds(439, 501, 176, 34);
		contentPane.add(btnPaySalary);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginPage login = new LoginPage();
				login.show();
			}
		});
		btnLogout.setBounds(900, 651, 157, 34);
		contentPane.add(btnLogout);
		
		JButton btnCreateeditDepartment = new JButton("Department");
		btnCreateeditDepartment.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnCreateeditDepartment.setForeground(Color.BLACK);
		btnCreateeditDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				DepartmentsPage dept = new DepartmentsPage();
				dept.show();
			}
		});
		btnCreateeditDepartment.setBounds(784, 214, 174, 34);
		contentPane.add(btnCreateeditDepartment);
		
		JButton btnViewEmployees = new JButton("View Employees");
		btnViewEmployees.setForeground(Color.BLACK);
		btnViewEmployees.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnViewEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminViewEmployee newview = new AdminViewEmployee();
				newview.show();
			}
		});
		btnViewEmployees.setBounds(286, 365, 176, 34);
		contentPane.add(btnViewEmployees);
		
		JLabel label = new JLabel("Payroll Management System");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Times New Roman", Font.BOLD, 25));
		label.setBackground(new Color(255, 51, 204));
		label.setBounds(0, 13, 1074, 47);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setForeground(Color.BLACK);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		label_1.setBounds(10, 73, 1064, 47);
		contentPane.add(label_1);
		
		label_1.setText(LoginPage.orgname.toUpperCase());
		
		JLabel lblTotalSalaryPaid = new JLabel("Total amount of Salaries Paid");
		lblTotalSalaryPaid.setForeground(Color.BLACK);
		lblTotalSalaryPaid.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTotalSalaryPaid.setBounds(42, 616, 221, 19);
		contentPane.add(lblTotalSalaryPaid);
		
		JLabel label_2 = new JLabel("");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_2.setBounds(257, 617, 149, 16);
		contentPane.add(label_2);
		
		try {
			PreparedStatement ps = Database.conn.prepareStatement("select total_salary_paid(?)");
			ps.setInt(1,LoginPage.orgid);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
				label_2.setText(rs.getString(1));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
