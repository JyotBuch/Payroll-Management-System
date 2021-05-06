package Payroll_Management_System;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class ViewExEmployees extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField id;
	private JTable table_1;
	private JTable table_2;
	private JButton btnOk;
	private JButton btnBack;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblExEmployees;
	private JLabel lblTotalSalary;
	private JLabel label_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewExEmployees frame = new ViewExEmployees();
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
	public ViewExEmployees() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1097, 756);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 67, 1043, 218);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		id = new JTextField();
		id.setBounds(600, 293, 137, 31);
		contentPane.add(id);
		id.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 359, 1043, 127);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(21, 571, 1055, 92);
		contentPane.add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		
		JLabel lblEnterEmployeeId = new JLabel("Enter Employee ID");
		lblEnterEmployeeId.setForeground(Color.BLACK);
		lblEnterEmployeeId.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblEnterEmployeeId.setBounds(451, 293, 137, 31);
		contentPane.add(lblEnterEmployeeId);
		
		JLabel label = new JLabel((String) null);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Times New Roman", Font.BOLD, 25));
		label.setBounds(12, 13, 1064, 47);
		contentPane.add(label);
		
		label.setText(LoginPage.orgname);
		
		try {
			PreparedStatement ps = Database.conn.prepareStatement("select empid,f_name,m_name,l_name,area,city,phone,DOB,joindate,gender,deptid,orgid,jobtitle,leave_date from employee_archives where orgid=?;");
			ps.setInt(1,LoginPage.orgid);
			ResultSet rs = ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			btnOk = new JButton("OK");
			btnOk.setFont(new Font("Times New Roman", Font.BOLD, 15));
			btnOk.setForeground(Color.BLACK);
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int empid=  Integer.valueOf(id.getText().toString());
					PreparedStatement ps2,ps3;
					try {
						ps2 = Database.conn.prepareStatement("select transactionid,date,paygrade_name,base_salary,tax_amount,benefits,leaves,leave_reduction_amount,bonus,net_salary,acc_number,bank_code from salary_archives natural join paygrade natural join account_archives where salary_archives.empid= ? union all select transactionid,date,paygrade_name,base_salary,tax_amount,benefits,leaves,leave_reduction_amount,bonus,net_salary,acc_number,bank_code from updated_paygrade_salary_archives natural join updated_and_deleted_paygrade natural join account_archives where updated_paygrade_salary_archives.empid=?;");
						ps2.setInt(1,Integer.valueOf(id.getText().toString()));
						ps2.setInt(2,Integer.valueOf(id.getText().toString()));
						//ps2 = Database.conn.prepareStatement("");
						ps3 = Database.conn.prepareStatement("Select acc_id,acc_number,bank_code from account_archives where empid=?");
						ps3.setInt(1, empid);
						ResultSet rs2 = ps2.executeQuery();
						ResultSet rs3 = ps3.executeQuery();
						table_1.setModel(DbUtils.resultSetToTableModel(rs2));
						table_2.setModel(DbUtils.resultSetToTableModel(rs3));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					try {
						PreparedStatement ps4 = Database.conn.prepareStatement("select ex_total_salary_earned(?)");
						ps4.setInt(1,Integer.valueOf(id.getText().toString()));
						ResultSet rs4=ps4.executeQuery();
						while(rs4.next())
							label_1.setText(rs4.getString(1));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
			btnOk.setBounds(762, 293, 137, 31);
			contentPane.add(btnOk);
			
			btnBack = new JButton("Back");
			btnBack.setForeground(Color.BLACK);
			btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					AdministratorHome ahp = new AdministratorHome();
					ahp.show();
				}
			});
			btnBack.setBounds(941, 665, 126, 31);
			contentPane.add(btnBack);
			
			lblNewLabel = new JLabel("Salary Info");
			lblNewLabel.setForeground(Color.BLACK);
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
			lblNewLabel.setBounds(12, 324, 119, 24);
			contentPane.add(lblNewLabel);
			
			lblNewLabel_1 = new JLabel("Account Details");
			lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
			lblNewLabel_1.setForeground(Color.BLACK);
			lblNewLabel_1.setBounds(21, 534, 149, 24);
			contentPane.add(lblNewLabel_1);
			
			lblExEmployees = new JLabel("Ex Employees");
			lblExEmployees.setFont(new Font("Times New Roman", Font.BOLD, 15));
			lblExEmployees.setBackground(Color.WHITE);
			lblExEmployees.setBounds(12, 30, 119, 24);
			contentPane.add(lblExEmployees);
			
			lblTotalSalary = new JLabel("Total Salary");
			lblTotalSalary.setForeground(Color.BLACK);
			lblTotalSalary.setFont(new Font("Times New Roman", Font.BOLD, 15));
			lblTotalSalary.setBounds(356, 505, 92, 24);
			contentPane.add(lblTotalSalary);
			
			label_1 = new JLabel("");
			label_1.setForeground(Color.BLACK);
			label_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
			label_1.setBounds(480, 509, 108, 20);
			contentPane.add(label_1);
			
			
			

		
	}
}
