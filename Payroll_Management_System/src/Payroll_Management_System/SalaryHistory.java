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
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class SalaryHistory extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel label;
	private JLabel lblTotalSalaryOf;
	private JLabel label_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalaryHistory frame = new SalaryHistory();
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
	public SalaryHistory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1097, 756);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 110, 1043, 363);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		label = new JLabel((String) null);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Times New Roman", Font.BOLD, 25));
		label.setBounds(12, 13, 1064, 47);
		contentPane.add(label);
		
		label.setText(LoginPage.orgname);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminViewEmployee ev = new AdminViewEmployee();
				ev.show();
			}
		});
		btnBack.setBounds(931, 675, 124, 34);
		contentPane.add(btnBack);
		
		try {
			PreparedStatement ps = Database.conn.prepareStatement("select transactionid,date,paygrade_name,base_salary,tax_amount,benefits,leaves,leave_reduction_amount,bonus,net_salary,acc_number,bank_code from salary_invoices natural join paygrade  join account on (account.acc_id=salary_invoices.acc_id) where salary_invoices.empid=? union all select transactionid,date,paygrade_name,base_salary,tax_amount,benefits,leaves,leave_reduction_amount,bonus,net_salary,acc_number,bank_code from updated_paygrade_salary_invoices natural join updated_and_deleted_paygrade natural join account where updated_paygrade_salary_invoices.empid=?;");
			ps.setInt(1, AdminViewEmployee.enteredempid);
			ps.setInt(2, AdminViewEmployee.enteredempid);
			ResultSet rs = ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lblTotalSalaryOf = new JLabel("Total Salary of Employee");
		lblTotalSalaryOf.setForeground(Color.BLACK);
		lblTotalSalaryOf.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTotalSalaryOf.setBounds(12, 562, 169, 25);
		contentPane.add(lblTotalSalaryOf);
		
		label_1 = new JLabel("");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_1.setBounds(205, 562, 108, 21);
		contentPane.add(label_1);
		
		try {
			PreparedStatement ps4 = Database.conn.prepareStatement("select total_salary_earned(?)");
			ps4.setInt(1, AdminViewEmployee.enteredempid);
			ResultSet rs4=ps4.executeQuery();
			while(rs4.next())
				label_1.setText(rs4.getString(1));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
