package Payroll_Management_System;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InvoicePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InvoicePage frame = new InvoicePage();
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
	public InvoicePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 727);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setForeground(Color.BLACK);
		lblEmployeeId.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEmployeeId.setBounds(12, 109, 101, 26);
		contentPane.add(lblEmployeeId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblName.setBounds(12, 157, 101, 26);
		contentPane.add(lblName);
		
		JLabel lblNewLabel = new JLabel("Date");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(12, 216, 101, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblLeaves = new JLabel("Leaves");
		lblLeaves.setForeground(Color.BLACK);
		lblLeaves.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblLeaves.setBounds(12, 275, 101, 26);
		contentPane.add(lblLeaves);
		
		JLabel lblLeavesReductionAmount = new JLabel("Leaves Reduction Amount");
		lblLeavesReductionAmount.setForeground(Color.BLACK);
		lblLeavesReductionAmount.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblLeavesReductionAmount.setBounds(12, 327, 182, 26);
		contentPane.add(lblLeavesReductionAmount);
		
		JLabel lblBonus = new JLabel("Bonus");
		lblBonus.setForeground(Color.BLACK);
		lblBonus.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblBonus.setBounds(12, 377, 101, 26);
		contentPane.add(lblBonus);
		
		JLabel lblTaxAmount = new JLabel("Tax Amount");
		lblTaxAmount.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTaxAmount.setForeground(Color.BLACK);
		lblTaxAmount.setBounds(12, 427, 118, 26);
		contentPane.add(lblTaxAmount);
		
		JLabel lblNetSalary = new JLabel("Net Salary");
		lblNetSalary.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNetSalary.setForeground(Color.BLACK);
		lblNetSalary.setBounds(12, 479, 101, 26);
		contentPane.add(lblNetSalary);
		
		JLabel lblAccountNumber = new JLabel("Account Number");
		lblAccountNumber.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAccountNumber.setForeground(Color.BLACK);
		lblAccountNumber.setBounds(12, 530, 118, 26);
		contentPane.add(lblAccountNumber);
		
		JLabel lblBankCode = new JLabel("Bank Code");
		lblBankCode.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblBankCode.setBounds(12, 583, 101, 26);
		contentPane.add(lblBankCode);
		
		JLabel id = new JLabel("");
		id.setForeground(Color.BLACK);
		id.setFont(new Font("Times New Roman", Font.BOLD, 15));
		id.setBounds(200, 109, 130, 26);
		contentPane.add(id);
		
		JLabel name = new JLabel("");
		name.setForeground(Color.BLACK);
		name.setFont(new Font("Times New Roman", Font.BOLD, 15));
		name.setBounds(200, 157, 271, 26);
		contentPane.add(name);
		
		JLabel date = new JLabel("");
		date.setForeground(Color.BLACK);
		date.setFont(new Font("Times New Roman", Font.BOLD, 15));
		date.setBounds(200, 216, 139, 26);
		contentPane.add(date);
		
		JLabel leaves = new JLabel("");
		leaves.setForeground(Color.BLACK);
		leaves.setFont(new Font("Times New Roman", Font.BOLD, 15));
		leaves.setBounds(200, 275, 152, 26);
		contentPane.add(leaves);
		
		JLabel leaveredamt = new JLabel("");
		leaveredamt.setForeground(Color.BLACK);
		leaveredamt.setFont(new Font("Times New Roman", Font.BOLD, 15));
		leaveredamt.setBounds(200, 327, 154, 26);
		contentPane.add(leaveredamt);
		
		JLabel bonus = new JLabel("");
		bonus.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bonus.setForeground(Color.BLACK);
		bonus.setBounds(200, 377, 144, 26);
		contentPane.add(bonus);
		
		JLabel taxamt = new JLabel("");
		taxamt.setForeground(Color.BLACK);
		taxamt.setFont(new Font("Times New Roman", Font.BOLD, 15));
		taxamt.setBounds(200, 427, 145, 26);
		contentPane.add(taxamt);
		
		JLabel netsal = new JLabel("");
		netsal.setForeground(Color.BLACK);
		netsal.setFont(new Font("Times New Roman", Font.BOLD, 15));
		netsal.setBounds(200, 479, 139, 26);
		contentPane.add(netsal);
		
		JLabel accno = new JLabel("");
		accno.setForeground(Color.BLACK);
		accno.setFont(new Font("Times New Roman", Font.BOLD, 15));
		accno.setBounds(200, 530, 152, 26);
		contentPane.add(accno);
		
		JLabel bankno = new JLabel("");
		bankno.setForeground(Color.BLACK);
		bankno.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bankno.setBounds(200, 583, 165, 26);
		contentPane.add(bankno);
		
		JLabel orgname = new JLabel("");
		orgname.setForeground(Color.BLACK);
		orgname.setFont(new Font("Times New Roman", Font.BOLD, 20));
		orgname.setHorizontalAlignment(SwingConstants.CENTER);
		orgname.setBounds(12, 0, 380, 34);
		contentPane.add(orgname);
		
		orgname.setText(LoginPage.orgname);
		
		JLabel lblInvoice = new JLabel("INVOICE ");
		lblInvoice.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblInvoice.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvoice.setBounds(12, 45, 367, 26);
		contentPane.add(lblInvoice);
		
		JButton btnPrintInvoice = new JButton("Print Invoice");
		btnPrintInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				JOptionPane.showMessageDialog(null, "Invoice Printed");
				PaySalary pg = new PaySalary();
				pg.show();
			}
		});
		btnPrintInvoice.setForeground(Color.BLACK);
		btnPrintInvoice.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnPrintInvoice.setBounds(200, 642, 144, 25);
		contentPane.add(btnPrintInvoice);
		
		try {
			PreparedStatement ps = Database.conn.prepareStatement("select employee.empid,concat(f_name,' ',m_name,' ',l_name) as name,date,leaves,leave_reduction_amount,bonus,tax_amount,net_salary,acc_number,bank_code from  employee  natural join salary_invoices join account on (account.acc_id= salary_invoices.acc_id) where employee.empid=?  and  date=curdate() order by transactionid;");
			PreparedStatement ps2 = Database.conn.prepareStatement("select org_name from organization where orgid=?");
			ps2.setInt(1, LoginPage.orgid);
			ps.setInt(1, PaySalary.x);
			ResultSet rs = ps.executeQuery();
			ResultSet rs2 =ps2.executeQuery();
			while(rs2.next())
			{
				orgname.setText(rs2.getString(1));
			}
			while(rs.next())
			{
				id.setText(rs.getString(1));
				name.setText(rs.getString(2).toUpperCase());
				date.setText(rs.getString(3));	
				leaves.setText(rs.getString(4));
				leaveredamt.setText(rs.getString(5));
				bonus.setText(rs.getString(6));
				taxamt.setText(rs.getString(7));
				netsal.setText(rs.getString(8));
				accno.setText(rs.getString(9));
				bankno.setText(rs.getString(10));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
