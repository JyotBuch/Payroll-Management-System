package Payroll_Management_System;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class FinancialsPage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTextField accno;
	private JTextField bankcode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinancialsPage frame = new FinancialsPage();
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
	public FinancialsPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1097, 756);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFinancials = new JLabel("Financials");
		lblFinancials.setForeground(Color.BLACK);
		lblFinancials.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblFinancials.setBounds(12, 71, 172, 25);
		contentPane.add(lblFinancials);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 109, 968, 134);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		try {
			PreparedStatement ps = Database.conn.prepareStatement("select transactionid,date,paygrade_name,base_salary,tax_amount,benefits,leaves,leave_reduction_amount,bonus,net_salary,acc_number,bank_code from salary_invoices natural join paygrade  join account on (account.acc_id=salary_invoices.acc_id) where salary_invoices.empid=? union all select transactionid,date,paygrade_name,base_salary,tax_amount,benefits,leaves,leave_reduction_amount,bonus,net_salary,acc_number,bank_code from updated_paygrade_salary_invoices natural join updated_and_deleted_paygrade natural join account where updated_paygrade_salary_invoices.empid=?;");
			ps.setInt(1, LoginPage.empid);
			ps.setInt(2, LoginPage.empid);
			ResultSet rs = ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 297, 968, 66);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(12, 425, 968, 66);
		contentPane.add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		
		JLabel label = new JLabel((String) null);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Times New Roman", Font.BOLD, 25));
		label.setBounds(0, 0, 1064, 47);
		contentPane.add(label);
		label.setText(LoginPage.orgname.toUpperCase());
		
		try {
			PreparedStatement pspaygrade = Database.conn.prepareStatement("select paygrade_name,base_salary,benefits,tax_percent,leaves_permitted,leave_reduction_percent from paygrade natural join employee where empid=?;");
			pspaygrade.setInt(1, LoginPage.empid);
			ResultSet pg=pspaygrade.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(pg));			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		try {
			PreparedStatement psgetversion = Database.conn.prepareStatement("select acc_id as account_id,acc_number as account_number,bank_code from latest_accounts_view where empid=?;");
			psgetversion.setInt(1, LoginPage.empid);
			ResultSet gv=psgetversion.executeQuery();
			table_2.setModel(DbUtils.resultSetToTableModel(gv));			
			
			JButton btnNewButton = new JButton("Change Account Details");
			btnNewButton.setForeground(Color.BLACK);
			btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						PreparedStatement ps2= Database.conn.prepareStatement("insert into account(empid,acc_number,bank_code,version) values (?,?,?,get_latest_version(empid)+1)");
						ps2.setInt(1, LoginPage.empid);
						ps2.setString(2, accno.getText().toString());
						ps2.setString(3, bankcode.getText().toString());
						ps2.executeUpdate();
						dispose();
						FinancialsPage upf = new FinancialsPage();
						upf.show();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnNewButton.setBounds(13, 658, 223, 38);
			contentPane.add(btnNewButton);
			
			JLabel lblEditDetails = new JLabel("Edit Details");
			lblEditDetails.setForeground(Color.BLACK);
			lblEditDetails.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblEditDetails.setBounds(12, 526, 145, 25);
			contentPane.add(lblEditDetails);
			
			JLabel lblAccountNumber = new JLabel("Account Number");
			lblAccountNumber.setForeground(Color.BLACK);
			lblAccountNumber.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
			lblAccountNumber.setBounds(22, 590, 114, 16);
			contentPane.add(lblAccountNumber);
			
			JLabel lblBankCode = new JLabel("Bank Code");
			lblBankCode.setForeground(Color.BLACK);
			lblBankCode.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
			lblBankCode.setBounds(26, 629, 97, 16);
			contentPane.add(lblBankCode);
			
			accno = new JTextField();
			accno.setBounds(135, 587, 116, 22);
			contentPane.add(accno);
			accno.setColumns(10);
			
			bankcode = new JTextField();
			bankcode.setBounds(135, 626, 116, 22);
			contentPane.add(bankcode);
			bankcode.setColumns(10);
			
			JLabel lblPaygradeDetails = new JLabel("Paygrade Details");
			lblPaygradeDetails.setForeground(Color.BLACK);
			lblPaygradeDetails.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblPaygradeDetails.setBounds(12, 268, 145, 16);
			contentPane.add(lblPaygradeDetails);
			
			JLabel lblAccountDetails = new JLabel("Account Details");
			lblAccountDetails.setForeground(Color.BLACK);
			lblAccountDetails.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblAccountDetails.setBounds(12, 387, 172, 25);
			contentPane.add(lblAccountDetails);
			
			JButton btnNewButton_1 = new JButton("Back");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					EmployeeHomePage emp = new EmployeeHomePage();
					emp.show();
				}
			});
			btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
			btnNewButton_1.setForeground(Color.BLACK);
			btnNewButton_1.setBounds(931, 665, 136, 31);
			contentPane.add(btnNewButton_1);
			
			/*JLabel lblTotalSalaryRecieved = new JLabel("Total Salary Recieved");
			lblTotalSalaryRecieved.setForeground(Color.BLACK);
			lblTotalSalaryRecieved.setFont(new Font("Times New Roman", Font.BOLD, 15));
			lblTotalSalaryRecieved.setBounds(511, 531, 187, 31);
			contentPane.add(lblTotalSalaryRecieved);
			
			JLabel label_1 = new JLabel("");
			label_1.setForeground(Color.BLACK);
			label_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
			label_1.setBounds(513, 590, 145, 16);
			contentPane.add(label_1);*/
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
	}
}
